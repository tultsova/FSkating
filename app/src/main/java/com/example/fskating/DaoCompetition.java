package com.example.fskating;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.fskating.models.ModelCompetition;

import java.util.List;

@Dao
public interface DaoCompetition {
    @Insert
    void insertCompetition(ModelCompetition modelCompetition);
    @Delete
    void deleteCompetitions(ModelCompetition modelCompetition);
    @Query("DELETE FROM competition_table")
    void deleteAllCompetitions();
    @Transaction
    @Query("SELECT * FROM competition_table")
    LiveData<List<ModelCompetition>> getAllCompetitions();
}
