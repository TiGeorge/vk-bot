package com.example.vkbot.service;

import com.example.vkbot.dto.ActionDto;
import com.example.vkbot.mapper.ActionDtoMapper;
import com.example.vkbot.model.Action;
import com.example.vkbot.repository.ActionRepo;
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
    Action action = actionDtoMapper.dtoToEntity(actionDto);
    action = actionRepo.save(action);
    return actionDtoMapper.entityToDto(action);
  }

  @Override
  public void updateAction(ActionDto actionDto) {
    Action action = actionDtoMapper.dtoToEntity(actionDto);
    actionRepo.save(action);
  }

  @Override
  public ActionDto getActionById(Long id) {
    Action action = actionRepo.findById(id).orElseThrow();
    return actionDtoMapper.entityToDto(action);
  }

  @Override
  public void deleteAction(Long id) {
    actionRepo.deleteById(id);
  }
}
