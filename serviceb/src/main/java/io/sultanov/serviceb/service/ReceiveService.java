package io.sultanov.serviceb.service;

import io.sultanov.feignclients.dto.MsgB;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentLinkedQueue;

@Service
@RequiredArgsConstructor
public class ReceiveService {

    private ConcurrentLinkedQueue<MsgB> msgBConcurrentLinkedQueue = new ConcurrentLinkedQueue<>();

    public void saveMessage(MsgB msgB) {
        msgBConcurrentLinkedQueue.add(msgB);
    }

    public MsgB getFirstMessage() {
        return msgBConcurrentLinkedQueue.poll();
    }
}
