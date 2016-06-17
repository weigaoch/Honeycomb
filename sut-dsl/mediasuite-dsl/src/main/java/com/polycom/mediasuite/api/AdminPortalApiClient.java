package com.polycom.mediasuite.api;

import com.polycom.MediaSuite;
import com.polycom.csc.commons.api.PlcmCscTicket;
import com.polycom.mediasuite.api.RestApiClient;
import com.polycom.mediasuite.api.internal.adminportal.CallResource;
import com.polycom.mediasuite.api.internal.adminportal.LoginTokenResource;
import jodd.http.HttpRequest;

/**
 * Created by wgao on 6/14/2016.
 */
public class AdminPortalApiClient extends RestApiClient<PlcmCscTicket> {

    public final LoginTokenResource loginTokenResource;
    public final CallResource callResource;


    public AdminPortalApiClient(MediaSuite mediaSuite) {
        super(mediaSuite);

        this.loginTokenResource = new LoginTokenResource(this);
        this.callResource = new CallResource(this);
    }

    @Override
    protected void login() {
        loginTokenResource.newToken();
    }

    @Override
    protected HttpRequest addToken2Header(HttpRequest request) {
        request.header("Authorization", "Bearer " + loginResult.getToken());
        return request;
    }

}
