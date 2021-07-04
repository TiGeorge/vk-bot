package com.example.keyboardservice.repository;

import com.example.keyboardservice.model.PersistentAction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActionRepo extends JpaRepository<PersistentAction, Long> {

}
