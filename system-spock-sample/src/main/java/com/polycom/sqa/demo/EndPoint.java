package com.polycom.sqa.demo;

/**
 * Created by wgao on 6/15/2016.
 */
public interface EndPoint <T extends EndPoint<T>> {

    T placeCall(EndPoint<?> callee);

    T hangup();

    String getMediaStatistics();

}
