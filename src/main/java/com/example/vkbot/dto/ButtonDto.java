package com.example.vkbot.dto;

import com.vk.api.sdk.objects.messages.KeyboardButtonColor;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
public class ButtonDto extends RepresentationModel<ButtonDto> {

  private Long id;
  private KeyboardButtonColor color;
  private int rowNumber;
  private int rowOrder;
  private Long keyboardId;
  private Long actionId;
}
