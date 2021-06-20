package com.example.vkbot.repositories;

import com.example.vkbot.model.Community;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityRepo extends JpaRepository<Community, Integer> {}
