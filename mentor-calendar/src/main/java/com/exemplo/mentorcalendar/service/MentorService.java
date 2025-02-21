package com.exemplo.mentorcalendar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemplo.mentorcalendar.model.Mentor;
import com.exemplo.mentorcalendar.repository.MentorRepository;

@Service
public class MentorService {

    @Autowired
    private MentorRepository mentorRepository;

    public Mentor createMentor(Mentor mentor) {
        return mentorRepository.save(mentor);
    }

    public List<Mentor> getAllMentors() {
        return mentorRepository.findAll();
    }

    public Optional<Mentor> getMentorById(Long id) {
        return mentorRepository.findById(id);
    }

    public Mentor updateMentor(Long id, Mentor mentorDetails) {
        Mentor mentor = mentorRepository.findById(id).orElseThrow(() -> new RuntimeException("Mentor não encontrado"));
        mentor.setName(mentorDetails.getName());
        mentor.setEmail(mentorDetails.getEmail());
        return mentorRepository.save(mentor);
    }

    public void deleteMentor(Long id) {
        mentorRepository.deleteById(id);
    }
}