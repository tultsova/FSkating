package com.example.fskating.models;

import androidx.annotation.NonNull;



public class ModelCompetition {

    private Long id;
    private String data;
    private String dataFormated;
    private String competitionName;

    public ModelCompetition(Long id, String dataFormated, String data, String competitionName) {
        this.id = id;
        this.data = data;
        this.dataFormated = dataFormated;
        this.competitionName = competitionName;
    }

    @NonNull
    public Long getId() {
        return id;
    }

    public void setId(@NonNull Long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public String getDataFormated() {
        return dataFormated;
    }

    public void setDataFormated(String dataFormated) {
        this.dataFormated = dataFormated;
    }

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }
}
