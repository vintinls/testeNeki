package com.exemplo.mentorcalendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemplo.mentorcalendar.model.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}