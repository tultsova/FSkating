package com.example.fskating.view_models;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.fskating.Repository;
import com.example.fskating.models.ModelCompetition;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class ViewModelCalendarCompetition extends AndroidViewModel {
    private final Repository repository;

    @Inject
    public ViewModelCalendarCompetition(@NonNull Application application, Repository repository) {
        super(application);
        this.repository=repository;
    }

    public LiveData<List<ModelCompetition>> getAllCompetitions() {
        return repository.getAllCompetitions();
    }
}

