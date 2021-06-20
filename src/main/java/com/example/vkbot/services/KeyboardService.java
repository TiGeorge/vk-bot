package com.example.vkbot.services;

import com.vk.api.sdk.objects.messages.Keyboard;

public interface KeyboardService {

  Keyboard findKeyboardForCommunity(int communityId);
}
