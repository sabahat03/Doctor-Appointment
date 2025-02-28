package com.example.jpa.controller;

import com.example.jpa.entity.DoctorAppointment;
import com.example.jpa.repository.DoctorAppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/appointments")
public class DoctorAppointmentController {

    @Autowired
    private DoctorAppointmentRepository appointmentRepo;

    @PostMapping
    public DoctorAppointment createAppointment(@RequestBody DoctorAppointment appointment) {
        return appointmentRepo.save(appointment);
    }

    @GetMapping
    public List<DoctorAppointment> getAllAppointments() {
        return appointmentRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorAppointment> getAppointmentById(@PathVariable Integer id) {
        DoctorAppointment appointment = appointmentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found with id: " + id));
        return ResponseEntity.ok(appointment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorAppointment> updateAppointmentStatus(@PathVariable Integer id, @RequestBody DoctorAppointment appointmentDetails) {
        DoctorAppointment appointment = appointmentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found with id: " + id));
        appointment.setStatus(appointmentDetails.getStatus());
        DoctorAppointment updatedAppointment = appointmentRepo.save(appointment);
        return ResponseEntity.ok(updatedAppointment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteAppointment(@PathVariable Integer id) {
        DoctorAppointment appointment = appointmentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found with id: " + id));

        if (!"Canceled".equals(appointment.getStatus())) {
            throw new RuntimeException("Only canceled appointments can be deleted.");
        }

        appointmentRepo.delete(appointment);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
