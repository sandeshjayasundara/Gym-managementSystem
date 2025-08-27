package com.gym.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gym.entity.ClassSchedule;
import com.gym.repository.ClassScheduleRepository;

@RestController
@RequestMapping("/api/trainers")
@Secured("ROLE_TRAINER")
public class TrainerController {
    private final ClassScheduleRepository classScheduleRepository;

    public TrainerController(ClassScheduleRepository classScheduleRepository) {
        this.classScheduleRepository = classScheduleRepository;
    }

    @PutMapping("/update-schedule/{id}")
    public ResponseEntity<ClassSchedule> updateSchedule(@PathVariable Long id, @RequestBody ClassSchedule updatedSchedule) {
        // Logic: Find by id, update, save
        ClassSchedule schedule = classScheduleRepository.findById(id).orElseThrow();
        schedule.setClassName(updatedSchedule.getClassName());  // උදා
        ClassSchedule saved = classScheduleRepository.save(schedule);
        return ResponseEntity.ok(saved);
    }
}