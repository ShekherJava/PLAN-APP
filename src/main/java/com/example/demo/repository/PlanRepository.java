package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.PlanEntity;

public interface PlanRepository extends JpaRepository<PlanEntity, String> {

}