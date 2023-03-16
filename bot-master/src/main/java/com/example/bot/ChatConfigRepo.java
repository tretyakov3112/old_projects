package com.example.bot;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;

public interface ChatConfigRepo extends MongoRepository<ChatConfig, BigInteger> {
    ChatConfig findAllByChatId(Long chatId);
    void deleteByChatId(Long chatId);
}