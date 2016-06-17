package com.polycom.mediasuite.api.internal.userportal.dto;

/**
 * Created by wgao on 6/12/2016.
 */
public class DialInfo {

    private String addressType;

    private String categoryId;

    private String[] channelIds;

    private String description;

    private String eventNumber;

    private String layoutType;

    private String quickCode;

    private String subject;

    private String[] tags;

    private String targetAddress;

    private String targetAddress2;

    private String userId;

    private String vrrId;

    private boolean waitAck;

    private boolean isPlaybackNow;

    private boolean autoRecording;

    private boolean enableRecording;

    private boolean enableLiveStreaming;

    private String conferenceLayoutType;


    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String[] getChannelIds() {
        return channelIds;
    }

    public void setChannelIds(String[] channelIds) {
        this.channelIds = channelIds;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEventNumber() {
        return eventNumber;
    }

    public void setEventNumber(String eventNumber) {
        this.eventNumber = eventNumber;
    }

    public String getLayoutType() {
        return layoutType;
    }

    public void setLayoutType(String layoutType) {
        this.layoutType = layoutType;
    }

    public String getQuickCode() {
        return quickCode;
    }

    public void setQuickCode(String quickCode) {
        this.quickCode = quickCode;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
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

    public boolean isWaitAck() {
        return waitAck;
    }

    public void setWaitAck(boolean waitAck) {
        this.waitAck = waitAck;
    }

    public boolean getIsPlaybackNow() {
        return isPlaybackNow;
    }

    public void setIsPlaybackNow(boolean isPlaybackNow) {
        isPlaybackNow = isPlaybackNow;
    }

    public boolean isAutoRecording() {
        return autoRecording;
    }

    public void setAutoRecording(boolean autoRecording) {
        this.autoRecording = autoRecording;
    }

    public boolean isEnableRecording() {
        return enableRecording;
    }

    public void setEnableRecording(boolean enableRecording) {
        this.enableRecording = enableRecording;
    }

    public boolean isEnableLiveStreaming() {
        return enableLiveStreaming;
    }

    public void setEnableLiveStreaming(boolean enableLiveStreaming) {
        this.enableLiveStreaming = enableLiveStreaming;
    }

    public String getConferenceLayoutType() {
        return conferenceLayoutType;
    }

    public void setConferenceLayoutType(String conferenceLayoutType) {
        this.conferenceLayoutType = conferenceLayoutType;
    }
}
