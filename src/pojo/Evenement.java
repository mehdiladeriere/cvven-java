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

    public Evenement() {
    }

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

    @Override
    public String toString() {
        return "Evenement{" + "id=" + id + ", intitule=" + intitule + ", theme=" + theme + ", dateDebut=" + dateDebut + ", duree=" + duree + ", nbPartMax=" + nbPartMax + ", description=" + description + ", organisateur=" + organisateur + ", typeEvenement=" + typeEvenement + ", salle=" + salle + '}';
    }

    
    
    
    
    
    
    
    
}
