package com.example.fskating;


import android.os.Message;
import android.os.Handler;


import com.example.fskating.models.ModelCard;
import com.example.fskating.models.ModelCompetition;
import com.example.fskating.models.ModelVideo;

import java.util.ArrayList;
import java.util.List;



public class NetworkMock implements API{

    private final List<ModelCompetition> competitions;
    private final List<ModelCard> cards;
    private final List<ModelVideo> video;

    public NetworkMock() {
        competitions = new ArrayList<>();
        cards = new ArrayList<>();
        video = new ArrayList<>();

        // создание моделей соревнований
        competitions.add(new ModelCompetition(1L, "4 февраля",
                "4:55 Олимпиада. Командные соревнования. Мужчины - КП \n" +
                        "6:35 Олимпиада. Командные соревнования. Танцы на льду - РТ \n" +
                        "8:15 Олимпиада. Командные соревнования. Парное катание - КП"));
        competitions.add(new ModelCompetition(2L, "6 февраля",
                "4:30 Олимпиада. Командные соревнования. Женщины - КП \n" +
                        "6:50 Олимпиада. Командные соревнования. Мужчины - ПП"));
        competitions.add(new ModelCompetition(3L, "7 февраля",
                "4:15 Олимпиада. Командные соревнования. Парное катание - ПП \n" +
                        "5:30 Олимпиада. Командные соревнования. Танцы на льду - ПТ \n" +
                        "6:35 Олимпиада. Командные соревнования. Женщины - ПП"));


        // создание моделей карточек спортсмена
        cards.add(new ModelCard(1L, R.drawable.kisiki_card,
                "Александра Бойкова\nДмитрий Козловский",
                "Тамара Москвина, Артур Минчук",
                "Короткая программа: Лебединое озеро", "Прозивольная программа: Malaguena",
                "icyHgZLF2yw", "dNqvyyLJaNk"));
        cards.add(new ModelCard(2L, R.drawable.anya_card,
                "Анна Щербакова",
                "Этери Тутберидзе, Сергей Дудаков, Даниил Глейхенгауз",
                "Короткая программа: Dangerous Affairs", "Прозивольная программа: Мастер и Маргарита",
                "a-aSBztW0JE", "hUkLekSdVcI"));
        cards.add(new ModelCard(3L, R.drawable.stepbuk_card,
                "Александра Степанова\nИван Букин",
                "Ирина Жук, Александр Свинин",
                "Ритм-танец: Apache, Everybody", "Прозивольный танец: Ромео и Джульетта",
                "9vv41ZJcJ2s" , "vKxt9RsrN-0"));
        cards.add(new ModelCard(4L, R.drawable.sasha_card,
                "Александра Трусова",
                "Этери Тутберидзе, Сергей Дудаков, Даниил Глейхенгауз",
                "Короткая программа: Фрида", "Прозивольная программа: Круэлла",
                "5RCoEg2_Uc4", "Xg4HKwY9V0E"));
        cards.add(new ModelCard(5L, R.drawable.mark_card,
                "Марк Кондратюк",
                "Светлана Соколовская",
                "Короткая программа: Великолепный век", "Прозивольная программа: Иисус Христос - Супер-звезда",
                "zY07aCH8Qsw", "jCYlBXjWybI"));
        cards.add(new ModelCard(6L, R.drawable.kamila_card,
                "Камила Валиева",
                "Этери Тутберидзе, Сергей Дудаков, Даниил Глейхенгауз",
                "Короткая программа: In Memoriam", "Прозивольная программа: Болеро",
                "TtQuh--tqXI", "yWcdy_Fva8"));

        // создание моделей видео
        video.add(new ModelVideo(1L, "Ритм-танец: Александра Степанова, Иван Букин",
                "9vv41ZJcJ2s"));
        video.add(new ModelVideo(2L, "Произвольная программа: Марк Кондратюк",
                "jCYlBXjWybI"));
        video.add(new ModelVideo(3L, "Произвольная программа: Александра Трусова",
                "Xg4HKwY9V0E"));
        video.add(new ModelVideo(4L, "Произвольная программа: Анастасия Мишина, Михаил Галлямов",
                "nbgWYejzSWI"));
        video.add(new ModelVideo(5L, "Короткая программа: Евгения Тарасова, Владимир Морозов",
                "mF0xLpwUjjo"));
        video.add(new ModelVideo(6L, "Короткая программа: Евгений Семененко",
                "I3BtCSO4hrE"));
    }

    @Override
    public void getAllCompetitions(Handler handler) {
        new Thread(() -> {
            Message message = new Message();
            message.obj = competitions;
            handler.sendMessage(message);
        }).start();
    }

    @Override
    public void getAllCards(Handler handler) {
        new Thread(() -> {
            Message message = new Message();
            message.obj = cards;
            handler.sendMessage(message);
        }).start();
    }

    @Override
    public void getCardInfo(Long id,Handler handler) {
        new Thread(() -> {
            for (ModelCard card: cards) {
                if (card.getIdCard().equals(id)) {
                    Message message = new Message();
                    message.obj = card;
                    handler.sendMessage(message);
                    break;
                }
            }
        }).start();
    }

    @Override
    public void getAllVideo(Handler handler) {
        new Thread(() -> {
            Message message = new Message();
            message.obj = video;
            handler.sendMessage(message);
        }).start();
    }
}
