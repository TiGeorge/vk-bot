package com.example.keyboardservice.service;

import com.example.keyboardservice.dto.ButtonDto;
import com.example.keyboardservice.dto.KeyboardDto;
import com.example.keyboardservice.mapper.ButtonDtoMapper;
import com.example.keyboardservice.mapper.KeyboardDtoMapper;
import com.example.keyboardservice.mapper.KeyboardMapper;
import com.example.keyboardservice.model.Community;
import com.example.keyboardservice.model.PersistentKeyboard;
import com.example.keyboardservice.repository.CommunityRepo;
import com.example.keyboardservice.repository.KeyboardRepo;
import com.vk.api.sdk.objects.messages.Keyboard;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
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
  @KafkaListener(topics = "findKeyboardForCommunity", groupId = "keyboardId-keyboard-group")
  @SendTo
  public Keyboard findKeyboardForCommunity(int communityId) {
    return communityRepo
        .findById(communityId)
        .map(Community::getKeyboard)
        .map(keyboardMapper::keyboardToVkKeyboard)
        .orElse(null);
  }

  @Override
  @KafkaListener(topics = "findKeyboardById", groupId = "keyboardId-keyboard-group")
  @SendTo
  public Keyboard findKeyboardById(Long id) {
    return keyboardRepo.findById(id).map(keyboardMapper::keyboardToVkKeyboard).orElseThrow();
  }

  @Override
  public KeyboardDto createKeyboard(KeyboardDto newKeyboard) {
    newKeyboard.setId(null);
    PersistentKeyboard keyboard = keyboardDtoMapper.keyboardDtoToEntity(newKeyboard);
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
