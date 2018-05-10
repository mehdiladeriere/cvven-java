/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author tiryboy
 */
public class Participant {
    
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private Date dateNaiss;
    private String organisation;
    private String observations;
    
    public Participant() {}
    
    public Participant(String nom, String prenom, String email, Date dateNaiss, String organisation, String observations) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.dateNaiss = dateNaiss;
        this.organisation = organisation;
        this.observations = observations;
    }

    public Participant(int id, String nom, String prenom, String email, Date dateNaiss, String organisation, String observations) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.dateNaiss = dateNaiss;
        this.organisation = organisation;
        this.observations = observations;
    }
    
    public void exchange(HashMap<String, String> fields) {
        this.id = ( fields.containsKey( "id" ) ) ? Integer.parseInt( fields.get( "id" ) ) : null;
        this.nom = ( fields.containsKey( "nom" ) ) ? fields.get( "nom" ) : null;
        this.prenom = ( fields.containsKey( "prenom" ) ) ? fields.get( "prenom" ) : null;
        this.email = ( fields.containsKey( "email" ) ) ? fields.get( "email" ) : null;
        this.dateNaiss = ( fields.containsKey( "dateNaiss" ) ) ? this.SQLToDate( fields.get( "dateNaiss" ) ) : null;
        this.organisation = ( fields.containsKey( "organisation" ) ) ? fields.get( "organisation" ) : null;
        this.observations = ( fields.containsKey( "observations" ) ) ? fields.get( "observations" ) : null;
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

    public Date getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(Date dateNaiss) {
        this.dateNaiss = dateNaiss;
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
    
    public Date SQLToDate(String myDate) {
        
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");

        Date date = null;
                
        try {
            
            date = formater.parse(myDate);
            
        } catch (ParseException e) {
            
            e.printStackTrace();
        }
        
        return date;
    }

    @Override
    public String toString() {
        return "Participant{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", dateNaiss=" + dateNaiss + ", organisation=" + organisation + ", observations=" + observations + '}';
    }
}
