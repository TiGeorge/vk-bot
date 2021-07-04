package com.example.keyboardservice.controller;

import com.example.keyboardservice.dto.ButtonDto;
import com.example.keyboardservice.service.ButtonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/buttons")
public class ButtonController {

  private final ButtonService buttonService;

  @PostMapping
  public ButtonDto createButton(@RequestBody ButtonDto newButton) {
    return buttonService.createButton(newButton);
  }

  @PutMapping
  @ResponseStatus(HttpStatus.OK)
  public void updateButton(@RequestBody ButtonDto newButton) {
    buttonService.updateButton(newButton);
  }

  @GetMapping("/{id}")
  public ButtonDto getButton(@PathVariable("id") Long id) {
    return buttonService.getButtonById(id);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteButton(@PathVariable("id") Long id) {
    buttonService.deleteButton(id);
  }
}
