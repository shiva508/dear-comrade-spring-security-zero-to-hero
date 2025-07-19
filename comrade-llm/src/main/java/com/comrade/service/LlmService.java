package com.comrade.service;

import com.comrade.model.LlmRequest;
import com.comrade.model.LlmResponse;

public interface LlmService {

 LlmResponse getNewsInfo(LlmRequest llmRequest);
}
