/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupproject;

/**
 *
 * @author wislish
 */
public abstract class Quiz {
    

    private String qid;
    private String description;
    private String levelOfDifficulty;
    private String type;
    private String answer;


    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the levelOfDifficulty
     */
    public String getLevelOfDifficulty() {
        return levelOfDifficulty;
    }

    /**
     * @param levelOfDifficulty the levelOfDifficulty to set
     */
    public void setLevelOfDifficulty(String levelOfDifficulty) {
        this.levelOfDifficulty = levelOfDifficulty;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the answer
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * @param answer the answer to set
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * @return the qid
     */
    public String getQid() {
        return qid;
    }

    /**
     * @param qid the qid to set
     */
    public void setQid(String qid) {
        this.qid = qid;
    }

}
