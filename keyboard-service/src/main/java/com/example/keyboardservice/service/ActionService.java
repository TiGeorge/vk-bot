package com.example.keyboardservice.service;

import com.example.keyboardservice.dto.ActionDto;

public interface ActionService {

  ActionDto createAction(ActionDto newAction);

  void updateAction(ActionDto newAction);

  ActionDto getActionById(Long id);

  void deleteAction(Long id);
}
