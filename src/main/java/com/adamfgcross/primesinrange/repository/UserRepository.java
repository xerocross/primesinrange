package com.adamfgcross.primesinrange.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adamfgcross.primesinrange.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

	boolean existsByTempKey(String tempKey);
	
	Optional<User> findByUsername(String username);
}
