
package com.example.jpa.repository;

import com.example.jpa.entity.DoctorAppointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorAppointmentRepository extends JpaRepository<DoctorAppointment, Integer> {
    // Custom query methods can be added here
}