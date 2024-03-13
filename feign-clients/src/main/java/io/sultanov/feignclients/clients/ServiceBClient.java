package io.sultanov.feignclients.clients;

import io.sultanov.feignclients.dto.MsgB;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "service-b", url = "${clients.service-b.url}"
)
public interface ServiceBClient {

    @PostMapping("/api/v1/service-b/receive")
    void receiveMessage(@RequestBody MsgB msgB);
}
