package com.exemplo.mentorcalendar.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "mentor_id", nullable = false)
    private Mentor mentor;

    @ManyToOne
    @JoinColumn(name = "mentee_id", nullable = false)
    private Mentee mentee;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(nullable = false)
    private String status = "pending"; // pending, confirmed, canceled

    private String googleEventId; // ID do evento no Google Calendar
}