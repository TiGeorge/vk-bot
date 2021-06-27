package com.example.vkbot.mapper;

import com.example.vkbot.dto.ButtonDto;
import com.example.vkbot.model.Button;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ButtonDtoMupper {

  ButtonDto entityToDto(Button entity);

  Button dtoToEntity(ButtonDto dto);
}
