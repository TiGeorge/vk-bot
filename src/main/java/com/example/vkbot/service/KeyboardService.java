package com.example.vkbot.service;

import com.example.vkbot.dto.KeyboardDto;
import com.vk.api.sdk.objects.messages.Keyboard;

public interface KeyboardService {

  Keyboard findKeyboardForCommunity(int communityId);

  Keyboard findKeyboardById(Long id);

  KeyboardDto createKeyboard(KeyboardDto newKeyboard);

  KeyboardDto getKeyboardById(Long id);

  void updateKeyboard(KeyboardDto keyboard);

  void deleteKeyboard(Long id);
}
