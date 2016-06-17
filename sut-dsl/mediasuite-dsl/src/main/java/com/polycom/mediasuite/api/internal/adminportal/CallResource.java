package com.polycom.mediasuite.api.internal.adminportal;

import com.polycom.csc.commons.api.call.PlcmCscCallInfo;
import com.polycom.csc.commons.api.call.PlcmCscDialInfo;
import com.polycom.mediasuite.api.AdminPortalApiClient;
import com.polycom.rest.JsonUtils;
import com.polycom.rest.RestException;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * Created by wgao on 6/14/2016.
 */
public class CallResource {
    private static Logger logger = LoggerFactory.getLogger(CallResource.class);

    private final String url = "/msc/rest/calls";

    private final String cscJsonType = "application/vnd.plcm.plcm-csc+json";

    private final AdminPortalApiClient adminPortalApiClient;

    public CallResource(AdminPortalApiClient adminPortalApiClient) {
        this.adminPortalApiClient = adminPortalApiClient;
    }

    public PlcmCscCallInfo startCall(PlcmCscDialInfo dialInfo) {
        HttpRequest request = new HttpRequest();
        request
                .method("POST")
                .protocol("http")
                .host(adminPortalApiClient.mediaSuite.ip)
                .path(url)
                .bodyText(JsonUtils.getInstance().toJson(dialInfo), cscJsonType)
                .header("Accept", cscJsonType);
        logger.info("startCall():request\n" + request.toString());

        HttpResponse response = adminPortalApiClient.send(request);
        logger.info("startCall():response\n" + response.toString());

        int statusCode = response.statusCode();
        if (statusCode != 200) {
            throw new RestException(statusCode);
        }
        PlcmCscCallInfo callInfo = JsonUtils.getInstance().fromJson(response.bodyText(), PlcmCscCallInfo.class);

        return callInfo;
    }

    public void endCall(String callId) {
        HttpRequest request = new HttpRequest();
        request
                .method("PUT")
                .protocol("http")
                .host(adminPortalApiClient.mediaSuite.ip)
                .path(url + "/" + callId + "/stop")
                .header("Accept", cscJsonType);
        logger.info("endCall():request\n" + request.toString());

        HttpResponse response = adminPortalApiClient.send(request);
        logger.info("endCall():response\n" + response.toString());

        int statusCode = response.statusCode();
        if (statusCode != 204) {
            throw new RestException(statusCode);
        }

    }

    public List<PlcmCscCallInfo> getCallList() {
        HttpRequest request = new HttpRequest();
        request
                .method("GET")
                .protocol("http")
                .host(adminPortalApiClient.mediaSuite.ip)
                .path(url)
                .header("Accept", cscJsonType);
        logger.info("getCallList():request\n" + request.toString());

        HttpResponse response = adminPortalApiClient.send(request);
        logger.info("getCallList():response\n" + response.toString());

        int statusCode = response.statusCode();
        if (statusCode > 299 || statusCode < 200) {
            throw new RestException(statusCode);
        }

        PlcmCscCallInfo[] calls = JsonUtils.getInstance().fromJson(response.bodyText(), PlcmCscCallInfo[].class);
        return Arrays.asList(calls);
    }
}

