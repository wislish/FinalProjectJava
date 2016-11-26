/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupproject;

import static groupproject.DBConnection.tableAlreadyExists;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wislish
 */
public class QuizTest {
    
    private Connection conn;
    private int numOfHard;
    private int numOfMedium;
    private int numOfEasy;
    private int numOfQues;

    private User user;
    private static final double passLine = 0.6;
    private static boolean isPassed;
    
    protected ArrayList<Quiz> quizzes = new ArrayList<>();
    protected HashMap<Integer, String> chosedAns= new HashMap();

    
    public void beginNewTest(int numOfH, int numOfM, int numOfE){
        
        initializePara(numOfH, numOfM, numOfE);
        loadQuiz();
        display();
        writeAns(1, "a");
        AnalyseResult();
        
    }
    //watch out the number of different quizzes
    public void initializePara(int numOfH, int numOfM, int numOfE){
        
        System.out.println("Please set the test option.");
        this.numOfHard = numOfH;
        this.numOfMedium = numOfM;
        this.numOfEasy = numOfE;
        this.numOfQues = numOfE + numOfH + numOfM;
        
        
    }
    
    public void loadQuiz(){
        
        quizzes = QuizRepo.createNewQuizzes(numOfEasy, numOfMedium, numOfHard);
    }
    
    public void display(){
        
        for (Quiz quiz : quizzes){
            if (quiz instanceof MCQuiz){
                MCQuiz mquiz = (MCQuiz)quiz;
                System.out.println("Type: "+mquiz.getType());
                System.out.println("Level: "+mquiz.getLevelOfDifficulty());
                System.out.println(mquiz.getDescription());
                System.out.println(mquiz.getChoice1());
                System.out.println(mquiz.getChoice2());
                System.out.println(mquiz.getChoice3());
                System.out.println(mquiz.getChoice4());
                System.out.println(mquiz.getAnswer());

            }else if (quiz instanceof MAQuiz){
                System.out.println("ma");
            }else if (quiz instanceof TFQuiz){
                System.out.println("tf");
            }else if (quiz instanceof FIBQuiz){
                System.out.println("fib");
            }
        }
    }
    
    public void writeAns(int loc, String ans){
        chosedAns.put(loc, ans);
    }
    
    public void AnalyseResult(){

        Result rs = new Result(quizzes, chosedAns, user);
//        score = ResultAnalysis.calScores(this);
//        isPassed = ((score / totalScore) >= passLine);
//        System.out.println("The score is " + score + " and passed: "+isPassed);
        
    }
    
    public void writeToTestTable(){
        
        String writeToTestTable = "INSERT INTO " + TestTB.NAME 
                + " (user)";
        try {
            Statement stmt  = conn.createStatement();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
  

    /**
     * @return the numOfHard
     */
    public int getNumOfHard() {
        return numOfHard;
    }

    /**
     * @param numOfHard the numOfHard to set
     */
    public void setNumOfHard(int numOfHard) {
        this.numOfHard = numOfHard;
    }

    /**
     * @return the numOfMedium
     */
    public int getNumOfMedium() {
        return numOfMedium;
    }

    /**
     * @param numOfMedium the numOfMedium to set
     */
    public void setNumOfMedium(int numOfMedium) {
        this.numOfMedium = numOfMedium;
    }

    /**
     * @return the numOfEasy
     */
    public int getNumOfEasy() {
        return numOfEasy;
    }

    /**
     * @param numOfEasy the numOfEasy to set
     */
    public void setNumOfEasy(int numOfEasy) {
        this.numOfEasy = numOfEasy;
    }
}
