package com.example.botservice.service;

import com.vk.api.sdk.objects.messages.Keyboard;
import java.util.concurrent.ExecutionException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;
import org.springframework.kafka.requestreply.RequestReplyFuture;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KeyboardServiceImpl implements KeyboardService {

  private static final String TOPIC= "keyboards";

  private final ReplyingKafkaTemplate<String, String, Keyboard> replyingKafkaTemplate;

  @Override
  public Keyboard findKeyboardById(long longValue) throws ExecutionException, InterruptedException {
    ProducerRecord<String, String> record =
        new ProducerRecord<>("findKeyboardById", null, Long.toString(longValue), Long.toString(longValue));
    RequestReplyFuture<String, String, Keyboard> future = replyingKafkaTemplate
      .sendAndReceive(record);
    ConsumerRecord<String, Keyboard> response = future.get();
    return response.value();
  }

  @Override
  public Keyboard findKeyboardForCommunity(int i) throws ExecutionException, InterruptedException {
    ProducerRecord<String, String> record =
      new ProducerRecord<>("findKeyboardForCommunity", null, Integer.toString(i), Integer.toString(i));
    RequestReplyFuture<String, String, Keyboard> future = replyingKafkaTemplate
      .sendAndReceive(record);
    ConsumerRecord<String, Keyboard> response = future.get();
    return response.value();
  }
}
