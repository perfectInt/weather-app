package io.sultanov.servicea.controller;

import io.sultanov.feignclients.dto.MsgA;
import io.sultanov.servicea.service.SendService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/service-a")
public class SendController {

    private final SendService sendService;

    @PostMapping("/send")
    public void sendMessage(@Valid @RequestBody MsgA msgA) {
        sendService.sendMessage(msgA);
    }
}
