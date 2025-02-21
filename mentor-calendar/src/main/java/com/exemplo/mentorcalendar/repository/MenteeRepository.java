package com.exemplo.mentorcalendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemplo.mentorcalendar.model.Mentee;

public interface MenteeRepository extends JpaRepository<Mentee, Long> {
}