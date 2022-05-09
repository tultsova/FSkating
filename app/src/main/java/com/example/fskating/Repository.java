package com.example.fskating;

import android.app.Application;
import android.os.Looper;
import android.os.Message;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.fskating.models.ModelCompetition;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Repository {

    private final API api;

    @Inject
    public Repository(Application application) {
        api = new NetworkMock();
    }

    public LiveData<List<ModelCompetition>> getAllCompetitions() {
        MutableLiveData<List<ModelCompetition>> mutableLiveData = new MutableLiveData<>();
        api.getAllCompetitions(new Handler(Looper.getMainLooper()){
            @Override
            public void handlerMessage(Message message) {
                super.handlerMessage(message);
                List<ModelCompetition> competitions = (List<ModelCompetition>) message.obj;
                mutableLiveData.postValue(competitions);
            }
        });
        return mutableLiveData;
    }
}
