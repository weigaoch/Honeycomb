package com.polycom.mediasuite.api.internal.userportal.dto;

/**
 * Created by wgao on 6/12/2016.
 */
public class CallInfo {

    private CallConnectionInfo[] callConnectionInfo;

    private String callId;

    private String callStatus;

    private String coverUrl;

    private String description;

    private boolean enableRecording;

    private String failureReason;

    private boolean isPlaybackCall;

    private boolean layoutTypeChangeable;

    private boolean liveStreamingEnabled;

    private String preLinkEventNumber;

    private String quickCode;

    private String recordingStatus;

    private long startCallTime;

    private String subject;

    private String targetAddress;

    private String targetAddress2;

    private String userId;

    private String vrrId;


    public CallConnectionInfo[] getCallConnectionInfo() {
        return callConnectionInfo;
    }

    public void setCallConnectionInfo(CallConnectionInfo[] callConnectionInfo) {
        this.callConnectionInfo = callConnectionInfo;
    }

    public String getCallId() {
        return callId;
    }

    public void setCallId(String callId) {
        this.callId = callId;
    }

    public String getCallStatus() {
        return callStatus;
    }

    public void setCallStatus(String callStatus) {
        this.callStatus = callStatus;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEnableRecording() {
        return enableRecording;
    }

    public void setEnableRecording(boolean enableRecording) {
        this.enableRecording = enableRecording;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }

    public boolean isPlaybackCall() {
        return isPlaybackCall;
    }

    public void setPlaybackCall(boolean playbackCall) {
        isPlaybackCall = playbackCall;
    }

    public boolean isLayoutTypeChangeable() {
        return layoutTypeChangeable;
    }

    public void setLayoutTypeChangeable(boolean layoutTypeChangeable) {
        this.layoutTypeChangeable = layoutTypeChangeable;
    }

    public boolean isLiveStreamingEnabled() {
        return liveStreamingEnabled;
    }

    public void setLiveStreamingEnabled(boolean liveStreamingEnabled) {
        this.liveStreamingEnabled = liveStreamingEnabled;
    }

    public String getPreLinkEventNumber() {
        return preLinkEventNumber;
    }

    public void setPreLinkEventNumber(String preLinkEventNumber) {
        this.preLinkEventNumber = preLinkEventNumber;
    }

    public String getQuickCode() {
        return quickCode;
    }

    public void setQuickCode(String quickCode) {
        this.quickCode = quickCode;
    }

    public String getRecordingStatus() {
        return recordingStatus;
    }

    public void setRecordingStatus(String recordingStatus) {
        this.recordingStatus = recordingStatus;
    }

    public long getStartCallTime() {
        return startCallTime;
    }

    public void setStartCallTime(long startCallTime) {
        this.startCallTime = startCallTime;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTargetAddress() {
        return targetAddress;
    }

    public void setTargetAddress(String targetAddress) {
        this.targetAddress = targetAddress;
    }

    public String getTargetAddress2() {
        return targetAddress2;
    }

    public void setTargetAddress2(String targetAddress2) {
        this.targetAddress2 = targetAddress2;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getVrrId() {
        return vrrId;
    }

    public void setVrrId(String vrrId) {
        this.vrrId = vrrId;
    }
}
