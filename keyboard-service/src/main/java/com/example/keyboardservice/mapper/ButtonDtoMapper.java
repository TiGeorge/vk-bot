package com.example.keyboardservice.mapper;

import com.example.keyboardservice.dto.ButtonDto;
import com.example.keyboardservice.model.PersistentButton;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ButtonDtoMapper {

  @Mapping(target = "keyboardId", source = "persistentKeyboard.id")
  @Mapping(target = "actionId", source = "action.id")
  ButtonDto entityToDto(PersistentButton entity);

  PersistentButton dtoToEntity(ButtonDto dto);
}
