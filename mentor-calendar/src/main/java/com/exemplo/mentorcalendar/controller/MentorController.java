package com.exemplo.mentorcalendar.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exemplo.mentorcalendar.model.Mentor;
import com.exemplo.mentorcalendar.service.MentorService;

@RestController
@RequestMapping("/api/mentor")
public class MentorController {

    @Autowired
    private MentorService mentorService;

    @PostMapping
    public ResponseEntity<Mentor> createMentor(@RequestBody Mentor mentor) {
        Mentor savedMentor = mentorService.createMentor(mentor);
        return ResponseEntity.ok(savedMentor);
    }

    @GetMapping
    public ResponseEntity<List<Mentor>> getAllMentors() {
        List<Mentor> mentors = mentorService.getAllMentors();
        return ResponseEntity.ok(mentors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mentor> getMentorById(@PathVariable Long id) {
        Optional<Mentor> mentor = mentorService.getMentorById(id);
        return mentor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mentor> updateMentor(@PathVariable Long id, @RequestBody Mentor mentorDetails) {
        Mentor updatedMentor = mentorService.updateMentor(id, mentorDetails);
        return ResponseEntity.ok(updatedMentor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMentor(@PathVariable Long id) {
        mentorService.deleteMentor(id);
        return ResponseEntity.noContent().build();
    }
}