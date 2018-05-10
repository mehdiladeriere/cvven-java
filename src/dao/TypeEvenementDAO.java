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
import java.util.HashMap;
import pojo.*;

/**
 *
 * @author p-lao
 */
public class TypeEvenementDAO extends DAO<TypeEvenement> {
    
    public TypeEvenementDAO() {
        this.table = "type_evenement";
        this.fields.put("id", "id");
        this.fields.put("nom", "nom");
    }

    @Override
    public ArrayList<TypeEvenement> findAll() {
        
        String sql = this.getAllSQL();
        
        ArrayList <TypeEvenement> typeEvenements = new ArrayList <TypeEvenement> ();
        
        for ( HashMap <String, String> objectData : this.result( sql ) ) {
            
            TypeEvenement typeEvenement = new TypeEvenement();
            
            typeEvenement.exchange(objectData);
            
            typeEvenements.add( typeEvenement );
        }
        
        return typeEvenements;
    }

    @Override
    public TypeEvenement find(int id) {
        
        String sql = this.getSQL( id );
        
        TypeEvenement typeEvenement = new TypeEvenement();
        
        typeEvenement.exchange( this.row( sql ) );
        
        return typeEvenement;
    }

    @Override
    public TypeEvenement create(TypeEvenement obj) {
        
        try {
            
            String sql = this.addSQL();

            PreparedStatement prepStmt = this.connect.prepareStatement( sql );

            // Values===START
            
            prepStmt.setString( 1 , obj.getNom() );

            // Values===END
            
            prepStmt.execute(); prepStmt.close(); return obj;

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return null;
    }

    @Override
    public TypeEvenement update(TypeEvenement obj) {
        
        try {
            
            String sql = this.setSQL( obj.getId() );
            
            PreparedStatement prepStmt = this.connect.prepareStatement( sql );
            
            // Values===START
            
            prepStmt.setString( 1 , obj.getNom() );
                        
            // Values===END
            
            prepStmt.execute(); prepStmt.close(); return obj;
        
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        
        return null;
    }

    @Override
    public void delete(TypeEvenement obj) {
        
        try {
            
            String sql = this.rmSQL( obj.getId() );
        
            Statement stmt = this.connect.createStatement();
            
            stmt.execute( sql );
            
            stmt.close();
        
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
    }
    
}
