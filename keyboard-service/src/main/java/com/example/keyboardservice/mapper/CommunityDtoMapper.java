package com.example.keyboardservice.mapper;

import com.example.keyboardservice.dto.CommunityDto;
import com.example.keyboardservice.model.Community;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommunityDtoMapper {

  CommunityDto entityToDto(Community entity);

  Community dtoToEntity(CommunityDto dto);
}
