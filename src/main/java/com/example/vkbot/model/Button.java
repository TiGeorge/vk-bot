package com.example.vkbot.model;

import com.vk.api.sdk.objects.messages.KeyboardButtonColor;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "buttons", schema = "public")
public class Button {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "keyboard_id", nullable = false)
  private Keyboard keyboard;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private KeyboardButtonColor color;

  @ManyToOne
  @JoinColumn(name = "action_id", nullable = false)
  private Action action;

  private int rowNumber;

  private int rowOrder;
}
