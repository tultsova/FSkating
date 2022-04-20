package com.example.fskating;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.fskating.models.ModelCompetition;

import java.util.List;

@Database(
        entities = {ModelCompetition.class},
        version = 1,
        exportSchema = false
)
public abstract class LocalDataBase extends RoomDatabase {
    protected abstract DaoCompetition daoCompetition();

    static LocalDataBase init(Context context) {
        return Room.databaseBuilder(
                context.getApplicationContext(),
                LocalDataBase.class,
                "test_database"
        )
                .fallbackToDestructiveMigration()
                .build();
    }

    public void insertCompetiton(ModelCompetition modelCompetition) {
        new Thread(() -> {
            daoCompetition().insertCompetition(modelCompetition);
        }).start();
    }

    public void insertAllCompetitions(List<ModelCompetition> list) {
        new Thread(() -> {
            daoCompetition().deleteAllCompetitions();
            for (ModelCompetition competition: list ) {
                daoCompetition().insertCompetition(competition);
            }
        }).start();
    }

    public LiveData<List<ModelCompetition>> getAllCompetitions() {
        return daoCompetition().getAllCompetitions();
    }
}
