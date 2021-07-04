package com.example.keyboardservice.repository;

import com.example.keyboardservice.model.PersistentButton;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ButtonRepo extends JpaRepository<PersistentButton, Long> {

}
