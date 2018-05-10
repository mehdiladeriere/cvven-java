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
import pojo.*;

/**
 *
 * @author p-lao
 */
public class ParticipantDAO extends DAO<Participant> {
    
    public ParticipantDAO() {
        this.table = "participant";
        this.fields.put("id", "id");
        this.fields.put("nom", "nom");
        this.fields.put("prenom", "prenom");
        this.fields.put("email", "email");
        this.fields.put("dateNaiss", "date_naiss");
        this.fields.put("organisation", "organisation");
        this.fields.put("observations", "observations");
    }

    @Override
    public ArrayList<Participant> findAll() {
        
        String sql = this.getAllSQL();
        
        ArrayList <Participant> participants = new ArrayList <Participant> ();
        
        for ( HashMap <String, String> objectData : this.result( sql ) ) {
            
            Participant participant = new Participant();
            
            participant.exchange(objectData);
            
            participants.add( participant );
        }
        
        return participants;
    }

    @Override
    public Participant find(int id) {
        
        String sql = this.getSQL( id );
        
        Participant participant = new Participant();
        
        participant.exchange( this.row( sql ) );
        
        return participant;
    }

    @Override
    public Participant create(Participant obj) {
        
        try {
            
            String sql = this.addSQL();
            
            PreparedStatement prepStmt = this.connect.prepareStatement( sql );
            
            // Values===START
            
            prepStmt.setString( 1 , obj.getNom() );
            
            prepStmt.setString( 2 , obj.getPrenom() ); 
            
            prepStmt.setString( 3 , obj.getEmail() );
            
            prepStmt.setDate( 4 , new Date( obj.getDateNaiss().getTime() ) );
            
            prepStmt.setString( 5 , obj.getOrganisation() );
            
            prepStmt.setString( 6 , obj.getObservations() );
            
            // Values===END
                        
            prepStmt.execute(); prepStmt.close(); return obj;
        
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        
        return null;
    }

    @Override
    public Participant update(Participant obj) {
        
        try {
            
            String sql = this.setSQL( obj.getId() );
            
            PreparedStatement prepStmt = this.connect.prepareStatement( sql );
            
            // Values===START
            
            prepStmt.setString( 1 , obj.getNom() );
            
            prepStmt.setString( 2 , obj.getPrenom() ); 
            
            prepStmt.setString( 3 , obj.getEmail() );
            
            prepStmt.setDate( 4 , new Date( obj.getDateNaiss().getTime() ) );
            
            prepStmt.setString( 5 , obj.getOrganisation() );
            
            prepStmt.setString( 6 , obj.getObservations() );
                        
            // Values===END
            
            prepStmt.execute(); prepStmt.close(); return obj;
        
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        
        return null;
    }

    @Override
    public void delete(Participant obj) {
        
        try {
            
            String sql = this.rmSQL( obj.getId() );
        
            Statement stmt = this.connect.createStatement();
            
            stmt.execute( sql );
            
            stmt.close();
        
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
    }

    public ArrayList<Participant> findAllByEvenement(int id) {
        
        // Liste de participants en fonction d'un événement donné
        
        ArrayList <Participant> participants = new ArrayList <Participant> ();
        
        // Toutes les entrées de la table invitation
        
        for ( Invitation invitation : new InvitationDAO().findAll() ) {
            
            if ( invitation.getEvenement().getId() == id )
                participants.add( invitation.getParticipant() );
        }
        
        return participants;
    }
    
    public ArrayList<Participant> findAllNotByEvenement(int id) {
        
        ArrayList<Participant> participants = new ArrayList<Participant> ();
        
        for ( Participant participantA : this.findAll() ) {
            
            boolean not = true;
            
            for ( Participant participantB : this.findAllByEvenement(id) ) {
                
                if ( participantA.getId() == participantB.getId() )
                    not = false;
            }
            
            if ( not )
                participants.add( participantA );
        }
        
        return participants;
    }

    public boolean isParticipant(Participant obj) {
        
        for ( Participant participant : this.findAll() ) {
            
            if ( participant.getEmail().equals( obj.getEmail() ) )
                return true;
        }
        
        return false;
    }
    
    public Participant findByEmail(String email) {
        
        String sql = "SELECT * FROM " + this.table + " WHERE email='" + email + "'";
        
        Participant participant = new Participant();
        
        participant.exchange( this.row( sql ) );
        
        return participant;
    }
}
