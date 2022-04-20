package com.example.fskating.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.UUID;

@Entity(tableName = "competition_table")
public class ModelCompetition {
    @PrimaryKey
    @NonNull
    private Long id;
    private String data;
    private String competitionName;

    public ModelCompetition(Long id,String data, String competitionName) {
        this.id = id;
        this.data = data;
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

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }
}
