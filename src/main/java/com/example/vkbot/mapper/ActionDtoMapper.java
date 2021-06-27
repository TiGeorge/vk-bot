package com.example.vkbot.mapper;

import com.example.vkbot.dto.ActionDto;
import com.example.vkbot.model.Action;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ActionDtoMapper {

  ActionDto entityToDto(Action entity);

  Action dtoToEntity(ActionDto dto);
}
