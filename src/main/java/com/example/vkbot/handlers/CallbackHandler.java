package com.example.vkbot.handlers;

import com.example.vkbot.services.KeyboardService;
import com.vk.api.sdk.callback.longpoll.CallbackApiLongPoll;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.objects.messages.Keyboard;
import com.vk.api.sdk.objects.messages.Message;
import java.util.concurrent.ThreadLocalRandom;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CallbackHandler extends CallbackApiLongPoll {

  private final GroupActor actor;
  private final KeyboardService keyboardService;

  public CallbackHandler(VkApiClient client, GroupActor actor, KeyboardService keyboardService) {
    super(client, actor);
    this.actor = actor;
    this.keyboardService = keyboardService;
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
    Keyboard keyboard = keyboardService.findKeyboardForCommunity(205095138);
    getClient()
        .messages()
        .sendWithUserIds(actor, ids)
        .message(text)
        .keyboard(keyboard)
        .randomId(ThreadLocalRandom.current().nextInt())
        .execute();
  }
}
