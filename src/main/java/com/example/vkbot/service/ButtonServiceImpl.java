package com.example.vkbot.service;

import com.example.vkbot.dto.ButtonDto;
import com.example.vkbot.mapper.ButtonDtoMapper;
import com.example.vkbot.model.Button;
import com.example.vkbot.repository.ButtonRepo;
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
    Button button = buttonDtoMapper.dtoToEntity(newButton);
    button = buttonRepo.save(button);
    return buttonDtoMapper.entityToDto(button);
  }

  @Override
  public void updateButton(ButtonDto newButton) {
    Button button = buttonDtoMapper.dtoToEntity(newButton);
    buttonRepo.save(button);
  }

  @Override
  public ButtonDto getButtonById(Long id) {
    Button button = buttonRepo.findById(id).orElseThrow();
    return buttonDtoMapper.entityToDto(button);
  }

  @Override
  public void deleteButton(Long id) {
    buttonRepo.deleteById(id);
  }
}
