package org.hangman.models;

import com.mongodb.BasicDBObject;

import java.io.Serializable;

/**
 * Created by subbu on 08/05/14.
 */
public class Hint extends BasicDBObject implements Serializable {

    private Integer id;
    private String hint;

    public Integer getId() {
        return (Integer) get("id");
    }

    public void setId(Integer id) {
        put("id", id);
        this.id = id;
    }

    public String getHint() {
        return (String) get("hint");
    }

    public void setHint(String hint) {
        put("hint", hint);
        this.hint = hint;
    }
}
