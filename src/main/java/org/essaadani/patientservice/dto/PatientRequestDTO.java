package org.essaadani.patientservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class PatientRequestDTO {
    private String nom;
    private Date dateNaissance;
    private String medecinID;
}
