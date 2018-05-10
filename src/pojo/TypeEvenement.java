/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.util.HashMap;

/**
 *
 * @author tiryboy
 */
public class TypeEvenement {
    
    private int id;
    private String nom;

    public TypeEvenement() {}
    
    public TypeEvenement(String nom) {
        this.nom = nom;
    }

    public TypeEvenement(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }
    
    public void exchange(HashMap<String, String> fields) {
        this.id = ( fields.containsKey( "id" ) ) ? Integer.parseInt( fields.get( "id" ) ) : null;
        this.nom = ( fields.containsKey( "nom" ) ) ? fields.get( "nom" ) : null;
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

    @Override
    public String toString() {
        return "TypeEvenement{" + "id=" + id + ", nom=" + nom + '}';
    }
    
}
