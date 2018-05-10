/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.util.LinkedHashMap;

/**
 *
 * @author tiryboy
 */
public class Salle {
    
    private int id;
    private String nom;
    private int capacite;

    public Salle() {}
    
    public Salle(String nom, int capacite) {
        this.nom = nom;
        this.capacite = capacite;
    }

    public Salle(int id, String nom, int capacite) {
        this.id = id;
        this.nom = nom;
        this.capacite = capacite;
    }
    
    public void exchange(LinkedHashMap <String, String> data) {
        this.id = ( data.containsKey( "id" ) ) ? Integer.parseInt( data.get( "id" ) ) : null;
        this.nom = ( data.containsKey( "nom" ) ) ? data.get( "nom" ) : null;
        this.capacite = ( data.containsKey( "capacite" ) ) ? Integer.parseInt( data.get( "capacite" ) ) : null;
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

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    @Override
    public String toString() {
        return "Salle{" + "id=" + id + ", nom=" + nom + ", capacite=" + capacite + '}';
    }
}
