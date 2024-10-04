package com.adamfgcross.primesinrange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adamfgcross.primesinrange.domain.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
