package com.polycom.mediasuite.api.internal.userportal.dto;

/**
 * Created by wgao on 6/12/2016.
 */
public class Group {

    private String groupId;

    private String groupType;

    private String groupName;


    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
