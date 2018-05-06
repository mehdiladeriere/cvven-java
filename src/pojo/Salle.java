
package pojo;

import java.util.LinkedHashMap;

public class Salle {
    
    private int id;
    private int capacite;
    private String nom;

    public Salle() {
    }

    public Salle(int capacite, String nom) {
        this.capacite = capacite;
        this.nom = nom;
    }
    
    public Salle(int id, int capacite, String nom) {
        this.id = id;
        this.capacite = capacite;
        this.nom = nom;
    }
    
    public void exchange( LinkedHashMap <String, String> data) {
        this.id = ( data.containsKey( "id" ) ) ? Integer.parseInt( data.get( "id" ) ) : null;
        this.nom = ( data.containsKey( "nom" ) ) ? data.get( "nom" ) : null;
        this.capacite = ( data.containsKey( "capacite" ) ) ? Integer.parseInt( data.get( "nom" ) ) : null;          
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Salle{" + "id=" + id + ", capacite=" + capacite + ", nom=" + nom + '}';
    }
}
