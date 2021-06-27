package com.example.vkbot.controller;

import com.example.vkbot.dto.CommunityDto;
import com.example.vkbot.service.CommunityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/communities")
public class CommunityController {

  private final CommunityService communityService;

  @PostMapping
  public CommunityDto createCommunity(@RequestBody CommunityDto communityDto) {
    return communityService.createCommunity(communityDto);
  }

  @PutMapping
  @ResponseStatus(HttpStatus.OK)
  public void updateCommunity(@RequestBody CommunityDto newCommunity) {
    communityService.updateCommunity(newCommunity);
  }

  @GetMapping("/{id}")
  public CommunityDto getCommunity(@PathVariable("id") Integer id) {
    return communityService.getCommunityById(id);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteCommunity(@PathVariable("id") Integer id) {
    communityService.deleteCommunity(id);
  }
}
