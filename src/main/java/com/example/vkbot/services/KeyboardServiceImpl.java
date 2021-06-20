package com.example.vkbot.services;

import com.example.vkbot.mappers.KeyboardMapper;
import com.example.vkbot.model.Community;
import com.example.vkbot.repositories.CommunityRepo;
import com.vk.api.sdk.objects.messages.Keyboard;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KeyboardServiceImpl implements KeyboardService {

  private final CommunityRepo communityRepo;
  private final KeyboardMapper keyboardMapper;

  @Override
  public Keyboard findKeyboardForCommunity(int communityId) {
    return communityRepo
        .findById(communityId)
        .map(Community::getKeyboard)
        .map(keyboardMapper::keyboardToVkKeyboard)
        .orElse(null);
  }
}
