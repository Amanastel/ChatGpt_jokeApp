package com.masai.chatgpt.modelAI.DTO;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChatGPTRequest {

    private String model;
    private List<Message> messages;

    public ChatGPTRequest(String model,String prompt ) {
        this.model=model;
        this.messages= new ArrayList<>();
        this.messages.add(new Message("user",prompt));
    }
}
