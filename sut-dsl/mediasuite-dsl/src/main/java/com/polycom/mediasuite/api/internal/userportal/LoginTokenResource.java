package com.polycom.mediasuite.api.internal.userportal;

import com.polycom.mediasuite.api.RestApiClient;
import com.polycom.mediasuite.api.internal.userportal.dto.LoginResult;
import com.polycom.mediasuite.api.internal.userportal.dto.LoginUser;
import com.polycom.rest.JsonUtils;
import com.polycom.rest.RestException;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wgao on 6/12/2016.
 */
public class LoginTokenResource {
    private static Logger logger = LoggerFactory.getLogger(LoginTokenResource.class);

    private final String url = "/userportal/api/rest/users/login";

    private final String loginUserJsonType = "application/vnd.plcm.plcm-login-user+json";
    private final String loginResultJsonType = "application/vnd.plcm.plcm-login-result+json";

    private final RestApiClient<LoginResult> restApiClient;

    public LoginTokenResource(RestApiClient<LoginResult> userPortalApiClient) {
        this.restApiClient = userPortalApiClient;
    }

    public LoginResult newToken() {
        LoginUser loginUser = new LoginUser();
        loginUser.setLoginName(restApiClient.mediaSuite.loginUserName);
        loginUser.setPassword(restApiClient.mediaSuite.loginPassword);
        loginUser.setLoginType(1);
        return newToken(loginUser);
    }

    public LoginResult newToken(LoginUser loginUser) {
        HttpRequest request = new HttpRequest();
        request
                .method("POST")
                .protocol("http")
                .host(restApiClient.mediaSuite.ip)
                .path(url)
                .bodyText(JsonUtils.getInstance().toJson(loginUser), loginUserJsonType)
                .header("Accept", loginResultJsonType);
        logger.info("newToken():request\n" + request.toString());

        HttpResponse response = request.send();
        logger.info("newToken():response\n" + response.toString());

        int statusCode = response.statusCode();
        if (statusCode != 200) {
            throw new RestException(statusCode);
        }
        LoginResult loginResult = JsonUtils.getInstance().fromJson(response.bodyText(), LoginResult.class);
        restApiClient.loginResult = loginResult;
        return loginResult;
    }

}
