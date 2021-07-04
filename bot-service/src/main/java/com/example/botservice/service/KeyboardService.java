package com.example.botservice.service;

import com.vk.api.sdk.objects.messages.Keyboard;

public interface KeyboardService {

  Keyboard findKeyboardById(long longValue);

  Keyboard findKeyboardForCommunity(int i);
}
