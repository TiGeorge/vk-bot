package com.example.keyboardservice.service;

import com.example.keyboardservice.dto.ButtonDto;
import com.example.keyboardservice.mapper.ButtonDtoMapper;
import com.example.keyboardservice.model.PersistentButton;
import com.example.keyboardservice.repository.ButtonRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ButtonServiceImpl implements ButtonService {

  private final ButtonRepo buttonRepo;
  private final ButtonDtoMapper buttonDtoMapper;

  @Override
  public ButtonDto createButton(ButtonDto newButton) {
    newButton.setId(null);
    PersistentButton button = buttonDtoMapper.dtoToEntity(newButton);
    button = buttonRepo.save(button);
    return buttonDtoMapper.entityToDto(button);
  }

  @Override
  public void updateButton(ButtonDto newButton) {
    PersistentButton button = buttonDtoMapper.dtoToEntity(newButton);
    buttonRepo.save(button);
  }

  @Override
  public ButtonDto getButtonById(Long id) {
    PersistentButton button = buttonRepo.findById(id).orElseThrow();
    return buttonDtoMapper.entityToDto(button);
  }

  @Override
  public void deleteButton(Long id) {
    buttonRepo.deleteById(id);
  }
}
