package org.hangman.models;

import com.mongodb.BasicDBObject;

import java.io.Serializable;

/**
 * Created by subbu on 08/05/14.
 */
public class Word extends BasicDBObject implements Serializable{

    private Integer id;
    private String word;
    private String hint1;
    private String hint2;
    private String hint3;

    public Integer getId() {
        return (Integer) get("id");
    }

    public void setId(Integer id) {
        put("id",id);
        this.id = id;
    }

    public String getWord() {
        return (String) get("word");
    }

    public void setWord(String word) {
        put("word",word);
        this.word = word;
    }

    public String getHint1() {
        return (String) get("hint1");
    }

    public void setHint1(String hint1) {
        put("hint1",hint1);
        this.hint1 = hint1;
    }

    public String getHint2() {
        return (String) get("hint2");
    }

    public void setHint2(String hint2) {
        put("hint2",hint2);
        this.hint2 = hint2;
    }

    public String getHint3() {
        return (String) get("hint3");
    }

    public void setHint3(String hint3) {
        put("hint3",hint3);
        this.hint3 = hint3;
    }
}
