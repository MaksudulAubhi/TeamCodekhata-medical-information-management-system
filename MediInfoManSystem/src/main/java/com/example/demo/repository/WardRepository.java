package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Ward;

public interface WardRepository extends JpaRepository<Ward, Integer> {
	 Ward findById(int id);
}
