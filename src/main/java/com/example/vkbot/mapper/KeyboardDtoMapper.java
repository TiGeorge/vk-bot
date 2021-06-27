package com.example.vkbot.mapper;

import com.example.vkbot.dto.KeyboardDto;
import com.example.vkbot.model.Keyboard;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KeyboardDtoMapper {

  KeyboardDto keyboardToDto(Keyboard keyboard);
  Keyboard keyboardDtoToEntity(KeyboardDto keyboardDto);
}
