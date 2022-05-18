package com.example.fskating;

import android.os.Handler;

public interface API {
    void getAllCompetitions(Handler handler);
    void getCompetitonByDate(String date, Handler handler);
    void getAllCards(Handler handler);
    void getCardInfo(Long id, Handler handler);
    void getAllCardsByName(String name, Handler handler);
    void getAllVideo(Handler handler);
    void getAllVideoByName(String name, Handler handler);
}
