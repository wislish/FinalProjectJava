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
public class OneQuizTB extends DBTable{

    
    protected static final String NAME = "OneQuiz";
    protected Connection conn;


    public void setPara(){
        
        
        String createOneQuiz = "create table " + NAME
                + " (uid int not null GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
                + "userId int not null, "
                + "qid int not null, "
                + "testId int not null, "
                + "isCorrect varchar(5), PRIMARY KEY (uid))";
        
        setCreate(createOneQuiz);
        String drop = "drop table " + NAME;
        setDrop(drop);

        conn = DBConnection.getConnectioin();
        
    }
    
}
