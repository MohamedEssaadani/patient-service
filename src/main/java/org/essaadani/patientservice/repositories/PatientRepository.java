package org.essaadani.patientservice.repositories;

import org.essaadani.patientservice.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, String> {
}
