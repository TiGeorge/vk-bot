package com.example.keyboardservice.service;

import com.example.keyboardservice.dto.CommunityDto;
import com.example.keyboardservice.mapper.CommunityDtoMapper;
import com.example.keyboardservice.model.Community;
import com.example.keyboardservice.repository.CommunityRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommunityServiceImpl implements CommunityService {

  private final CommunityRepo communityRepo;
  private final CommunityDtoMapper communityDtoMapper;

  @Override
  public CommunityDto createCommunity(CommunityDto communityDto) {
    communityDto.setId(null);
    Community community = communityDtoMapper.dtoToEntity(communityDto);
    community = communityRepo.save(community);
    return communityDtoMapper.entityToDto(community);
  }

  @Override
  public void updateCommunity(CommunityDto communityDto) {
    Community community = communityDtoMapper.dtoToEntity(communityDto);
    communityRepo.save(community);
  }

  @Override
  public CommunityDto getCommunityById(Integer id) {
    Community community = communityRepo.findById(id).orElseThrow();
    return communityDtoMapper.entityToDto(community);
  }

  @Override
  public void deleteCommunity(Integer id) {
    communityRepo.deleteById(id);
  }
}
