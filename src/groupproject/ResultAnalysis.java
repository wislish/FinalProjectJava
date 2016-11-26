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
import java.util.HashMap;

/**
 *
 * @author wislish
 */
public class ResultAnalysis {
    
    protected static final int hardWeight = 3;
    protected static final int mediumWeight = 2;
    protected static final int easyWeight = 1;
    protected static Connection conn;
    
    public static int calScores(ArrayList<Quiz> quizzes, HashMap<Integer, String> chosedAns){
        
        int score = 0;
        for (int i=0;i<quizzes.size();i++){
            String studentAns = chosedAns.get(i);
            
            if (studentAns.toLowerCase().equals(quizzes.get(i).getAnswer().toLowerCase())){
                int weight =0 ;
                switch (quizzes.get(i).getLevelOfDifficulty()){
                    case "H":
                        weight = hardWeight;
                        break;
                    case "M":
                        weight = mediumWeight;
                        break;
                    case "E":
                        weight = easyWeight;
                        break;
                        
                }
                
                score += weight;
            }
        }
        return score;
    }
    
    public static double getTotalScore(ArrayList<Quiz> quizzes){
        
        double totalScore = 0;
        for(int i=0;i<quizzes.size();i++){
            int weight = 0;
            switch (quizzes.get(i).getLevelOfDifficulty()){
                    case "H":
                        weight = hardWeight;
                        break;
                    case "M":
                        weight = mediumWeight;
                        break;
                    case "E":
                        weight = easyWeight;
                        break;
                        
                }
            totalScore += weight;
        }

        return totalScore;
    }
    
    
}
