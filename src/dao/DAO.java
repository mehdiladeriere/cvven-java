/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author tiryboy
 */
public abstract class DAO<T> {
    
    /* Database */
    
    public Connection connect = Connexion.getInstance();
    
    /* Propriétés */
    
    public String table;
    
    public LinkedHashMap <String, String> fields = new LinkedHashMap <String, String> ();
    
    /* Trouver toutes les entrées dans la db */
    public abstract ArrayList<T> findAll();
    
    /* Trouver une entrée dans la db à l'aide de son id */
    public abstract T find(int id);
    
    /* Créer une entrée dans la db à partir d'un objet */
    public abstract T create(T obj);
    
    /* Mettre à jour les données d'une entrée dans la base */
    public abstract T update(T obj);
    
    /* Suppression d'une entrée de la base */
    public abstract void delete(T obj);
    
    public String getAttr(int position) {
        
        int i = 1;
            
        for ( Map.Entry field : this.fields.entrySet() ) {

            if ( i == position )
                return field.getValue().toString();

            i++;
        }
        
        return null;
    }
    
    /* Données de chaque enregistrement */
    
    public ArrayList < LinkedHashMap <String, String> > result(String sql) {
        
        try {
            
            // List which regroup all object data
        
            ArrayList < LinkedHashMap <String, String> > dataList = new ArrayList < LinkedHashMap <String, String> > ();
            
            Statement stmt = this.connect.createStatement();
            
            ResultSet result = stmt.executeQuery(sql);
            
            while ( result.next() ) {
                
                // Object data
                
                LinkedHashMap <String, String> data = new LinkedHashMap <String, String> ();
                
                for ( Map.Entry field : this.fields.entrySet() ) {
                    
                    String pojoField = field.getKey().toString();
                    
                    String dbField = field.getValue().toString();
                    
                    data.put( pojoField , result.getString( dbField ) );
                }
                
                dataList.add(data);
            }
            
            return dataList;
            
        } catch ( SQLException e ) {
            
            e.printStackTrace();
        }
        
        return null;
    }
            
    /* Données d'un enregistrement donnée */
    
    public LinkedHashMap <String, String> row(String sql) {
        
        try {
            
            // Object data
                
            LinkedHashMap <String, String> data = new LinkedHashMap <String, String> ();
            
            Statement stmt = this.connect.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE , ResultSet.CONCUR_UPDATABLE );
            
            ResultSet result = stmt.executeQuery(sql);
            
            if ( result.first() ) {
                
                for ( Map.Entry field : this.fields.entrySet() ) {
                    
                    String pojoField = field.getKey().toString();
                    
                    String dbField = field.getValue().toString();
                    
                    data.put( pojoField , result.getString( dbField ) );
                }
            }
            
            return data;
            
        } catch ( SQLException e ) {
            
            e.printStackTrace();
        }
        
        return null;
    }
    
    /* Récupère tous les enregistrements */
    
    public String getAllSQL() {
        
        return "SELECT * FROM " + this.table;
    }
    
    /* Récupère un enregistrement */
    
    public String getSQL(int id) {
        
        return "SELECT * FROM " + this.table + " WHERE " + this.getAttr(1) + "=" + id;
    }
    
    public String getSQLbis(int A, int B) {
        
        return "SELECT * FROM " + this.table + " WHERE " + this.getAttr(1) + "=" + A + " AND " + this.getAttr(2) + "=" + B;
    }
    
    /* Ajout d'un enregistrement */
    
    public String addSQL() {

        String columns = ""; String values = ""; int i = 0;

        for ( Map.Entry field : this.fields.entrySet() ) {
            
            if ( i > 0 ) {

                if ( i > 1 ) {
                    columns += ", "; values += ", ";
                }

                columns += field.getValue().toString(); values += "?";
            }

            i++;
        }

        return "INSERT INTO " + this.table + " ( " + columns + " ) VALUES ( " + values + " )";
    }
    
    public String addSQLbis() {
        
        return "INSERT INTO " + this.table + " ( " + this.getAttr(1) + ", " + this.getAttr(2) + " ) VALUES ( ?, ? )";
    }
    
    /* Modification d'un enregistrement */
    
    public String setSQL(int id) {

        String set = ""; int i = 0;

        for ( Map.Entry field : this.fields.entrySet() ) {
            
            if ( i > 0 ) {
                
                if ( i > 1 )
                    set += ", ";

                set += field.getValue().toString() + "=?";
            }
            
            i++;
        }
        
        return "UPDATE " + this.table + " SET " + set + " WHERE " + this.getAttr(1) + "=" + id;
    }
    
    public String setSQLbis(int A, int B) {
        
        return "UPDATE " + this.table + " SET " + this.getAttr(1) + "=?, " + this.getAttr(2) + "=?" 
                + " WHERE " + this.getAttr(1) + "=" + A + " AND " + this.getAttr(2) + "=" + B;
    }
    
    /* Suppression d'un enregistrement */
    
    public String rmSQL(int id) {
        
        return "DELETE FROM " + this.table + " WHERE " + this.getAttr(1) + "=" + id;
    }
    
    public String rmSQLbis(int A, int B) {
        
        return "DELETE FROM " + this.table + " WHERE " + this.getAttr(1) + "=" + A + " AND " + this.getAttr(2) + "=" + B;
    }
    
}
