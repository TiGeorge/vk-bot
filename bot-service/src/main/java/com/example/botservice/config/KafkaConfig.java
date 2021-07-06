package com.example.botservice.config;

import com.vk.api.sdk.objects.messages.Keyboard;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;

@Configuration
public class KafkaConfig {

  @Value("${kafka.groupId}")
  private String groupId;

  @Value("${kafka.replyTopic}")
  private String replyTopic;

  @Bean
  public ReplyingKafkaTemplate<String, String, Keyboard> replyingKafkaTemplate(
      ProducerFactory<String, String> pf,
      ConcurrentKafkaListenerContainerFactory<String, Keyboard> factory) {

    ConcurrentMessageListenerContainer<String, Keyboard> replyContainer =
        factory.createContainer(replyTopic);
    replyContainer.getContainerProperties().setMissingTopicsFatal(false);
    replyContainer.getContainerProperties().setGroupId(groupId);
    return new ReplyingKafkaTemplate<>(pf, replyContainer);
  }

  @Bean
  public KafkaTemplate<String, Keyboard> replyTemplate(
      ProducerFactory<String, Keyboard> pf,
      ConcurrentKafkaListenerContainerFactory<String, Keyboard> factory) {
    KafkaTemplate<String, Keyboard> kafkaTemplate = new KafkaTemplate<>(pf);
    factory.getContainerProperties().setMissingTopicsFatal(false);
    factory.setReplyTemplate(kafkaTemplate);
    return kafkaTemplate;
  }
}
