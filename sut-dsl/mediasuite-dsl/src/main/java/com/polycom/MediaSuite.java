package com.polycom;

import com.polycom.api.rest.plcm_recording_info.PlcmRecordingInfo;
import com.polycom.csc.commons.api.call.PlcmCscCallInfo;
import com.polycom.mediasuite.api.PublishApiClient;
import com.polycom.mediasuite.api.AdminPortalApiClient;
import com.polycom.mediasuite.api.UserPortalApiClient;

public class MediaSuite implements EndPoint<MediaSuite> {

    public static final String DEFAULT_VRR_ID = "defaultvrrId";
		
	public final String ip;
	public final String loginUserName;
	public final String loginPassword;

    private final UserPortalApiClient userPortalApiClient;
    private final AdminPortalApiClient adminPortalApiClient;
    private final PublishApiClient publishApiClient;
	
	public MediaSuite(String ip, String loginUserName, String loginPassword) {
		this.ip = ip;
		this.loginUserName = loginUserName;
		this.loginPassword = loginPassword;

        userPortalApiClient = new UserPortalApiClient(this);
		adminPortalApiClient = new AdminPortalApiClient(this);
        publishApiClient = new PublishApiClient(this);
	}
	
	@Override
	public String getDialString(CallType callType) {
		// TODO Auto-generated method stub
		return null;
	}

    @Override
    public MediaSuite placeCall(EndPoint<?> callee, CallType callType) {
        return placeCall(callee.getDialString(callType), callType);
    }

    @Override
    public MediaSuite placeCall(String dialString, CallType callType) {
        PlcmRecordingInfo dialInfo = new PlcmRecordingInfo();
        dialInfo.setTargetAddress(dialString);
        dialInfo.setSubject("Automation-" + dialString);
        dialInfo.setAddressType(publishApiClient.convertCallType(callType));
        dialInfo.setVrrId(MediaSuite.DEFAULT_VRR_ID);
        publishApiClient.callResource.startCall(dialInfo);
        return this;
    }

    @Override
    public MediaSuite hangup() {
        for (PlcmCscCallInfo call: adminPortalApiClient.callResource.getCallList()) {
            adminPortalApiClient.callResource.endCall(call.getCallId());
        }

        return this;
    }

    public UserPortalApiClient userPortalApi() {
        return userPortalApiClient;
    }

    public AdminPortalApiClient adminPortalApi() {
        return adminPortalApiClient;
    }

    public PublishApiClient publishApiClient() {
        return publishApiClient;
    }


    public static void main(String[] args) {
        MediaSuite mediaSuite = new MediaSuite("10.220.205.9", "admin", "Polycom12#$");
//        mediaSuite.adminPortalApi().loginTokenResource.newToken();

        mediaSuite.placeCall("10.250.52.70", CallType.H323);

        try {
            Thread.sleep(20 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        mediaSuite.hangup();
    }

}
