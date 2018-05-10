/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import pojo.*;

/**
 *
 * @author tiryboy
 */
public class EvenementDAO extends DAO<Evenement> {
    
    public EvenementDAO() {
        this.table = "evenement";
        this.fields.put("id", "id");
        this.fields.put("intitule", "intitule");
        this.fields.put("theme", "theme");
        this.fields.put("dateDebut", "date_debut");
        this.fields.put("duree", "duree");
        this.fields.put("nbPartMax", "nb_part_max");
        this.fields.put("description", "description");
        this.fields.put("organisateur", "organisateur");
        this.fields.put("typeEvenement", "id_type");
        this.fields.put("salle", "id_salle");
    }

    @Override
    public ArrayList<Evenement> findAll() {
        
        String sql = this.getAllSQL();
        
        ArrayList <Evenement> evenements = new ArrayList <Evenement> ();
        
        for ( HashMap <String, String> objectData : this.result( sql ) ) {
            
            Evenement evenement = new Evenement();
            
            evenement.exchange( objectData );
            
            evenements.add( evenement );
        }
        
        return evenements;
    }

    @Override
    public Evenement find(int id) {
        
        String sql = this.getSQL( id );
        
        Evenement evenement = new Evenement();
        
        evenement.exchange( this.row( sql ) );
        
        return evenement;
    }

    @Override
    public Evenement create(Evenement obj) {
        
        try {
            
            String sql = this.addSQL();

            PreparedStatement prepStmt = this.connect.prepareStatement( sql );

            // Values===START
            
            prepStmt.setString( 1 , obj.getIntitule());

            prepStmt.setString( 2 , obj.getTheme());

            prepStmt.setDate( 3 , new Date( obj.getDateDebut().getTime() ) );

            prepStmt.setInt( 4 , obj.getDuree());

            prepStmt.setInt( 5 , obj.getNbPartMax());

            prepStmt.setString( 6 , obj.getDescription());

            prepStmt.setString( 7 , obj.getOrganisateur());
            
            prepStmt.setInt( 8 , obj.getTypeEvenement().getId() );
            
            prepStmt.setInt( 9 , obj.getSalle().getId() );

            // Values===END
            
            prepStmt.execute(); prepStmt.close(); return obj;

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Evenement update(Evenement obj) {
        
        try {
            
            String sql = this.setSQL( obj.getId() );
            
            PreparedStatement prepStmt = this.connect.prepareStatement( sql );
            
            // Values===START
            
            prepStmt.setString( 1 , obj.getIntitule() );
            
            prepStmt.setString( 2 , obj.getTheme() );
            
            prepStmt.setDate( 3 , new Date( obj.getDateDebut().getTime() ) );
            
            prepStmt.setInt( 4 , obj.getDuree() );
            
            prepStmt.setInt( 5 , obj.getNbPartMax() );
            
            prepStmt.setString( 6 , obj.getDescription() );
            
            prepStmt.setString( 7 , obj.getOrganisateur() );
            
            prepStmt.setInt( 8 , obj.getTypeEvenement().getId() );
            
            prepStmt.setInt( 9 , obj.getSalle().getId() );
                        
            // Values===END
            
            prepStmt.execute(); prepStmt.close(); return obj;
        
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        
        return null;
    }

    @Override
    public void delete(Evenement obj) {
        
        try {
            
            String sql = this.rmSQL( obj.getId() );

            Statement stmt = this.connect.createStatement();

            stmt.execute( sql );

            stmt.close();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
    
    public ArrayList<Evenement> getAllByDate( java.util.Date dateDebut ) {
        
        String sql = "SELECT * FROM " + this.table + " WHERE date_debut='" + new java.sql.Date( dateDebut.getTime() ) + "'";
        
        ArrayList <Evenement> evenements = new ArrayList <Evenement> ();
        
        for (LinkedHashMap <String, String> data : this.result( sql ) ) {
                
            Evenement evenement = new Evenement();

            evenement.exchange( data );

            evenements.add( evenement );
        }
        
        return evenements;
    }
    
    public ArrayList<Evenement> getAllAvailable() {
        
        ArrayList <Evenement> evenements = new ArrayList <Evenement> ();
        
        for ( Evenement evenement : this.getAllNotArchived() ) {
            
            int countParticipant = 0;
            
            for ( Invitation invitation : new InvitationDAO().findAll() ) {
                
                if ( invitation.getEvenement().getId() == evenement.getId() ) {
                    
                    countParticipant++;
                }
            }
            
            if ( countParticipant < evenement.getNbPartMax() )
                evenements.add( evenement );
        }
        
        return evenements;
    }
    
    public ArrayList<Evenement> getAllArchived() {
        
        java.util.Date date = new java.util.Date();
        
        ArrayList <Evenement> evenements = new ArrayList <Evenement> ();
        
        for ( Evenement evenement : this.findAll() ) {
                
            if ( evenement.getDateDebut().getTime() < date.getTime() ) {

                evenements.add( evenement );
            }
        }
        
        return evenements;
    }
    
    public ArrayList<Evenement> getAllNotArchived() {
        
        java.util.Date date = new java.util.Date();
        
        ArrayList <Evenement> evenements = new ArrayList <Evenement> ();
        
        for ( Evenement evenement : this.findAll() ) {
                
            if ( evenement.getDateDebut().getTime() > date.getTime() ) {

                evenements.add( evenement );
            }
        }
        
        return evenements;
    }
    
}
