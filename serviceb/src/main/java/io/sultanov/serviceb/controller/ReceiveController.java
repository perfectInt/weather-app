package io.sultanov.serviceb.controller;

import io.sultanov.feignclients.dto.MsgB;
import io.sultanov.serviceb.service.ReceiveService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/service-b")
public class ReceiveController {

    private final ReceiveService receiveService;

    @PostMapping("/receive")
    public void receiveMessage(@RequestBody MsgB msgB) {
        receiveService.saveMessage(msgB);
    }

    @GetMapping
    public MsgB getMessage() {
        return receiveService.getFirstMessage();
    }
}
