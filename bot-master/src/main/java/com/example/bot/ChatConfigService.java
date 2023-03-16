package com.example.bot;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ChatConfigService {
    @Autowired
    private ChatConfigRepo chatConfigRepo;

    public boolean isChatInit(Long chatId){
        return chatConfigRepo.findAllByChatId(chatId) != null;
    }

    //создание нового чата
    public void initChat(Long chatId){
        chatConfigRepo.save(new ChatConfig(chatId, BotState.DEFAULT));
    }

    public void deleteChat(Long chatId){
        chatConfigRepo.deleteByChatId(chatId);
    }

    public void setBotState(Long chatId,BotState botState){
        ChatConfig chatConfig = chatConfigRepo.findAllByChatId(chatId);
        chatConfig.setBotState(botState);
        chatConfigRepo.save(chatConfig);
    }

    public BotState getBotState(Long chatId){
        return chatConfigRepo.findAllByChatId(chatId).getBotState();
    }

    public void setCity(Long chatId,String city){
        ChatConfig chatConfig = chatConfigRepo.findAllByChatId(chatId);
        chatConfig.setCity(city);
        chatConfigRepo.save(chatConfig);
    }

    public String getCity(Long chatId){
        return chatConfigRepo.findAllByChatId(chatId).getCity();
    }
}