package com.example.keyboardservice.mapper;

import com.example.keyboardservice.dto.KeyboardDto;
import com.example.keyboardservice.model.PersistentKeyboard;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KeyboardDtoMapper {

  KeyboardDto keyboardToDto(PersistentKeyboard persistentKeyboard);

  PersistentKeyboard keyboardDtoToEntity(KeyboardDto keyboardDto);
}
