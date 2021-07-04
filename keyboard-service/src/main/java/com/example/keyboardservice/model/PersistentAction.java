package com.example.keyboardservice.model;

import com.vk.api.sdk.objects.messages.TemplateActionTypeNames;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "actions", schema = "public")
public class PersistentAction {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private TemplateActionTypeNames type;

  @Column(nullable = false)
  private String label;

  private String link;

  private String payload;

  @ManyToOne
  @JoinColumn(name = "link_keyboard_id")
  private PersistentKeyboard linkPersistentKeyboard;
}
