package com.example.vkbot.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.example.vkbot.dto.ButtonDto;
import com.example.vkbot.dto.KeyboardDto;
import com.example.vkbot.service.KeyboardService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.Link;
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
    KeyboardDto keyboard = keyboardService.getKeyboardById(id);
    Link selfLink = linkTo(methodOn(KeyboardController.class).getKeyboard(id)).withSelfRel();
    keyboard.add(selfLink);
    Link link = linkTo(methodOn(KeyboardController.class).getButtonsForKeyboard(id)).withSelfRel();
    keyboard.add(link);
    return keyboard;
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteKeyboard(@PathVariable("id") Long id) {
    keyboardService.deleteKeyboard(id);
  }

  @GetMapping("/{id}/buttons")
  public List<ButtonDto> getButtonsForKeyboard(@PathVariable("id") Long id) {
    return keyboardService.getButtonsForKeyboard(id);
  }
}
