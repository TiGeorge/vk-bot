package com.example.keyboardservice.mapper;

import com.example.keyboardservice.dto.ActionDto;
import com.example.keyboardservice.model.PersistentAction;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ActionDtoMapper {

  ActionDto entityToDto(PersistentAction entity);

  PersistentAction dtoToEntity(ActionDto dto);
}
