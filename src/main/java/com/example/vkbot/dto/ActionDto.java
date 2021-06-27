package com.example.vkbot.dto;

import com.vk.api.sdk.objects.messages.TemplateActionTypeNames;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
public class ActionDto extends RepresentationModel<ActionDto> {

  private Long id;
  private TemplateActionTypeNames type;
  private String label;
  private String link;
  private String payload;
  private Long linkKeyboardId;
}
