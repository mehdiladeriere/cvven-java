/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import pojo.*;

/**
 *
 * @author Philippe
 */
public class SalleDAO extends DAO<Salle> {
    
    public SalleDAO() {
        this.table = "salle";
        this.fields.put("id", "id");
        this.fields.put("nom", "nom");
        this.fields.put("capacite", "capacite");
    }

    @Override
    public ArrayList<Salle> findAll() {
        
        String sql = this.getAllSQL();
        
        ArrayList <Salle> salles = new ArrayList <Salle> ();
        
        for (LinkedHashMap <String, String> data : this.result( sql ) ) {
                
            Salle salle = new Salle();

            salle.exchange( data );

            salles.add(salle);
        }
        
        return salles;
    }

    @Override
    public Salle find(int id) {
        
        String sql = this.getSQL( id );
        
        Salle salle = new Salle();
        
        salle.exchange( this.row( sql ) );
        
        return salle;
    }

    @Override
    public Salle create(Salle obj) {
        
        try {
            
            String sql = this.addSQL();
            
            PreparedStatement prepStmt = this.connect.prepareStatement( sql );
            
            // Values===START
            
            prepStmt.setString( 1 , obj.getNom() );
            
            prepStmt.setInt( 2 , obj.getCapacite() );
            
            // Values===END
                        
            prepStmt.execute(); prepStmt.close(); return obj;
        
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        
        return null;
    }

    @Override
    public Salle update(Salle obj) {
        
        try {
            
            String sql = this.setSQL( obj.getId() );
            
            PreparedStatement prepStmt = this.connect.prepareStatement( sql );
            
            // Values===START
            
            prepStmt.setString( 1 , obj.getNom() );
            
            prepStmt.setInt( 2 , obj.getCapacite() );
                        
            // Values===END
            
            prepStmt.execute(); prepStmt.close(); return obj;
        
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        
        return null;
    }

    @Override
    public void delete(Salle obj) {
        
        try {
            
            String sql = this.rmSQL( obj.getId() );
        
            Statement stmt = this.connect.createStatement();
            
            stmt.execute( sql );
            
            stmt.close();
        
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
    }
    
    public ArrayList<Salle> getAllByPerson( int nbPartMax ) {
        
        String sql = "SELECT * FROM " + this.table + " WHERE capacite >=" + nbPartMax;
        
        ArrayList <Salle> salles = new ArrayList <Salle> ();
        
        for (LinkedHashMap <String, String> data : this.result( sql ) ) {
                
            Salle salle = new Salle();

            salle.exchange( data );

            salles.add(salle);
        }
        
        return salles;
    }
    
    public ArrayList<Salle> getAllByDate( Date dateDebut ) {
        
        ArrayList <Salle> salles = new ArrayList <Salle> ();
        
        for ( Evenement evenement : new EvenementDAO().getAllByDate( dateDebut ) )
            salles.add( evenement.getSalle() );
        
        return salles;
    }
    
    public ArrayList<Salle> getAllAvailable( int nbPartMax, Date dateDebut ) {
        
        // Liste des salles (by.Person)
        
        ArrayList <Salle> salleFound = this.getAllByPerson( nbPartMax );
        
        ArrayList <Integer> salleF = new ArrayList <Integer> ();
        
        for ( Salle salle : salleFound )
            salleF.add( salle.getId() );
        
        // Liste des salles réservées
        
        ArrayList <Salle> salleReserved = this.getAllByDate( dateDebut );
        
        ArrayList <Integer> salleR = new ArrayList <Integer> ();
        
        for ( Salle salle : salleReserved )
            salleR.add( salle.getId() );
        
        // Liste des salles disponibles
        
        ArrayList <Salle> salleAvailable = new ArrayList <Salle> ();
        
        for ( int idF : salleF ) {
            
            if ( salleR.contains( idF ) == false )
                salleAvailable.add( this.find( idF ) );
        }
        
        return salleAvailable;
    }
    
    public int getCapaciteMax() {
        
        int capacite = 0;
        
        for ( Salle salle : this.findAll() ) {
            
            if ( salle.getCapacite() > capacite )
                capacite = salle.getCapacite();
        }
        
        return capacite;
    }
    
    
}
