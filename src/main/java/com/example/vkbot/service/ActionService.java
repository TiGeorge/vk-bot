package com.example.vkbot.service;

import com.example.vkbot.dto.ActionDto;

public interface ActionService {

  ActionDto createAction(ActionDto newAction);

  void updateAction(ActionDto newAction);

  ActionDto getActionById(Long id);

  void deleteAction(Long id);
}
