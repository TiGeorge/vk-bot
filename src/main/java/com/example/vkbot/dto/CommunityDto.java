package com.example.vkbot.dto;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
public class CommunityDto extends RepresentationModel<CommunityDto> {

  private Integer id;
  private Long keyboardId;
}
