package com.polycom.sqa.demo;

/**
 * Created by wgao on 6/15/2016.
 */
public class RpdWin implements EndPoint<RpdWin> {

    @Override
    public RpdWin placeCall(EndPoint<?> callee) {
        return this;
    }

    @Override
    public RpdWin hangup() {
        return this;
    }

    @Override
    public String getMediaStatistics() {
        return "456";
    }

}
