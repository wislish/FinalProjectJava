/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupproject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author wislish
 */
public class QuizRepo {

    protected static String selectHardQuiz = "SELECT * FROM " + QuestionTB.NAME
            + " WHERE level = 'H'";
    protected static String selectMediumQuiz = "SELECT * FROM " + QuestionTB.NAME
            + " WHERE level = 'M'";
    protected static String selectEasyQuiz = "SELECT * FROM " + QuestionTB.NAME
            + " WHERE level = 'E'";

    protected static Connection conn = DBConnection.getConnectioin();

    private static ArrayList<Quiz> hardQuiz = new ArrayList<>();
    private static ArrayList<Quiz> mediumQuiz = new ArrayList<>();
    private static ArrayList<Quiz> eayQuiz = new ArrayList<>();

    protected static ArrayList<Quiz> quizzes = new ArrayList<>();

    
    
    public static void loadQuiz(){

        ResultSet rs = null;
        try {
            Statement stmt = conn.createStatement();

            rs = stmt.executeQuery(selectHardQuiz);
            while (rs.next()) {
                String type = rs.getString("type");
                Quiz quiz = formQuiz(type, rs);
                quiz.setLevelOfDifficulty("H");
                quiz.setQid(rs.getString("qid"));
                hardQuiz.add(quiz);
            }

            rs = stmt.executeQuery(selectMediumQuiz);
            while (rs.next()) {
                String type = rs.getString("type");
                Quiz quiz = formQuiz(type, rs);
                quiz.setLevelOfDifficulty("M");
                quiz.setQid(rs.getString("qid"));
                mediumQuiz.add(quiz);
                
            }

            rs = stmt.executeQuery(selectEasyQuiz);
            while (rs.next()) {
                String type = rs.getString("type");
                Quiz quiz = formQuiz(type, rs);
                quiz.setLevelOfDifficulty("E");
                quiz.setQid(rs.getString("qid"));
                eayQuiz.add(quiz);
            }

            stmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static Quiz formQuiz(String type, ResultSet rs){
        
        Quiz quiz = null;
        
        try{
            switch (type){
            case "MC":
                MCQuiz mquiz = new MCQuiz();
                mquiz.setType("MC");
                mquiz.setDescription(rs.getString("description"));
                mquiz.setChoice1(rs.getString("choice1"));
                mquiz.setChoice2(rs.getString("choice2"));
                mquiz.setChoice3(rs.getString("choice3"));
                mquiz.setChoice4(rs.getString("choice4"));
                mquiz.setAnswer(rs.getString("answer"));
                return mquiz;
                
            case "MA":
                MAQuiz aquiz = new MAQuiz();
                aquiz.setType("MA");
                aquiz.setDescription(rs.getString("description"));
                aquiz.setChoice1(rs.getString("choice1"));
                aquiz.setChoice2(rs.getString("choice2"));
                aquiz.setChoice3(rs.getString("choice3"));
                aquiz.setChoice4(rs.getString("choice4"));
                //store all the answers
                aquiz.setAnswer(rs.getString("answer"));
                return aquiz;
                
            case "TF":
                TFQuiz tfquiz = new TFQuiz();
                tfquiz.setType("TF");
                tfquiz.setDescription(rs.getString("description"));
                tfquiz.setAnswer(rs.getString("answer"));
                return tfquiz;
                
            case "FIB":
                FIBQuiz fib = new FIBQuiz();
                fib.setDescription(rs.getString("description"));
                fib.setType("FIB");
                fib.setAnswer(rs.getString("answer"));
                return fib;

            }
        
        } catch (Exception e){
            e.printStackTrace();
        }
        
        return quiz;
    }
    
    public static ArrayList<Quiz> createNewQuizzes(int numOfEasy, int numOfMedium, int numOfHard){
        
        Collections.shuffle(hardQuiz);
        Collections.shuffle(mediumQuiz);
        Collections.shuffle(eayQuiz);
        
        quizzes.addAll(eayQuiz.subList(0, numOfEasy));
        quizzes.addAll(mediumQuiz.subList(0, numOfMedium));
        quizzes.addAll(hardQuiz.subList(0, numOfHard));
        
        return quizzes;
    }

}
