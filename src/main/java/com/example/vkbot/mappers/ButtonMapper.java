package com.example.vkbot.mappers;

import com.example.vkbot.model.Button;
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
    action.setType(button.getAction().getType());
    action.setLabel(button.getAction().getLabel());
    action.setLink(button.getAction().getLink());
    action.setPayload(button.getAction().getPayload());
    result.setAction(action);
    return result;
  }
}
