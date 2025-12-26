package com.example.demo.repository;

import com.example.demo.entity.Fertilizer;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface FertilizerRepository extends JpaRepository<Fertilizer, Long> {

    @Query("SELECT f FROM Fertilizer f WHERE f.recommendedForCrops LIKE %:crop%")
    List<Fertilizer> findByCropName(@Param("crop") String crop);
}
