package com.example.vkbot.repository;

import com.example.vkbot.model.Action;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActionRepo extends JpaRepository<Action, Long> {

}