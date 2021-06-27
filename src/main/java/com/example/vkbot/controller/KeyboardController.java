package com.example.vkbot.controller;

import com.example.vkbot.dto.KeyboardDto;
import com.example.vkbot.service.KeyboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/keyboards")
public class KeyboardController {

  private final KeyboardService keyboardService;

  @PostMapping
  public KeyboardDto createKeyboard(@RequestBody KeyboardDto newKeyboard) {
    return keyboardService.createKeyboard(newKeyboard);
  }

  @PutMapping
  @ResponseStatus(HttpStatus.OK)
  public void updateKeyboard(@RequestBody KeyboardDto newKeyboard) {
    keyboardService.updateKeyboard(newKeyboard);
  }

  @GetMapping("/{id}")
  public KeyboardDto getKeyboard(@PathVariable("id") Long id) {
    return keyboardService.getKeyboardById(id);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteKeyboard(@PathVariable("id") Long id) {
    keyboardService.deleteKeyboard(id);
  }
}
