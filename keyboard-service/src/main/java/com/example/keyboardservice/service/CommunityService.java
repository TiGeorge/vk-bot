package com.example.keyboardservice.service;

import com.example.keyboardservice.dto.CommunityDto;

public interface CommunityService {

  CommunityDto createCommunity(CommunityDto communityDto);

  void updateCommunity(CommunityDto newCommunity);

  CommunityDto getCommunityById(Integer id);

  void deleteCommunity(Integer id);
}
