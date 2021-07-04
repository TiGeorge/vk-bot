package com.example.keyboardservice.repository;

import com.example.keyboardservice.model.PersistentKeyboard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeyboardRepo extends JpaRepository<PersistentKeyboard, Long> {}
