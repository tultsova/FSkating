package com.example.fskating;


import android.os.Message;
import java.util.logging.Handler;

import androidx.lifecycle.LiveData;

import com.example.fskating.models.ModelCard;
import com.example.fskating.models.ModelCompetition;

import java.util.ArrayList;
import java.util.List;



public class NetworkMock implements API{

    private final List<ModelCompetition> competitions;

    public NetworkMock() {
        competitions = new ArrayList<>();

        competitions.add(new ModelCompetition(1L, "4 февраля",
                "4:55 Олимпиада. Командные соревнования. \n\t\t\t\t  Мужчины - КП \n" +
                        "6:35 Олимпиада. Командные соревнования. \n\t\t\t\t  Танцы на льду - РТ \n" +
                        "8:15 Олимпиада. Командные соревнования. \n\t\t\t\t  Парное катание - КП"));
        competitions.add(new ModelCompetition(2L, "6 февраля",
                "4:30 Олимпиада. Командные соревнования. \n\t\t\t\t  Женщины - КП \n" +
                        "6:50 Олимпиада. Командные соревнования. \n\t\t\t\t  Мужчины - ПП"));
        competitions.add(new ModelCompetition(3L, "7 февраля",
                "4:15 Олимпиада. Командные соревнования. \n\t\t\t\t  Парное катание - ПП \n" +
                        "5:30 Олимпиада. Командные соревнования. \n\t\t\t\t  Танцы на льду - ПТ \n" +
                        "6:35 Олимпиада. Командные соревнования. \n\t\t\t\t  Женщины - ПП"));
    }

    @Override
    public void insertCompetition(ModelCompetition modelCompetition, Handler handler) {
        new Thread(() -> {
            Message message = new Message();
            competitions.add(modelCompetition);
            handler.sendMessage(message);
        }).start();
    }

    @Override
    public LiveData<List<ModelCompetition>> getAllCompetitions(Handler handler) {
        new Thread(() -> {
            Message message = new Message();
            message.obj = competitions;
            handler.sendMessage(message);
        }).start();
    }
}
