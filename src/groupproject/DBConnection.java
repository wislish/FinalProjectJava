/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupproject;

import com.opencsv.CSVReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.derby.jdbc.EmbeddedDriver;

/**
 *
 * @author wislish
 */
public class DBConnection {
    
    private static final String quizFilePath = "quiz";
    
    private static QuestionTB questionTable = new QuestionTB();
    private static OneQuizTB oneQuizTable = new OneQuizTB();
    private static UserTB userTable = new UserTB();
    private static TestTB testTable = new TestTB();

    private static Connection conn;
    /**
     * 
     * @return the connection to the Derby Database
     */
    public static void connect(){
                
        try {
            Driver derbyEmbeddedDriver = new EmbeddedDriver();
            DriverManager.registerDriver(derbyEmbeddedDriver);
            //Get a connection
            conn = DriverManager.getConnection("jdbc:derby:QuizSys;create=true");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public static Connection getConnectioin(){
        Connection newConn = null;
         try {
            Driver derbyEmbeddedDriver = new EmbeddedDriver();
            DriverManager.registerDriver(derbyEmbeddedDriver);
            //Get a connection
            newConn = DriverManager.getConnection("jdbc:derby:QuizSys;create=true");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
         return newConn;
    }

    /**
     * Create the table needed for the whole Quiz Management System
     */
    public static void initializeDB(){
        
        questionTable.setPara();
        oneQuizTable.setPara();
        testTable.setPara();
        userTable.setPara();
        
        String createQuestion = questionTable.getCreate();
        
        String createOneQuiz = oneQuizTable.getCreate();
        
        String createUserTable = userTable.getCreate();
        
        String createTestTable = testTable.getCreate();
        
        String dropQuestion = questionTable.getDrop();
        String dropOneQuiz = oneQuizTable.getDrop();
        String dropUser = userTable.getDrop();
        String dropTest = testTable.getDrop();


        try {
            Statement stmt  = conn.createStatement();
            stmt.executeUpdate(dropQuestion);
            stmt.executeUpdate(dropOneQuiz);
            stmt.executeUpdate(dropUser);
            stmt.executeUpdate(dropTest);

            stmt.executeUpdate(createQuestion);
            stmt.executeUpdate(createOneQuiz);
            stmt.executeUpdate(createUserTable);
            stmt.executeUpdate(createTestTable);

            stmt.close();
        } catch (SQLException ex) {
            //see if the table exists
            if(tableAlreadyExists(ex)){
                return;
            }else{
                ex.printStackTrace();
            }
        }
        
        loadCSVToDB();
    }
    
    public static boolean tableAlreadyExists(SQLException e) {
        boolean exists;
        if(e.getSQLState().equals("X0Y32")) {
            exists = true;
        } else {
            exists = false;
        }
        return exists;
    }
    
    public static void loadCSVToDB(){
        
        loadCSVToDB(quizFilePath);
    }
    /**
     * 
     * @param csvpath read the csv file and load it into the DB
     */
    public static void loadCSVToDB(String csvpath){
        
        CSVReader reader =null;
        PreparedStatement pstmt;

        try {
            
            reader = new CSVReader(new FileReader(csvpath));
            String[] line = null;
            ResultSet resultSet;            
            //read each line and insert into the Derby
            while ((line = reader.readNext()) != null) {
                
                questionTable.insert(line);
                
            }
            //test: whthter the data has been successfully loaded in !
            Statement stmt  = conn.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT * FROM "+questionTable);
//            
//            while (rs.next()) {
//                
//                System.out.println(rs.getString("description"));
//              
//            }
//            stmt.close();

        } catch (IOException e) {
            e.printStackTrace();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
       
            try {
                reader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    }

}
