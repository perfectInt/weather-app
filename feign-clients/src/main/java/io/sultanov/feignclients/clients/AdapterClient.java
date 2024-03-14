package io.sultanov.feignclients.clients;

import io.sultanov.feignclients.config.FeignClientConfiguration;
import io.sultanov.feignclients.dto.MsgA;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
    name = "adapter", url = "${clients.adapter.url}", configuration = FeignClientConfiguration.class
)
public interface AdapterClient {

    @PostMapping("/api/v1/adapter/send")
    void sendMessage(@Valid @RequestBody MsgA msgA);
}
