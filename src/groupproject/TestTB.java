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
public class TestTB extends DBTable{
        
    protected static final String NAME = "Test";
    protected Connection conn;
    
    public void setPara(){
        
        
        String createTestTable = "create table " + NAME
                + " (testId int not null GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
                + "userId int not null, "
                + "date TIMESTAMP not null, "
                + "score int not null, numOfQues int not null, "
                + "isPass varchar(5), PRIMARY KEY (testId))"; 
        
        setCreate(createTestTable);
        
        String drop = "drop table " + NAME;
        setDrop(drop);

        conn = DBConnection.getConnectioin();
        
        
    }
    
}
