package com.polycom.mediasuite.api.internal.userportal;

import com.polycom.mediasuite.api.UserPortalApiClient;
import com.polycom.mediasuite.api.internal.userportal.dto.CallInfo;
import com.polycom.mediasuite.api.internal.userportal.dto.DialInfo;
import com.polycom.rest.JsonUtils;
import com.polycom.rest.RestException;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by wgao on 6/12/2016.
 */
public class CallResource {
    private static Logger logger = LoggerFactory.getLogger(CallResource.class);

    private final String url = "/userportal/api/rest/content/calls";

    private final String dialInfoJsonType = "application/vnd.plcm.plcm-content-dial-info+json";
    private final String callInfoJsonType = "application/vnd.plcm.plcm-content-call-info+json";
    private final String callInfoListJsonType = "application/vnd.plcm.plcm-content-user-call-list+json";
    private final String cscJsonType = "application/vnd.plcm.plcm-csc+json";

    private final UserPortalApiClient userPortalApiClient;

    public CallResource(UserPortalApiClient userPortalApiClient) {
        this.userPortalApiClient = userPortalApiClient;
    }

    public CallInfo startCall(DialInfo dialInfo) {
        HttpRequest request = new HttpRequest();
        request
                .method("POST")
                .protocol("http")
                .host(userPortalApiClient.mediaSuite.ip)
                .path(url)
                .bodyText(JsonUtils.getInstance().toJson(dialInfo), dialInfoJsonType)
                .header("Accept", callInfoJsonType);
        logger.info("startCall():request\n" + request.toString());

        HttpResponse response = userPortalApiClient.send(request);
        logger.info("startCall():response\n" + response.toString());

        int statusCode = response.statusCode();
        if (statusCode != 200) {
            throw new RestException(statusCode);
        }
        CallInfo callInfo = JsonUtils.getInstance().fromJson(response.bodyText(), CallInfo.class);

        return callInfo;
    }

    public void endCall(String callId) {
        HttpRequest request = new HttpRequest();
        request
                .method("PUT")
                .protocol("http")
                .host(userPortalApiClient.mediaSuite.ip)
                .path(url + "/" + callId + "/stop")
                .header("Accept", cscJsonType);
        logger.info("endCall():request\n" + request.toString());

        HttpResponse response = userPortalApiClient.send(request);
        logger.info("endCall():response\n" + response.toString());

        int statusCode = response.statusCode();
        if (statusCode != 204) {
            throw new RestException(statusCode);
        }

    }

}
