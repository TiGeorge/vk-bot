package com.example.vkbot.service;

import com.example.vkbot.dto.ButtonDto;

public interface ButtonService {

  ButtonDto createButton(ButtonDto newButton);

  void updateButton(ButtonDto newButton);

  ButtonDto getButtonById(Long id);

  void deleteButton(Long id);
}
