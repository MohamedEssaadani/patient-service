package org.essaadani.patientservice.models;

import lombok.Data;

import java.util.Date;

@Data
public class Medecin {
    private String id;
    private String nom;
    private Date dateNaissance;
    private String specialite;
}
