package io.sultanov.adapter.controller;

import io.sultanov.adapter.service.AdapterService;
import io.sultanov.feignclients.dto.MsgA;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/adapter")
public class AdapterController {

    private final AdapterService adapterService;

    @PostMapping("/send")
    public void sendMessage(@Valid @RequestBody MsgA msgA) {
        adapterService.sendMessageToServiceB(msgA);
    }
}
