package com.example.vkbot.mapper;

import com.example.vkbot.model.Button;
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

  public Keyboard keyboardToVkKeyboard(com.example.vkbot.model.Keyboard keyboard) {
    if (keyboard == null) return null;

    List<Button> buttons = keyboard.getButtons();
    List<List<KeyboardButton>> rows =
        buttons.stream()
            .sorted(Comparator.comparingInt(Button::getRowOrder))
            .collect(
                Collectors.groupingBy(
                    Button::getRowNumber,
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
