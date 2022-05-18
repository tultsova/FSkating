package com.example.fskating;

import android.os.Handler;

public interface API {
    void getAllCompetitions(Handler handler);
    void getCardInfo(Long id, Handler handler);
    void getAllCards(Handler handler);
    void getAllVideo(Handler handler);
}
