package com.utildev.arch.architecturecomponents.data.remote.stackexchange;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.utildev.arch.architecturecomponents.common.base.BaseModel;

public class RestBadgeCountSE extends BaseModel {
    @SerializedName("bronze")
    @Expose
    private int bronze;
    @SerializedName("silver")
    @Expose
    private int silver;
    @SerializedName("gold")
    @Expose
    private int gold;

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
