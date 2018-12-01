package com.utildev.arch.architecturecomponents.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.utildev.arch.architecturecomponents.common.base.BaseModel;
import com.utildev.arch.architecturecomponents.data.remote.stackexchange.RestBadgeCountSE;

public class ItemUserSE extends BaseModel {
    private int accountId;
    private Boolean isEmployee;
    private int lastModifiedDate;
    private int lastAccessDate;
    private int reputationChangeYear;
    private int reputationChangeQuarter;
    private int reputationChangeMonth;
    private int reputationChangeWeek;
    private int reputationChangeDay;
    private int reputation;
    private int creationDate;
    private String userType;
    private int userId;
    private int acceptRate;
    private String location;
    private String websiteUrl;
    private String link;
    private String profileImage;
    private String displayName;
    private int bronze;
    private int silver;
    private int gold;

    public int getAccountId() {
        return accountId;
    }

    public Boolean getIsEmployee() {
        return isEmployee;
    }

    public int getLastModifiedDate() {
        return lastModifiedDate;
    }

    public int getLastAccessDate() {
        return lastAccessDate;
    }

    public int getReputationChangeYear() {
        return reputationChangeYear;
    }

    public int getReputationChangeQuarter() {
        return reputationChangeQuarter;
    }

    public int getReputationChangeMonth() {
        return reputationChangeMonth;
    }

    public int getReputationChangeWeek() {
        return reputationChangeWeek;
    }

    public int getReputationChangeDay() {
        return reputationChangeDay;
    }

    public int getReputation() {
        return reputation;
    }

    public int getCreationDate() {
        return creationDate;
    }

    public String getUserType() {
        return userType != null ? userType : "";
    }

    public int getUserId() {
        return userId;
    }

    public int getAcceptRate() {
        return acceptRate;
    }

    public String getLocation() {
        return location != null ? location : "";
    }

    public String getWebsiteUrl() {
        return websiteUrl != null ? websiteUrl : "";
    }

    public String getLink() {
        return link != null ? link : "";
    }

    public String getProfileImage() {
        return profileImage != null ? profileImage : "";
    }

    public String getDisplayName() {
        return displayName != null ? displayName : "";
    }

    public int getBronze() {
        return bronze;
    }

    public int getSilver() {
        return silver;
    }

    public int getGold() {
        return gold;
    }
}
