package com.exemplo.mentorcalendar.service;

import com.exemplo.mentorcalendar.model.Schedule;
import com.exemplo.mentorcalendar.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    public Schedule createSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    public Optional<Schedule> getScheduleById(Long id) {
        return scheduleRepository.findById(id);
    }

    public Schedule updateSchedule(Long id, Schedule scheduleDetails) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(() -> new RuntimeException("Schedule não encontrado"));
        schedule.setMentor(scheduleDetails.getMentor());
        schedule.setMentee(scheduleDetails.getMentee());
        schedule.setDate(scheduleDetails.getDate());
        schedule.setStatus(scheduleDetails.getStatus());
        return scheduleRepository.save(schedule);
    }

    public void deleteSchedule(Long id) {
        scheduleRepository.deleteById(id);
    }
}