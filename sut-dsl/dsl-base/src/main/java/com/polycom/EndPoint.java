package com.polycom;

public interface EndPoint <T extends EndPoint<T>> {
	
	String getDialString(CallType callType);

	T placeCall(EndPoint<?> callee, CallType callType);

	T placeCall(String dialString, CallType callType);

	T hangup();
	
}
