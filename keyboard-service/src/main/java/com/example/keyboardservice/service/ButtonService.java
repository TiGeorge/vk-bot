package com.example.keyboardservice.service;

import com.example.keyboardservice.dto.ButtonDto;

public interface ButtonService {

  ButtonDto createButton(ButtonDto newButton);

  void updateButton(ButtonDto newButton);

  ButtonDto getButtonById(Long id);

  void deleteButton(Long id);
}
