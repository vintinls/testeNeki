package com.exemplo.mentorcalendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemplo.mentorcalendar.model.Mentor;

public interface MentorRepository extends JpaRepository<Mentor, Long> {
}