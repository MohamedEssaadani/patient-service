package org.essaadani.patientservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.essaadani.patientservice.models.Medecin;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    @Id
    private String id;
    private String nom;
    private Date dateNaissance;
    private String medecinID;

    @Transient
    private Medecin medecin;
}
