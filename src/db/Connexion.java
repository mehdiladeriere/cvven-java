/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Micka
 */
public class Connexion {
    
    private static String url = "jdbc:postgresql://chamilo.rene-descartes.fr/mehdijava";
    private static String user = "groupe2f";
    private static String passwd = "mdp2f2017";
    
        /* Objet unique de connexion */
        private static Connection connect;
        
        /* Methode de connexion à la base de données */ 
        public static Connection getInstance() {
            
            if ( connect == null ) {
                
                try {
                    
                    connect = DriverManager.getConnection(url, user, passwd);
                    
                } catch ( SQLException e ) {
                    
                    System.out.println( "SQL erreur : " + e.getMessage() );
                    e.printStackTrace();
                }
            }
            
            return connect;
        }
}
