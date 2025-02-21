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

import com.exemplo.mentorcalendar.model.Mentee;
import com.exemplo.mentorcalendar.service.MenteeService;

@RestController
@RequestMapping("/api/mentee")
public class MenteeController {

    @Autowired
    private MenteeService menteeService;

    @PostMapping
    public ResponseEntity<Mentee> createMentee(@RequestBody Mentee mentee) {
        Mentee savedMentee = menteeService.createMentee(mentee);
        return ResponseEntity.ok(savedMentee);
    }

    @GetMapping
    public ResponseEntity<List<Mentee>> getAllMentees() {
        List<Mentee> mentees = menteeService.getAllMentees();
        return ResponseEntity.ok(mentees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mentee> getMenteeById(@PathVariable Long id) {
        Optional<Mentee> mentee = menteeService.getMenteeById(id);
        return mentee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mentee> updateMentee(@PathVariable Long id, @RequestBody Mentee menteeDetails) {
        Mentee updatedMentee = menteeService.updateMentee(id, menteeDetails);
        return ResponseEntity.ok(updatedMentee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMentee(@PathVariable Long id) {
        menteeService.deleteMentee(id);
        return ResponseEntity.noContent().build();
    }
}