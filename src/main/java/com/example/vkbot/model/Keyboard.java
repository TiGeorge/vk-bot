package com.example.vkbot.model;

import java.util.List;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "keyboards", schema = "public")
public class Keyboard {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @OneToMany(mappedBy = "keyboard", fetch = FetchType.EAGER)
  private List<Button> buttons;

  private Boolean oneTime;

  private Boolean inline;

  private String name;
}
