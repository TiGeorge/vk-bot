package com.example.keyboardservice.model;

import java.util.List;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "keyboards", schema = "public")
public class PersistentKeyboard {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @OneToMany(mappedBy = "persistentKeyboard", fetch = FetchType.EAGER)
  private List<PersistentButton> buttons;

  private Boolean oneTime;

  private Boolean inline;
}
