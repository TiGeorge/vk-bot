package com.example.keyboardservice.controller;

import com.example.keyboardservice.dto.ActionDto;
import com.example.keyboardservice.service.ActionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/actions")
public class ActionController {

  private final ActionService actionService;

  @PostMapping
  public ActionDto createAction(@RequestBody ActionDto newAction) {
    return actionService.createAction(newAction);
  }

  @PutMapping
  @ResponseStatus(HttpStatus.OK)
  public void updateAction(@RequestBody ActionDto newAction) {
    actionService.updateAction(newAction);
  }

  @GetMapping("/{id}")
  public ActionDto getAction(@PathVariable("id") Long id) {
    return actionService.getActionById(id);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteAction(@PathVariable("id") Long id) {
    actionService.deleteAction(id);
  }
}
