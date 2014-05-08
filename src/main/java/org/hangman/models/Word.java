package org.hangman.models;

import com.mongodb.BasicDBObject;

import java.io.Serializable;

/**
 * Created by subbu on 08/05/14.
 */
public class Word extends BasicDBObject implements Serializable{

    private Integer id;
    private String word;
    private Hint[] hints;

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

    public Hint[] getHints() {
        return (Hint[]) get("hints");
    }

    public void setHints(Hint[] hints) {
        put("hints", hints);
        this.hints = hints;
    }
}
