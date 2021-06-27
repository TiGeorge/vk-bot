package com.example.vkbot.dto;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
public class KeyboardDto extends RepresentationModel<KeyboardDto> {

  private Long id;
  private String name;
  private Boolean oneTime;
  private Boolean inline;
}
