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
import java.util.LinkedHashMap;
import pojo.*;

/**
 *
 * @author Philippe
 */
public class InvitationDAO extends DAO<Invitation> {
    
    public InvitationDAO() {
        this.table = "invitation";
        this.fields.put("evenement", "id_evenement");
        this.fields.put("participant", "id_participant");
    }

    @Override
    public ArrayList <Invitation> findAll() {
        
        String sql = this.getAllSQL();

        ArrayList <Invitation> invitations = new ArrayList <Invitation> ();

        for ( LinkedHashMap<String, String> objectData : this.result( sql ) ) {

            Invitation invitation = new Invitation();

            invitation.exchange( objectData );

            invitations.add( invitation );
        }

        return invitations;
    }

    @Override
    public Invitation find(int id) { return null; }
    
    public Invitation find(int A, int B) {
        
        String sql = this.getSQLbis(A, B);

        Invitation invitation = new Invitation();

        invitation.exchange( this.row( sql ) );

        return invitation;
    }

    @Override
    public Invitation create(Invitation obj) {
        
        try {
            
            String sql = this.addSQLbis();
            
            PreparedStatement prepStmt = this.connect.prepareStatement( sql );
            
            // Values===START
            
            prepStmt.setInt( 1 , obj.getEvenement().getId() );
            
            prepStmt.setInt( 2 , obj.getParticipant().getId() );
            
            // Values===END
                        
            prepStmt.execute(); prepStmt.close(); return obj;
        
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        
        return null;
    }

    @Override
    public Invitation update(Invitation obj) { return null; }
    
    public Invitation update(Invitation old, Invitation obj) {
        
        try {
            
            String sql = this.setSQLbis( old.getEvenement().getId() , old.getParticipant().getId() );
            
            PreparedStatement prepStmt = this.connect.prepareStatement( sql );
            
            // Values===START
            
            prepStmt.setInt( 1 , obj.getEvenement().getId() );
            
            prepStmt.setInt( 2 , obj.getParticipant().getId() );
            
            // Values===END
            
            prepStmt.execute(); prepStmt.close(); return obj;
        
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        
        return null;
    }

    @Override
    public void delete(Invitation obj) {
        
        try {
            
            String sql = this.rmSQLbis( obj.getEvenement().getId() , obj.getParticipant().getId() );
        
            Statement stmt = this.connect.createStatement();
            
            stmt.execute( sql ); stmt.close();
        
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
    }
}