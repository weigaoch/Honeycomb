package com.polycom.mediasuite.api;

import com.polycom.MediaSuite;
import com.polycom.mediasuite.api.internal.userportal.LoginTokenResource;
import com.polycom.mediasuite.api.internal.userportal.dto.LoginResult;
import jodd.http.HttpRequest;

/**
 * Created by wgao on 6/12/2016.
 */
public class UserPortalApiClient extends RestApiClient<LoginResult> {

    public final LoginTokenResource loginTokenResource;
//    public final CallResource callResource;

    public UserPortalApiClient(MediaSuite mediaSuite) {
        super(mediaSuite);

        this.loginTokenResource = new LoginTokenResource(this);
//        this.callResource = new CallResource(this);
    }

    @Override
    protected void login() {
        loginTokenResource.newToken();
    }

    @Override
    protected HttpRequest addToken2Header(HttpRequest request) {
        request.header("token", loginResult.getToken());
        return request;
    }

}
