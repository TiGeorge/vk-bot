package com.example.keyboardservice.service;

import com.example.keyboardservice.dto.ActionDto;
import com.example.keyboardservice.mapper.ActionDtoMapper;
import com.example.keyboardservice.model.PersistentAction;
import com.example.keyboardservice.repository.ActionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActionServiceImpl implements ActionService {

  private final ActionRepo actionRepo;
  private final ActionDtoMapper actionDtoMapper;

  @Override
  public ActionDto createAction(ActionDto actionDto) {
    actionDto.setId(null);
    PersistentAction action = actionDtoMapper.dtoToEntity(actionDto);
    action = actionRepo.save(action);
    return actionDtoMapper.entityToDto(action);
  }

  @Override
  public void updateAction(ActionDto actionDto) {
    PersistentAction action = actionDtoMapper.dtoToEntity(actionDto);
    actionRepo.save(action);
  }

  @Override
  public ActionDto getActionById(Long id) {
    PersistentAction action = actionRepo.findById(id).orElseThrow();
    return actionDtoMapper.entityToDto(action);
  }

  @Override
  public void deleteAction(Long id) {
    actionRepo.deleteById(id);
  }
}
