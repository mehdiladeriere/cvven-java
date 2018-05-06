/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.Connexion;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 *
 * @author Micka
 */
public abstract class DAO<T> {
    
    /* Connexion à la base de données */
    public Connection connect = Connexion.getInstance();
    
    /* Nom de la table */
    public String table;
    
    /* Récuperer les champs POJO et DB */
    public LinkedHashMap <String, String> fields = new LinkedHashMap <String, String> ();
    
    /* Récupère toutes les entrées d'une Table */
    public abstract ArrayList <T> findAll();
    
    /* Récupère l'entrée qui correspond à l'ID */
    public abstract T find( int id );
    
    /* Création d'un objet de la table */
    public abstract T create( T obj );
    
    /* MAJ d'un objet de la table */
    public abstract T update( T obj );
    
    /* Suppression d'un objet de la table */
    public abstract void delete( T obj );
        
  
    
    
    
    
}
