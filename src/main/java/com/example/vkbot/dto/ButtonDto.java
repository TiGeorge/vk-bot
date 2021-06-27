package com.example.vkbot.dto;

import com.vk.api.sdk.objects.messages.KeyboardButtonColor;
import lombok.Data;

@Data
public class ButtonDto {

  private Long id;
  private KeyboardButtonColor color;
  private int rowNumber;
  private int rowOrder;
  private Long keyboardId;
  private Long actionId;
}
