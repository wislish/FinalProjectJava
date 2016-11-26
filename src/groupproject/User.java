/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupproject;

/**
 *
 * @author wislish
 */
public class User {
    
//    private static enum UserType { 
//        STUDENT,
//        TEACHER,
//        ADMIN 
//    }
    private String userid;
    private String username;
    private String password;
    private boolean isAdmin;
    
    /**
     * @return the userid
     */
    public String getUserid() {
        return userid;
    }

    /**
     * @param userid the userid to set
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the isadmin
     */
    public boolean isIsAdmin() {
        return isAdmin;
    }

    /**
     * @param isadmin the isadmin to set
     */
    public void setIsAdmin(boolean isadmin) {
        this.isAdmin = isadmin;
    }
    

    
}
