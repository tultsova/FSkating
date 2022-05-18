package com.example.fskating;

import android.app.Application;
import android.os.Looper;
import android.os.Message;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.fskating.models.ModelCard;
import com.example.fskating.models.ModelCompetition;
import com.example.fskating.models.ModelVideo;

import java.util.List;
import android.os.Handler;

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
            public void handleMessage(Message message) {
                super.handleMessage(message);
                List<ModelCompetition> competitions = (List<ModelCompetition>) message.obj;
                mutableLiveData.postValue(competitions);
            }
        });
        return mutableLiveData;
    }

    public LiveData<List<ModelCard>> getAllCards() {
        MutableLiveData<List<ModelCard>> mutableLiveData = new MutableLiveData<>();
        api.getAllCards(new Handler(Looper.getMainLooper()){
            @Override
            public void handleMessage(Message message) {
                super.handleMessage(message);
                List<ModelCard> cards = (List<ModelCard>) message.obj;
                mutableLiveData.postValue(cards);
            }
        });
        return mutableLiveData;
    }

    public LiveData<ModelCard> getCardInfo(Long id) {
        MutableLiveData<ModelCard> mutableLiveData = new MutableLiveData<>();
        api.getCardInfo(id, new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message message) {
                super.handleMessage(message);
                ModelCard card = (ModelCard) message.obj;
                mutableLiveData.postValue(card);
            }
        });
        return mutableLiveData;
    }

    public LiveData<List<ModelVideo>> getAllVideo() {
        MutableLiveData<List<ModelVideo>> mutableLiveData = new MutableLiveData<>();
        api.getAllVideo(new Handler(Looper.getMainLooper()){
            @Override
            public void handleMessage(Message message) {
                super.handleMessage(message);
                List<ModelVideo> video = (List<ModelVideo>) message.obj;
                mutableLiveData.postValue(video);
            }
        });
        return mutableLiveData;
    }
}
