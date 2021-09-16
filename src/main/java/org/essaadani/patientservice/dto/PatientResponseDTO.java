package org.essaadani.patientservice.dto;

import lombok.Data;
import org.essaadani.patientservice.models.Medecin;

import java.util.Date;

@Data
public class PatientResponseDTO {
    private String id;
    private String nom;
    private Date dateNaissance;
    private Medecin medecin;

}
