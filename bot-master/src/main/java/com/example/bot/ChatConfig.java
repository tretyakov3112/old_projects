package com.example.bot;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Document(collection = "chats_config")
public class ChatConfig {
    @Id
    private BigInteger id;

    @NonNull
    private Long chatId;

    @NonNull
    @Field(targetType = FieldType.STRING)
    private BotState botState;

    //стандартный город для пользователя
    private String city;
}