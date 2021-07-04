package com.example.keyboardservice.mapper;

import com.example.keyboardservice.model.PersistentButton;
import com.example.keyboardservice.model.PersistentKeyboard;
import com.vk.api.sdk.objects.messages.KeyboardButton;
import com.vk.api.sdk.objects.messages.KeyboardButtonAction;
import org.springframework.stereotype.Component;

@Component
public class ButtonMapper {

  public KeyboardButton buttonToKeyboardButton(PersistentButton button) {
    if (button == null) return null;

    KeyboardButton result = new KeyboardButton();
    result.setColor(button.getColor());
    KeyboardButtonAction action = new KeyboardButtonAction();
    PersistentKeyboard linkPersistentKeyboard = button.getAction().getLinkPersistentKeyboard();
    if (linkPersistentKeyboard != null) {
      action.setPayload("{\"link_keyboard_id\": " + linkPersistentKeyboard.getId() + "}");
    }
    action.setType(button.getAction().getType());
    action.setLabel(button.getAction().getLabel());
    action.setLink(button.getAction().getLink());
    result.setAction(action);
    return result;
  }
}
