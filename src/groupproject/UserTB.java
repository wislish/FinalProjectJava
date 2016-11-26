/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupproject;

import java.sql.Connection;

/**
 *
 * @author wislish
 */
public class UserTB extends DBTable{
        
    protected static final String NAME = "Question";
    protected Connection conn;
        
    public void setPara(){
                
        
        String createUserTable = "create table " + NAME
                + " (userId int not null GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
                + "username varchar(35) not null, "
                + "password varchar(35) not null, "
                + "isAdmin varchar(5), PRIMARY KEY (userId))";
        
        setCreate(createUserTable);
        
        
    }
    
}
