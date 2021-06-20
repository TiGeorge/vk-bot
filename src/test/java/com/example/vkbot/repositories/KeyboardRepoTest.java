package com.example.vkbot.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.vkbot.model.Button;
import com.example.vkbot.model.Keyboard;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KeyboardRepoTest {

  @Autowired private KeyboardRepo keyboardRepo;

  @Test
  void findById() {
    Keyboard keyboard = keyboardRepo.findById(1L).orElseThrow();
    List<Button> buttons = keyboard.getButtons();

    assertThat(keyboard).isNotNull();
    assertThat(buttons).hasSize(5);
  }
}
