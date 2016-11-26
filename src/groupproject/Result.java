/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupproject;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author wislish
 */
public class Result {
    
    protected User user;
    protected ArrayList<Quiz> quizzes = new ArrayList<>();
    protected HashMap<Integer, String> chosedAns= new HashMap(); 
    protected Date date;
    protected int score;
    protected double totalbScore;
    
    public Result(ArrayList<Quiz> quizzes, HashMap<Integer, String> chosedAns, User user){
        this.user = user;
        this.quizzes = quizzes;
        this.chosedAns = chosedAns;
        
        
    }
    
    public void calScore(){
        score = ResultAnalysis.calScores(quizzes, chosedAns);
        totalbScore = ResultAnalysis.getTotalScore(quizzes);
    }
    
    
    
}
