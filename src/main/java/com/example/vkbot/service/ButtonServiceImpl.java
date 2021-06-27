package com.example.vkbot.service;

import com.example.vkbot.dto.ButtonDto;
import com.example.vkbot.mapper.ButtonDtoMupper;
import com.example.vkbot.model.Button;
import com.example.vkbot.repository.ButtonRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ButtonServiceImpl implements ButtonService {

  private final ButtonRepo buttonRepo;
  private final ButtonDtoMupper buttonDtoMupper;

  @Override
  public ButtonDto createButton(ButtonDto newButton) {
    newButton.setId(null);
    Button button = buttonDtoMupper.dtoToEntity(newButton);
    button = buttonRepo.save(button);
    return buttonDtoMupper.entityToDto(button);
  }

  @Override
  public void updateButton(ButtonDto newButton) {
    Button button = buttonDtoMupper.dtoToEntity(newButton);
    buttonRepo.save(button);
  }

  @Override
  public ButtonDto getButtonById(Long id) {
    Button button = buttonRepo.findById(id).orElseThrow();
    return buttonDtoMupper.entityToDto(button);
  }

  @Override
  public void deleteButton(Long id) {
    buttonRepo.deleteById(id);
  }
}
