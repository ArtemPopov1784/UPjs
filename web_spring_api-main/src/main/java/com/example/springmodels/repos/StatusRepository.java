package com.example.springmodels.repos;

import com.example.springmodels.models.Status;
import org.springframework.data.jpa.repository.JpaRepository;



public interface StatusRepository extends JpaRepository<Status, Integer> {
}
