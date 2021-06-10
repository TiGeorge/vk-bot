package com.example.vkbot.handlers;

import com.vk.api.sdk.callback.longpoll.CallbackApiLongPoll;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.objects.messages.Message;
import java.util.concurrent.ThreadLocalRandom;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CallbackHandler extends CallbackApiLongPoll {

  private final GroupActor actor;

  public CallbackHandler(VkApiClient client, GroupActor actor) {
    super(client, actor);
    this.actor = actor;
  }

  @Override
  public void messageNew(Integer groupId, Message message) {
    log.info("messageNew: " + message);
    sendMessage(message.getFromId(), message.getText());
  }

  @SneakyThrows
  private void sendMessage(Integer userId, String text) {
    Integer[] ids = new Integer[1];
    ids[0] = userId;
    getClient()
        .messages()
        .sendWithUserIds(actor, ids)
        .message(text)
        .randomId(ThreadLocalRandom.current().nextInt())
        .execute();
  }
}
