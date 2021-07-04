package com.example.keyboardservice.service;

import com.example.keyboardservice.dto.ButtonDto;
import com.example.keyboardservice.dto.KeyboardDto;
import com.vk.api.sdk.objects.messages.Keyboard;
import java.util.List;

public interface KeyboardService {

  Keyboard findKeyboardForCommunity(int communityId);

  Keyboard findKeyboardById(Long id);

  KeyboardDto createKeyboard(KeyboardDto newKeyboard);

  KeyboardDto getKeyboardById(Long id);

  void updateKeyboard(KeyboardDto keyboard);

  void deleteKeyboard(Long id);

  List<ButtonDto> getButtonsForKeyboard(Long id);
}
