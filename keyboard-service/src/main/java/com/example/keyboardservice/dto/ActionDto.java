package com.example.keyboardservice.dto;

import com.vk.api.sdk.objects.messages.TemplateActionTypeNames;
import lombok.Data;

@Data
public class ActionDto{

  private Long id;
  private TemplateActionTypeNames type;
  private String label;
  private String link;
  private String payload;
  private Long linkKeyboardId;
}
