package com.example.fskating;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.fskating.models.ModelCompetition;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Repository {

    private final LocalDataBase dataBase;

    @Inject
    public Repository(Application application) {
        dataBase = LocalDataBase.init(application);

        List<ModelCompetition> data = new ArrayList<>();
        data.add(new ModelCompetition(1L, "4 февраля",
                "4:55 Олимпиада. Командные соревнования. \n\t\t\t\t  Мужчины - КП \n" +
                        "6:35 Олимпиада. Командные соревнования. \n\t\t\t\t  Танцы на льду - РТ \n" +
                        "8:15 Олимпиада. Командные соревнования. \n\t\t\t\t  Парное катание - КП"));
        data.add(new ModelCompetition(2L, "6 февраля",
                "4:30 Олимпиада. Командные соревнования. \n\t\t\t\t  Женщины - КП \n" +
                        "6:50 Олимпиада. Командные соревнования. \n\t\t\t\t  Мужчины - ПП"));
        data.add(new ModelCompetition(3L, "7 февраля",
                "4:15 Олимпиада. Командные соревнования. \n\t\t\t\t  Парное катание - ПП \n" +
                        "5:30 Олимпиада. Командные соревнования. \n\t\t\t\t  Танцы на льду - ПТ \n" +
                        "6:35 Олимпиада. Командные соревнования. \n\t\t\t\t  Женщины - ПП"));

        dataBase.insertAllCompetitions(data);
    }

    public LiveData<List<ModelCompetition>> getAllCompetitions() {
        return dataBase.getAllCompetitions();
    }
}