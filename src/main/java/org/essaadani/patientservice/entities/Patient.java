package org.essaadani.patientservice.entities;

import org.essaadani.patientservice.models.Medecin;

import javax.persistence.Transient;
import java.util.Date;

public class Patient {
    private String id;
    private String nom;
    private Date dateNaissance;
    private String medecinID;

    @Transient
    private Medecin medecin;
}
