package com.comrade.controller;

import com.comrade.model.LlmRequest;
import com.comrade.model.LlmResponse;
import com.comrade.service.LlmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/llm")
//@RequiredArgsConstructor
public class ComradeLlmController {

    private final LlmService llmService;

    public ComradeLlmController(LlmService llmService) {
        this.llmService = llmService;
    }

    @PostMapping("/news")
    public ResponseEntity<LlmResponse> getNewsInfo(LlmRequest llmRequest) {
        LlmResponse newsInfo = llmService.getNewsInfo(llmRequest);
        return new ResponseEntity<>(newsInfo, HttpStatus.OK);
    }
}
