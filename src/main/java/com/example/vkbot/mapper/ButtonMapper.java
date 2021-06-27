package com.example.vkbot.mapper;

import com.example.vkbot.model.Button;
import com.example.vkbot.model.Keyboard;
import com.vk.api.sdk.objects.messages.KeyboardButton;
import com.vk.api.sdk.objects.messages.KeyboardButtonAction;
import org.springframework.stereotype.Component;

@Component
public class ButtonMapper {

  public KeyboardButton buttonToKeyboardButton(Button button) {
    if (button == null) return null;

    KeyboardButton result = new KeyboardButton();
    result.setColor(button.getColor());
    KeyboardButtonAction action = new KeyboardButtonAction();
    Keyboard linkKeyboard = button.getAction().getLinkKeyboard();
    if (linkKeyboard != null) {
      action.setPayload("{\"link_keyboard_id\": " + linkKeyboard.getId() + "}");
    }
    action.setType(button.getAction().getType());
    action.setLabel(button.getAction().getLabel());
    action.setLink(button.getAction().getLink());
    result.setAction(action);
    return result;
  }
}
