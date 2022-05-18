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

    public void getAllCompetitions(MutableLiveData<List<ModelCompetition>> competitonsList) {
        api.getAllCompetitions(new Handler(Looper.getMainLooper()){
            @Override
            public void handleMessage(Message message) {
                super.handleMessage(message);
                List<ModelCompetition> competitions = (List<ModelCompetition>) message.obj;
                competitonsList.postValue(competitions);
            }
        });
    }

    public void getAllCards(MutableLiveData<List<ModelCard>> cardsList) {
        api.getAllCards(new Handler(Looper.getMainLooper()){
            @Override
            public void handleMessage(Message message) {
                super.handleMessage(message);
                List<ModelCard> cards = (List<ModelCard>) message.obj;
                cardsList.postValue(cards);
            }
        });
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

    public void getAllVideo(MutableLiveData<List<ModelVideo>> videoList) {
        api.getAllVideo(new Handler(Looper.getMainLooper()){
            @Override
            public void handleMessage(Message message) {
                super.handleMessage(message);
                List<ModelVideo> video = (List<ModelVideo>) message.obj;
                videoList.postValue(video);
            }
        });
    }

    public void getAllCardsByName(String name, MutableLiveData<List<ModelCard>> cards) {
        api.getAllCardsByName(name, new Handler(Looper.getMainLooper()){
            @Override
            public void handleMessage(Message message) {
                super.handleMessage(message);
                List<ModelCard> search = (List<ModelCard>) message.obj;
                cards.postValue(search);
            }
        });
    }

    public void getAllVideoByName(String name, MutableLiveData<List<ModelVideo>> video) {
        api.getAllVideoByName(name, new Handler(Looper.getMainLooper()){
            @Override
            public void handleMessage(Message message) {
                super.handleMessage(message);
                List<ModelVideo> search = (List<ModelVideo>) message.obj;
                video.postValue(search);
            }
        });
    }

    public void getComprtitionByDate(String date, MutableLiveData<List<ModelCompetition>> competitions) {
        api.getCompetitonByDate(date, new Handler(Looper.getMainLooper()){
            @Override
            public void handleMessage(Message message) {
                super.handleMessage(message);
                List<ModelCompetition> search = (List<ModelCompetition>) message.obj;
                competitions.postValue(search);
            }
        });
    }
}
