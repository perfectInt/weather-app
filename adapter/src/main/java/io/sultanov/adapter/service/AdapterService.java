package io.sultanov.adapter.service;

import io.sultanov.feignclients.clients.ServiceBClient;
import io.sultanov.feignclients.dto.MsgA;
import io.sultanov.feignclients.dto.MsgB;
import io.sultanov.feignclients.util.Language;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AdapterService {

    private final ServiceBClient bClient;
    private final WeatherService weatherService;

    public void sendMessageToServiceB(MsgA msgA) {
        if (msgA.getLng() != Language.ru)
            return;
        MsgB msgB = MsgB.builder()
                .txt(msgA.getMsg())
                .createdDt(LocalDateTime.now())
                .build();
        msgB.setCurrentTemp(weatherService.getWeatherData(msgA.getCoordinates()));
        bClient.receiveMessage(msgB);
    }
}
