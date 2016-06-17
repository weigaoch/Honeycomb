package com.polycom.mediasuite.api.internal.adminportal;

import com.polycom.csc.commons.api.PlcmCscLoginInfo;
import com.polycom.csc.commons.api.PlcmCscTicket;
import com.polycom.mediasuite.api.RestApiClient;
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

    private final String url = "/msc/rest/accessToken";

    private final String cscJsonType = "application/vnd.plcm.plcm-csc+json";

    private final RestApiClient<PlcmCscTicket> restApiClient;

    public LoginTokenResource(RestApiClient<PlcmCscTicket> adminPortalClient) {
        this.restApiClient = adminPortalClient;
    }

    public PlcmCscTicket newToken() {
        PlcmCscLoginInfo loginUser = new PlcmCscLoginInfo();
        loginUser.setUserName(restApiClient.mediaSuite.loginUserName);
        loginUser.setPassword(restApiClient.mediaSuite.loginPassword);
        return newToken(loginUser);
    }

    public PlcmCscTicket newToken(PlcmCscLoginInfo loginUser) {
        HttpRequest request = new HttpRequest();
        request
                .method("POST")
                .protocol("http")
                .host(restApiClient.mediaSuite.ip)
                .path(url)
                .bodyText(JsonUtils.getInstance().toJson(loginUser), cscJsonType)
                .header("Accept", cscJsonType);
        logger.info("newToken():request\n" + request.toString());

        HttpResponse response = request.send();
        logger.info("newToken():response\n" +response.toString());

        int statusCode = response.statusCode();
        if (statusCode != 200) {
            throw new RestException(statusCode);
        }
        PlcmCscTicket loginResult = JsonUtils.getInstance().fromJson(response.bodyText(), PlcmCscTicket.class);
        restApiClient.loginResult = loginResult;
        return loginResult;
    }
}
