package com.gym.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gym.entity.Booking;
import com.gym.entity.ClassSchedule;
import com.gym.repository.BookingRepository;
import com.gym.repository.ClassScheduleRepository;

@RestController
@RequestMapping("/api/members")
@Secured("ROLE_MEMBER")  // Only members can access
public class MemberController {
    private final BookingRepository bookingRepository;
    private final ClassScheduleRepository classScheduleRepository;

    public MemberController(BookingRepository bookingRepository, ClassScheduleRepository classScheduleRepository) {
        this.bookingRepository = bookingRepository;
        this.classScheduleRepository = classScheduleRepository;
    }

    @PostMapping("/book-class")
    public ResponseEntity<Booking> bookClass(@RequestBody Booking request) {  // Assume BookingRequest is a DTO, or use Booking directly
        // Logic: Check if class available, then save booking
        Booking savedBooking = bookingRepository.save(request);
        return ResponseEntity.ok(savedBooking);
    }

    @GetMapping("/schedule")
    public List<ClassSchedule> getSchedule() {
        return classScheduleRepository.findAll();  // Return all available classes
    }
}