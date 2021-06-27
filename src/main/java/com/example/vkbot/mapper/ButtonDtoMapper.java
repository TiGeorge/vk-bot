package com.example.vkbot.mapper;

import com.example.vkbot.dto.ButtonDto;
import com.example.vkbot.model.Button;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ButtonDtoMapper {

  @Mapping(target = "keyboardId", source = "keyboard.id")
  @Mapping(target = "actionId", source = "action.id")
  ButtonDto entityToDto(Button entity);

  Button dtoToEntity(ButtonDto dto);
}
