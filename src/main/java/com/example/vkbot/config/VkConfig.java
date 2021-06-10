package com.example.vkbot.config;

import com.example.vkbot.handlers.CallbackHandler;
import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VkConfig {

  @Value("${app.groupId}")
  private Integer groupId;

  @Value("${app.accessToken}")
  private String accessToken;

  @Bean
  public VkApiClient vkApiClient() {
    TransportClient transportClient = HttpTransportClient.getInstance();
    return new VkApiClient(transportClient);
  }

  @Bean
  public GroupActor groupActor() {
    return new GroupActor(groupId, accessToken);
  }

  @Bean
  public CallbackHandler callbackHandler() throws ClientException, ApiException {
    CallbackHandler handler = new CallbackHandler(vkApiClient(), groupActor());
    handler.run();
    return handler;
  }
}
