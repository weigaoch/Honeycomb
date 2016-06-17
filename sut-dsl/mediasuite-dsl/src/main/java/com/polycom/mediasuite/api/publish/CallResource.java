package com.polycom.mediasuite.api.publish;

import com.polycom.api.rest.plcm_recording_info.PlcmRecordingInfo;
import com.polycom.mediasuite.api.PublishApiClient;
import com.polycom.rest.JsonUtils;
import com.polycom.rest.RestException;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wgao on 6/16/2016.
 */
public class CallResource {
    private static Logger logger = LoggerFactory.getLogger(CallResource.class);

    private final String url = "/api/rest/calls";
    private final String cscJsonType = "application/vnd.plcm.plcm-recording-info+json";

    private final PublishApiClient publishApiClient;

    public CallResource(PublishApiClient publishApiClient) {
        this.publishApiClient = publishApiClient;
    }

    public PlcmRecordingInfo startCall(PlcmRecordingInfo dialInfo) {
        HttpRequest request = new HttpRequest();
        request
                .method("POST")
                .protocol("http")
                .host(publishApiClient.mediaSuite.ip)
                .path(url)
                .bodyText(JsonUtils.getInstance().toJson(dialInfo), cscJsonType)
                .header("Accept", cscJsonType);
        logger.info("startCall():request\n" + request.toString());

        HttpResponse response = publishApiClient.send(request);
        logger.info("startCall():response\n" + response.toString());

        int statusCode = response.statusCode();
        if (statusCode != 200) {
            throw new RestException(statusCode);
        }
        PlcmRecordingInfo callInfo = JsonUtils.getInstance().fromJson(response.bodyText(), PlcmRecordingInfo.class);

        return callInfo;
    }

}

