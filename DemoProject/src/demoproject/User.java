/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoproject;

/**
 *
 * @author BEL
 */
public class User {
    private int eid;
    private String username;
    private String password;

    
    public User() {
    }

    public User(int eid, String username, String password) {
        this.eid = eid;
        this.username = username;
        this.password = password;
    }
    
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
