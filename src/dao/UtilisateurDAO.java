/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import pojo.*;

/**
 *
 * @author tiryboy
 */
public class UtilisateurDAO extends DAO<Utilisateur> {
    
    public UtilisateurDAO() {
        this.table = "utilisateur";
        this.fields.put("id", "id");
        this.fields.put("username", "username");
        this.fields.put("password", "password");
    }

    @Override
    public ArrayList<Utilisateur> findAll() {
        
        String sql = this.getAllSQL();
        
        ArrayList <Utilisateur> users = new ArrayList <Utilisateur> ();
        
        for (LinkedHashMap <String, String> data : this.result( sql ) ) {
                
            Utilisateur user = new Utilisateur();

            user.exchange( data );

            users.add( user );
        }
        
        return users;
    }

    @Override
    public Utilisateur find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Utilisateur create(Utilisateur obj) {
        
        try {
            
            String sql = this.addSQL();
            
            PreparedStatement prepStmt = this.connect.prepareStatement( sql );
            
            // Values===START
            
            prepStmt.setString( 1 , obj.getUsername() );
            
            prepStmt.setString( 2 , obj.getPassword() );
            
            // Values===END
                        
            prepStmt.execute(); prepStmt.close(); return obj;
        
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        
        return null;
    }

    @Override
    public Utilisateur update(Utilisateur obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Utilisateur obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean authenticate(String usr, String pwd) {
        
        for ( Utilisateur utilisateur : this.findAll() ) {
            
            if ( utilisateur.getUsername().equals( usr ) && utilisateur.getPassword().equals( pwd ) ) 
                return true;
        }

        return false;
    }
    
}
