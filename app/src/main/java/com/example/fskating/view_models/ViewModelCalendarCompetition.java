package com.example.fskating.view_models;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.fskating.Repository;
import com.example.fskating.models.ModelCard;
import com.example.fskating.models.ModelCompetition;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class ViewModelCalendarCompetition extends AndroidViewModel {
    private final Repository repository;
    private final MutableLiveData<List<ModelCompetition>> competitions;

    @Inject
    public ViewModelCalendarCompetition(@NonNull Application application, Repository repository) {
        super(application);
        this.repository=repository;
        this.competitions = new MutableLiveData<>();
        repository.getAllCompetitions(competitions);
    }

    public MutableLiveData<List<ModelCompetition>> getCompetitions() {
        return competitions;
    }

    public void inputDate(String date) {
        repository.getComprtitionByDate(date, competitions);
    }
}

