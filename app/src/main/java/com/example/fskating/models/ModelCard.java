package com.example.fskating.models;

import androidx.annotation.NonNull;

public class ModelCard {

    private Long idCard;
    private String name;
    private String coachingStaff;
    private String SP;
    private String FP;

    public ModelCard(Long idCard, String name, String coachingStaff, String SP, String FP) {
        this.idCard = idCard;
        this.name = name;
        this.coachingStaff = coachingStaff;
        this.SP = SP;
        this.FP = FP;
    }

    @NonNull
    public Long getIdCard() {
        return idCard;
    }

    public void setIdCard(Long idCard) {
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoachingStaff() {
        return coachingStaff;
    }

    public void setCoachingStaff(String coachingStaff) {
        this.coachingStaff = coachingStaff;
    }

    public String getSP() {
        return SP;
    }

    public void setSP(String SP) {
        this.SP = SP;
    }

    public String getFP() {
        return FP;
    }

    public void setFP(String FP) {
        this.FP = FP;
    }
}
