package io.sultanov.servicea.service;

import io.sultanov.feignclients.clients.AdapterClient;
import io.sultanov.feignclients.dto.MsgA;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SendService {

    private final AdapterClient adapterClient;

    public void sendMessage(MsgA msgA) {
        adapterClient.sendMessage(msgA);
    }
}
