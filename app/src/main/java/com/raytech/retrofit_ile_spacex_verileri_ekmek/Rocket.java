package com.raytech.retrofit_ile_spacex_verileri_ekmek;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rocket {
    @SerializedName("rocket_id")
    String rocketId;

    @SerializedName("rocket_name")
    String rocketName;

    @SerializedName("rocket_type")
    String rocketType;

    public String getRocketType() {
        return rocketType;
    }

    public void setRocketType(String rocketType) {
        this.rocketType = rocketType;
    }

    public String getRocketId() {
        return rocketId;
    }

    public void setRocketId(String rocketId) {
        this.rocketId = rocketId;
    }

    public String getRocketName() {
        return rocketName;
    }

    public void setRocketName(String rocketName) {
        this.rocketName = rocketName;
    }
}
