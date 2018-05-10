/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.util.LinkedHashMap;

/**
 *
 * @author tiryboy
 */
public class Utilisateur {
    
    private int id;
    private String username;
    private String password;

    public Utilisateur() {
    }

    public Utilisateur(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Utilisateur(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
    
    public void exchange(LinkedHashMap <String, String> data) {
        this.id = ( data.containsKey( "id" ) ) ? Integer.parseInt( data.get( "id" ) ) : null;
        this.username = ( data.containsKey( "username" ) ) ? data.get( "username" ) : null;
        this.password = ( data.containsKey( "password" ) ) ? data.get( "password" ) : null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "id=" + id + ", username=" + username + ", password=" + password + '}';
    }
}
