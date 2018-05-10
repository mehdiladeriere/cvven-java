/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import dao.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author tiryboy
 */
public class Evenement {
    
    private int id;
    private String intitule;
    private String theme;
    private Date dateDebut;
    private int duree;
    private int nbPartMax;
    private String description;
    private String organisateur;
    
    private TypeEvenement typeEvenement;
    private Salle salle;

    public Evenement() {}

    public Evenement(String intitule, String theme, Date dateDebut, int duree, int nbPartMax, String description, String organisateur, TypeEvenement typeEvenement, Salle salle) {
        this.intitule = intitule;
        this.theme = theme;
        this.dateDebut = dateDebut;
        this.duree = duree;
        this.nbPartMax = nbPartMax;
        this.description = description;
        this.organisateur = organisateur;
        this.typeEvenement = typeEvenement;
        this.salle = salle;
    }

    public Evenement(int id, String intitule, String theme, Date dateDebut, int duree, int nbPartMax, String description, String organisateur, TypeEvenement typeEvenement, Salle salle) {
        this.id = id;
        this.intitule = intitule;
        this.theme = theme;
        this.dateDebut = dateDebut;
        this.duree = duree;
        this.nbPartMax = nbPartMax;
        this.description = description;
        this.organisateur = organisateur;
        this.typeEvenement = typeEvenement;
        this.salle = salle;
    }
    
    /* Construire un objet à partir des données */
    
    public void exchange(HashMap<String, String> fields) {
        this.id = ( fields.containsKey( "id" ) ) ? Integer.parseInt( fields.get( "id" ) ) : null;
        this.intitule = ( fields.containsKey( "intitule" ) ) ? fields.get( "intitule" ) : null;
        this.theme = ( fields.containsKey( "theme" ) ) ? fields.get( "theme" ) : null;
        this.dateDebut = ( fields.containsKey( "dateDebut" ) ) ? this.SQLToDate(fields.get( "dateDebut" ) ) : null;
        this.duree = ( fields.containsKey( "duree" ) ) ? Integer.parseInt( fields.get( "duree" ) ) : null;
        this.nbPartMax = ( fields.containsKey( "nbPartMax" ) ) ? Integer.parseInt( fields.get( "nbPartMax" ) ) : null;
        this.description = ( fields.containsKey( "description" ) ) ? fields.get( "description" ) : null;
        this.organisateur = ( fields.containsKey( "organisateur" ) ) ? fields.get( "organisateur" ) : null;
        this.typeEvenement = ( fields.containsKey( "typeEvenement" ) ) ? new TypeEvenementDAO().find( Integer.parseInt( fields.get( "typeEvenement" ) ) ) : null;
        this.salle = ( fields.containsKey( "salle" ) ) ? new SalleDAO().find( Integer.parseInt( fields.get( "salle" ) ) ) : null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public int getNbPartMax() {
        return nbPartMax;
    }

    public void setNbPartMax(int nbPartMax) {
        this.nbPartMax = nbPartMax;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrganisateur() {
        return organisateur;
    }

    public void setOrganisateur(String organisateur) {
        this.organisateur = organisateur;
    }

    public TypeEvenement getTypeEvenement() {
        return typeEvenement;
    }

    public void setTypeEvenement(TypeEvenement typeEvenement) {
        this.typeEvenement = typeEvenement;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
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
        return "Evenement{" + "id=" + id + ", intitule=" + intitule + ", theme=" + theme + ", dateDebut=" + dateDebut + ", duree=" + duree + ", nbPartMax=" + nbPartMax + ", description=" + description + ", organisateur=" + organisateur + ", typeEvenement=" + typeEvenement + ", salle=" + salle + '}';
    }
}
