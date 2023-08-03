package com.masai.chatgpt.modelAI.Controller;
import com.masai.chatgpt.modelAI.DTO.ChatGPTRequest;
import com.masai.chatgpt.modelAI.DTO.ChatGPTResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class CustomerBotController {

    @Value("${openai.model}")
    private String model;

    @Autowired
    private RestTemplate template;

    @Value("${openai.api.url}")
    private String apiURL;

    @GetMapping("/chat")
    public ResponseEntity<ChatGPTResponse> chat(@RequestParam("prompt") String prompt) {
        log.info("Prompt: {}",prompt);
        ChatGPTRequest request = new ChatGPTRequest("gpt-3.5-turbo",prompt +" generate a random joke");

        log.info("Request: {}",request);
        ChatGPTResponse chatgptResponse =template.postForObject(apiURL, request, ChatGPTResponse.class);
        return new ResponseEntity<>( chatgptResponse,HttpStatus.CREATED);
    }
}