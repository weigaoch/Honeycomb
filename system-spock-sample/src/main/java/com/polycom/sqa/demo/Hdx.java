package com.polycom.sqa.demo;

/**
 * Created by wgao on 6/15/2016.
 */
public class Hdx implements EndPoint<Hdx> {
    @Override
    public Hdx placeCall(EndPoint<?> callee) {
        return this;
    }

    @Override
    public Hdx hangup() {
        return this;
    }

    @Override
    public String getMediaStatistics() {
        return "789";
    }
}
