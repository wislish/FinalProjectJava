/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupproject;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author wislish
 */
public class QuestionTB extends DBTable{

    protected Quiz quiz;
    protected PreparedStatement pstmt;
    protected Connection conn;
    private static final int indexOfChoiceOne = 3;
    private static final int indexOfLastChoice = 9;
    protected static final String NAME = "Question";


    public void setPara() {

        String createQuestion = "create table " + NAME
                + " (qid int not null GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
                + "description varchar(400) not null, choice1 varchar(200),"
                + " choice2 varchar(200), choice3 varchar(200),"
                + " choice4 varchar(200), answer varchar(50), level char(1),"
                + " type varchar(3), PRIMARY KEY (qid))";

        setCreate(createQuestion);
        
        String drop = "drop table " + NAME;
        setDrop(drop);

        conn = DBConnection.getConnectioin();
    }
    

    public void insert(String[] line) {

        String type = line[0];

        insert(line, type);

    }

    public void insert(String[] line, String type) {

        switch (type) {
            case "MC":
                insertMC(line);
                break;
            case "MA":
                insertMA(line);
                break;
            case "FIB":
                insertFIB(line);
                break;
            case "TF":
                insertTF(line);
                break;
            default:
                System.out.println("Wrong Format! IGNORE!");
        }

    }
/**
 * the line format is 'MC,E,"DESCRIPTION",choice1,ans1,choice2,ans2,choice3,ans3,choice4,ans4'
 * @param line 
 */
    public void insertMC(String[] line) {

        try {
            MCQuiz quiz = new MCQuiz();
            quiz.setType("MC");
            quiz.setLevelOfDifficulty(line[1]);
            quiz.setDescription(line[2]);
            quiz.setChoice1(line[3]);
            quiz.setChoice2(line[5]);
            quiz.setChoice3(line[7]);
            quiz.setChoice4(line[9]);
            boolean findAnswer = false;
            
            for (int i = indexOfChoiceOne; i < indexOfLastChoice+2; i += 2) {
                if (line[i+1].equals("correct")) {
                    Character ans = line[i].trim().charAt(0);
                    quiz.setAnswer(ans.toString().toLowerCase());
                    findAnswer = true;
                    break;
                }
            }
            
            if (!findAnswer) {
                quiz.setAnswer("a");
            }
            
            pstmt = conn.prepareStatement("INSERT INTO " + NAME
                    + " (description,choice1,choice2,choice3,choice4,answer,level,type) VALUES (?,?,?,?,?,?,?,?)");
            pstmt.setString(1, quiz.getDescription());
            pstmt.setString(2, quiz.getChoice1());
            pstmt.setString(3, quiz.getChoice2());
            pstmt.setString(4, quiz.getChoice3());
            pstmt.setString(5, quiz.getChoice4());
            pstmt.setString(6, quiz.getAnswer());
            pstmt.setString(7, quiz.getLevelOfDifficulty());
            pstmt.setString(8, quiz.getType());
            pstmt.executeUpdate();

        } catch (Exception e) {
            System.out.println(line);
            System.out.println("!!!!!!Import format error.Ignore this one!!!!!!!!");
            e.printStackTrace();
        }
    }
    
    public void insertMA(String[] line){
        
        try {
            MAQuiz quiz = new MAQuiz();
            quiz.setType("MA");
            quiz.setLevelOfDifficulty(line[1]);
            quiz.setDescription(line[2]);
            quiz.setChoice1(line[3]);
            quiz.setChoice2(line[5]);
            quiz.setChoice3(line[7]);
            quiz.setChoice4(line[9]);
            boolean findAnswer = false;
            StringBuilder answer = new StringBuilder();
            for (int i = indexOfChoiceOne; i < indexOfLastChoice+2; i += 2) {
                if (line[i+1].equals("correct")) {
                    Character ans = line[i].trim().charAt(0);
                    answer.append(ans.toString().toLowerCase());
                    findAnswer = true;
                    break;
                }
            }
            quiz.setAnswer(answer.toString());
            
            if (!findAnswer) {
                quiz.setAnswer("a");
            }
            
            pstmt = conn.prepareStatement("INSERT INTO " + NAME
                    + " (description,choice1,choice2,choice3,choice4,answer,level,type) VALUES (?,?,?,?,?,?,?,?)");
            pstmt.setString(1, quiz.getDescription());
            pstmt.setString(2, quiz.getChoice1());
            pstmt.setString(3, quiz.getChoice2());
            pstmt.setString(4, quiz.getChoice3());
            pstmt.setString(5, quiz.getChoice4());
            pstmt.setString(6, quiz.getAnswer());
            pstmt.setString(7, quiz.getLevelOfDifficulty());
            pstmt.setString(8, quiz.getType());
            pstmt.executeUpdate();

        } catch (Exception e) {
            System.out.println(line);
            System.out.println("!!!!!!Import format error.Ignore this one!!!!!!!!");
            e.printStackTrace();
        }
    } 
    
    public void insertFIB(String[] line){
        
        try {
            FIBQuiz quiz = new FIBQuiz();
            quiz.setType("MA");
            quiz.setLevelOfDifficulty(line[1]);
            quiz.setDescription(line[2]);
            
            boolean findAnswer = false;
            StringBuilder answer = new StringBuilder();
            for (int i = indexOfChoiceOne; i < indexOfLastChoice+2; i += 2) {
                if (line[i+1].equals("correct")) {
                    Character ans = line[i].trim().charAt(0);
                    answer.append(ans.toString().toLowerCase());
                    findAnswer = true;
                    break;
                }
            }
            quiz.setAnswer(answer.toString());
            
            if (!findAnswer) {
                quiz.setAnswer("a");
            }
            
            pstmt = conn.prepareStatement("INSERT INTO " + NAME
                    + " (description,choice1,choice2,choice3,choice4,answer,level,type) VALUES (?,?,?,?,?,?,?,?)");
            pstmt.setString(1, quiz.getDescription());
            pstmt.setString(6, quiz.getAnswer());
            pstmt.setString(7, quiz.getLevelOfDifficulty());
            pstmt.setString(8, quiz.getType());
            pstmt.executeUpdate();

        } catch (Exception e) {
            System.out.println(line);
            System.out.println("!!!!!!Import format error.Ignore this one!!!!!!!!");
            e.printStackTrace();
        }
    } 
        
    public void insertTF(String[] line){
        
    } 
    
  

}
