package com.polycom.mediasuite.api;

import com.polycom.CallType;
import com.polycom.MediaSuite;
import com.polycom.api.rest.plcm_recording_info.AddressType;
import com.polycom.csc.commons.api.PlcmCscTicket;
import com.polycom.mediasuite.api.internal.adminportal.LoginTokenResource;
import com.polycom.mediasuite.api.publish.CallResource;
import jdk.nashorn.internal.codegen.CompilerConstants;
import jodd.http.HttpRequest;

/**
 * Created by wgao on 6/16/2016.
 */
public class PublishApiClient extends RestApiClient<PlcmCscTicket> {

    public final LoginTokenResource loginTokenResource;
    public final CallResource callResource;


    public PublishApiClient(MediaSuite mediaSuite) {
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

    public AddressType convertCallType(CallType callType) {
        switch (callType) {
            case H323:
                return AddressType.h323Id;
            case SIP:
                return AddressType.sip;
        }
        throw new RuntimeException("Not support call type" + callType.toString());
    }
}
