package com.example.keyboardservice.service;

import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

@Slf4j
@Component
@RequiredArgsConstructor
public class SendMessageTask {

  private final Producer producer;

  @SneakyThrows
  @Scheduled(fixedRateString = "3000")
  public void send(){
    ListenableFuture<SendResult<String, String>> listenableFuture = this.producer.sendMessage("INPUT_DATA", "IN_KEY", LocalDate
      .now().toString());

    SendResult<String, String> result = listenableFuture.get();
    log.info(String.format("Produced:\ntopic: %s\noffset: %d\npartition: %d\nvalue size: %d", result.getRecordMetadata().topic(),
      result.getRecordMetadata().offset(),
      result.getRecordMetadata().partition(), result.getRecordMetadata().serializedValueSize()));
  }
}
