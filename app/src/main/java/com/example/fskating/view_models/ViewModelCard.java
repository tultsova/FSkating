package com.example.fskating.view_models;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.fskating.Repository;
import com.example.fskating.models.ModelCard;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class ViewModelCard extends AndroidViewModel {
    private final Repository repository;

    @Inject
    public ViewModelCard(@NonNull Application application, Repository repository) {
        super(application);
        this.repository=repository;
    }

    public LiveData<ModelCard> getCardInfo(Long id) {
        return repository.getCardInfo(id);
    }
}
