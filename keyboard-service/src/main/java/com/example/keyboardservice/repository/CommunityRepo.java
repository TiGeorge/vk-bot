package com.example.keyboardservice.repository;

import com.example.keyboardservice.model.Community;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityRepo extends JpaRepository<Community, Integer> {}
