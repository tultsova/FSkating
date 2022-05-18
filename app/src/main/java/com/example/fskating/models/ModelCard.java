package com.example.fskating.models;

import androidx.annotation.NonNull;

public class ModelCard {

    private Long idCard;
    private Integer res;
    private Integer resProfile;
    private String name;
    private String coachingStaff;
    private String SP;
    private String FP;
    private String UrlSP;
    private String UrlFP;

    public ModelCard(Long idCard, Integer res, Integer resProfile,String name, String coachingStaff,
                     String SP, String FP, String UrlSP, String UrlFP) {
        this.idCard = idCard;
        this.name = name;
        this.res = res;
        this.resProfile = resProfile;
        this.coachingStaff = coachingStaff;
        this.SP = SP;
        this.FP = FP;
        this.UrlSP = UrlSP;
        this.UrlFP = UrlFP;
    }

    public Integer getResProfile() {
        return resProfile;
    }

    public void setResProfile(Integer resProfile) {
        this.resProfile = resProfile;
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

    public String getUrlSP() {
        return UrlSP;
    }

    public void setUrlSP(String urlSP) {
        UrlSP = urlSP;
    }

    public String getUrlFP() {
        return UrlFP;
    }

    public void setUrlFP(String urlFP) {
        UrlFP = urlFP;
    }

    public Integer getRes() {
        return res;
    }

    public void setRes(Integer res) {
        this.res = res;
    }

    public void setFP(String FP) {
        this.FP = FP;
    }
}
