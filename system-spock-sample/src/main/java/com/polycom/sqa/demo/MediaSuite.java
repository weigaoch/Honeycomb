package com.polycom.sqa.demo;

/**
 * Created by wgao on 6/15/2016.
 */
public class MediaSuite implements EndPoint<MediaSuite> {


    @Override
    public MediaSuite placeCall(EndPoint<?> callee) {
        return this;
    }

    @Override
    public MediaSuite hangup() {
        throw new HangupFail("Just a joke");
    }

    @Override
    public String getMediaStatistics() {
        return "123";
    }
}
