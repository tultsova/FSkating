package com.example.fskating.view_models;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.fskating.Repository;
import com.example.fskating.models.ModelCard;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class ViewModelCards extends AndroidViewModel {
    private final Repository repository;
    private final MutableLiveData<List<ModelCard>> cards;

    @Inject
    public ViewModelCards(@NonNull Application application, Repository repository) {
        super(application);
        this.repository=repository;
        this.cards = new MutableLiveData<>();
        repository.getAllCards(cards);
    }

    public void inputName(String name) {
        repository.getAllCardsByName(name, cards);
    }

    public MutableLiveData<List<ModelCard>> getCards() {
        return cards;
    }
}
