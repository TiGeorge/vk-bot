package com.example.vkbot.model;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "communities", schema = "public")
public class Community {

  @Id private Integer id;

  @ManyToOne
  @JoinColumn(name = "keyboard_id")
  private Keyboard keyboard;
}
