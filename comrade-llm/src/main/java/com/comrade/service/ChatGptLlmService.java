package com.comrade.service;

import com.comrade.model.LlmRequest;
import com.comrade.model.LlmResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ChatGptLlmService implements LlmService{
    @Override
    public LlmResponse getNewsInfo(LlmRequest llmRequest) {
        //log.info("payload : {}", llmRequest);
        return LlmResponse.builder().output("it is good news").build();
    }
}
