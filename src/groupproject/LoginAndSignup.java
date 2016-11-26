/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author wislish
 */
public class LoginAndSignup {

    private static boolean isLoggedIn;
    private static User user = new User();
    private static Connection conn = null;

    static {
        conn = DBConnection.getConnectioin();
    }

    public static boolean isLoggedIn() {
        return isLoggedIn;
    }

    public static boolean login(String userName, String password) {
        //lookup user table, select user, compare passwod
        String passwordTemp = "";
        try {
            String sql = "select * from User where username == " + userName;
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                passwordTemp = rs.getString("password");
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            //print stack
        }
        //if password correct  set isLoggedIn true return true;
        if (passwordTemp.equals(password)) {
            isLoggedIn = true;
            return true;
        } //else set isLogged False return false; 
        else {
            isLoggedIn = false;
            return false;
        }
    }

    public static boolean signUp(String userName, String password, boolean isAdmin) {

        //set up user
        user.setUsername(userName);
        user.setPassword(password);
        user.setIsAdmin(isAdmin);

        //manipulate to the database
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement("INSERT INTO User (username,password,is_admin) VALUES (?,?,?)");
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setBoolean(3, user.isIsAdmin());
            pstmt.executeUpdate();
        } catch (Exception e) {
            return false;
        }

        //else reture false 
        return true;
    }
}
