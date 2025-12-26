package com.example.demo.repository;

import com.example.demo.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface FertilizerRepository extends JpaRepository<Fertilizer, Long> {
    List<Fertilizer> findByCropName(String crop);
}
