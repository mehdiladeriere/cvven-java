/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.util.Date;

/**
 *
 * @author Micka
 */
public class Participant {
    
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private Date dateNaissance;
    private String organisation;
    private String observations;

    public Participant() {
    }

    public Participant(String nom, String prenom, String email, Date dateNaissance, String organisation, String observations) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.dateNaissance = dateNaissance;
        this.organisation = organisation;
        this.observations = observations;
    }

    public Participant(int id, String nom, String prenom, String email, Date dateNaissance, String organisation, String observations) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.dateNaissance = dateNaissance;
        this.organisation = organisation;
        this.observations = observations;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    @Override
    public String toString() {
        return "Participant{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", dateNaissance=" + dateNaissance + ", organisation=" + organisation + ", observations=" + observations + '}';
    }
    
    
            
    
}
