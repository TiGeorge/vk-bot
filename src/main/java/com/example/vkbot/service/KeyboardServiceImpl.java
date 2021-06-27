package com.example.vkbot.service;

import com.example.vkbot.dto.ButtonDto;
import com.example.vkbot.dto.KeyboardDto;
import com.example.vkbot.mapper.ButtonDtoMapper;
import com.example.vkbot.mapper.KeyboardDtoMapper;
import com.example.vkbot.mapper.KeyboardMapper;
import com.example.vkbot.model.Community;
import com.example.vkbot.repository.CommunityRepo;
import com.example.vkbot.repository.KeyboardRepo;
import com.vk.api.sdk.objects.messages.Keyboard;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KeyboardServiceImpl implements KeyboardService {

  private final KeyboardRepo keyboardRepo;
  private final CommunityRepo communityRepo;
  private final KeyboardMapper keyboardMapper;
  private final KeyboardDtoMapper keyboardDtoMapper;
  private final ButtonDtoMapper buttonDtoMapper;

  @Override
  public Keyboard findKeyboardForCommunity(int communityId) {
    return communityRepo
        .findById(communityId)
        .map(Community::getKeyboard)
        .map(keyboardMapper::keyboardToVkKeyboard)
        .orElse(null);
  }

  @Override
  public Keyboard findKeyboardById(Long id) {
    return keyboardRepo.findById(id).map(keyboardMapper::keyboardToVkKeyboard).orElseThrow();
  }

  @Override
  public KeyboardDto createKeyboard(KeyboardDto newKeyboard) {
    newKeyboard.setId(null);
    var keyboard = keyboardDtoMapper.keyboardDtoToEntity(newKeyboard);
    keyboard = keyboardRepo.save(keyboard);
    return keyboardDtoMapper.keyboardToDto(keyboard);
  }

  @Override
  public KeyboardDto getKeyboardById(Long id) {
    var keyboard = keyboardRepo.findById(id).orElseThrow();
    return keyboardDtoMapper.keyboardToDto(keyboard);
  }

  @Override
  public void updateKeyboard(KeyboardDto keyboardDto) {
    var keyboard = keyboardDtoMapper.keyboardDtoToEntity(keyboardDto);
    keyboardRepo.save(keyboard);
  }

  @Override
  public void deleteKeyboard(Long id) {
    keyboardRepo.deleteById(id);
  }

  @Override
  public List<ButtonDto> getButtonsForKeyboard(Long id) {
    var keyboard = keyboardRepo.findById(id).orElseThrow();
    return keyboard.getButtons().stream()
        .map(buttonDtoMapper::entityToDto)
        .collect(Collectors.toList());
  }
}
