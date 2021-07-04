package com.example.keyboardservice.mapper;

import com.example.keyboardservice.model.PersistentButton;
import com.example.keyboardservice.model.PersistentKeyboard;
import com.vk.api.sdk.objects.messages.Keyboard;
import com.vk.api.sdk.objects.messages.KeyboardButton;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KeyboardMapper {

  private final ButtonMapper buttonMapper;

  public Keyboard keyboardToVkKeyboard(PersistentKeyboard persistentKeyboard) {
    if (persistentKeyboard == null) return null;

    List<PersistentButton> buttons = persistentKeyboard.getButtons();
    List<List<KeyboardButton>> rows =
        buttons.stream()
            .sorted(Comparator.comparingInt(PersistentButton::getRowOrder))
            .collect(
                Collectors.groupingBy(
                    PersistentButton::getRowNumber,
                    Collectors.mapping(buttonMapper::buttonToKeyboardButton, Collectors.toList())))
            .entrySet()
            .stream()
            .sorted(Comparator.comparingInt(Map.Entry::getKey))
            .map(Map.Entry::getValue)
            .collect(Collectors.toList());

    Keyboard result = new Keyboard();
    result.setButtons(rows);
    return result;
  }
}
