package com.exemplo.mentorcalendar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemplo.mentorcalendar.model.Mentee;
import com.exemplo.mentorcalendar.repository.MenteeRepository;

@Service
public class MenteeService {

    @Autowired
    private MenteeRepository menteeRepository;

    public Mentee createMentee(Mentee mentee) {
        return menteeRepository.save(mentee);
    }

    public List<Mentee> getAllMentees() {
        return menteeRepository.findAll();
    }

    public Optional<Mentee> getMenteeById(Long id) {
        return menteeRepository.findById(id);
    }

    public Mentee updateMentee(Long id, Mentee menteeDetails) {
        Mentee mentee = menteeRepository.findById(id).orElseThrow(() -> new RuntimeException("Mentee não encontrado"));
        mentee.setName(menteeDetails.getName());
        mentee.setEmail(menteeDetails.getEmail());
        return menteeRepository.save(mentee);
    }

    public void deleteMentee(Long id) {
        menteeRepository.deleteById(id);
    }
}