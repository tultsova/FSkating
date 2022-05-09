package com.example.fskating;

import androidx.lifecycle.LiveData;

import com.example.fskating.models.ModelCompetition;

import java.util.List;
import java.util.logging.Handler;

public interface API {
    void insertCompetition(ModelCompetition modelCompetition, Handler handler);
    LiveData<List<ModelCompetition>> getAllCompetitions(Handler handler);
}
