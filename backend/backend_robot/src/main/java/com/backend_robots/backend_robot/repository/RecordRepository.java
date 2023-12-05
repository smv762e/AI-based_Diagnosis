package com.backend_robots.backend_robot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend_robots.backend_robot.model.Record;


@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
}
