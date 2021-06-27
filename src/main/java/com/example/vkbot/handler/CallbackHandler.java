package com.example.vkbot.handler;

import com.example.vkbot.service.KeyboardService;
import com.vk.api.sdk.callback.longpoll.CallbackApiLongPoll;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.objects.messages.Keyboard;
import com.vk.api.sdk.objects.messages.Message;
import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.concurrent.ThreadLocalRandom;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
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

  @SneakyThrows
  @Override
  public void messageNew(Integer groupId, Message message) {
    log.info("messageNew: " + message);
    Keyboard keyboard = getKeyboard(message);
    sendMessage(message.getFromId(), message.getText(), keyboard);
  }

  private Keyboard getKeyboard(Message message) throws ParseException {
    if (message.getPayload() != null) {
      JSONParser jsonParser = new JSONParser(message.getPayload());
      LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>)jsonParser.parse();
      BigInteger id = (BigInteger) map.get("link_keyboard_id");
      return keyboardService.findKeyboardById(id.longValue());
    } else {
      return keyboardService.findKeyboardForCommunity(205095138);
    }
  }

  @SneakyThrows
  private void sendMessage(Integer userId, String text, Keyboard keyboard) {
    Integer[] ids = new Integer[1];
    ids[0] = userId;
    getClient()
        .messages()
        .sendWithUserIds(actor, ids)
        .message(text)
        .keyboard(keyboard)
        .randomId(ThreadLocalRandom.current().nextInt())
        .execute();
  }
}
