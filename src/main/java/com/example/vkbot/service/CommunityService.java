package com.example.vkbot.service;

import com.example.vkbot.dto.CommunityDto;

public interface CommunityService {

  CommunityDto createCommunity(CommunityDto communityDto);

  void updateCommunity(CommunityDto newCommunity);

  CommunityDto getCommunityById(Integer id);

  void deleteCommunity(Integer id);
}
