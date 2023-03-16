package com.example.bot;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
@Getter
@Setter

@Component
public class BotInit {
    @Autowired
    private WeatherBot weatherBot;


    //после того, как приложение полностью запущено
    @EventListener({ApplicationReadyEvent.class})
    public void init() throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(
                DefaultBotSession.class);
        try {
            telegramBotsApi.registerBot(weatherBot);
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }
}
