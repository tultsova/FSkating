package com.example.fskating.view_models;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.fskating.Repository;
import com.example.fskating.models.ModelCard;
import com.example.fskating.models.ModelVideo;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class ViewModelVideo extends AndroidViewModel {
    private final Repository repository;
    private final MutableLiveData<List<ModelVideo>> video;

    @Inject
    public ViewModelVideo(@NonNull Application application, Repository repository) {
        super(application);
        this.repository=repository;
        this.video = new MutableLiveData<>();
        repository.getAllVideo(video);
    }

    public void inputName(String name) {
        repository.getAllVideoByName(name, video);
    }

    public MutableLiveData<List<ModelVideo>> getVideo() {
        return video;
    }
}
