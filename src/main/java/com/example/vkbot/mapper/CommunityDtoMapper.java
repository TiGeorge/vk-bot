package com.example.vkbot.mapper;

import com.example.vkbot.dto.CommunityDto;
import com.example.vkbot.model.Community;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommunityDtoMapper {

  CommunityDto entityToDto(Community entity);

  Community dtoToEntity(CommunityDto dto);

}
