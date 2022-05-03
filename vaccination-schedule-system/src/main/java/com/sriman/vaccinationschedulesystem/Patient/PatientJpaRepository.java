package com.sriman.vaccinationschedulesystem.Patient;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientJpaRepository extends JpaRepository<Patient, Integer> {
}
