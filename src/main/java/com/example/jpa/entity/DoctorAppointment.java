package com.example.jpa.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class DoctorAppointment {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String patientName;
    private String doctorName;
    private Date appointmentDate;
    private String status; // Scheduled, Completed, Canceled

    // Constructors
    public DoctorAppointment() {}

    public DoctorAppointment(Integer id, String patientName, String doctorName, Date appointmentDate, String status) {
        this.id = id;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.appointmentDate = appointmentDate;
        this.status = status;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getPatientName() {
        return patientName;
    }
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
    public String getDoctorName() {
        return doctorName;
    }
    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
    public Date getAppointmentDate() {
        return appointmentDate;
    }
    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
