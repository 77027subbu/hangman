package org.hangman.services;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import org.apache.tapestry5.annotations.Log;
import org.hangman.models.Word;
import org.jongo.Jongo;
import org.jongo.MongoCollection;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by subbu on 09/05/14.
 */
public class MongoDBJongoHandler implements IDBHandler {

    private DB db;

    private Jongo jongo;

    public MongoDBJongoHandler() throws UnknownHostException, MongoException {
        //set up db connection
        connectToDatabase();
    }

    @Log
    private void connectToDatabase() throws UnknownHostException, MongoException {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        this.db = mongoClient.getDB("hangman");
        jongo = new Jongo(this.db);
    }

    @Log
    public List<Word> getAllWords() {
        List<Word> words = new ArrayList<Word>();
        MongoCollection _words = jongo.getCollection("words");
        return words;
    }

    @Log
    public Word getWord(int id) {
        Word word = null;
        MongoCollection words = jongo.getCollection("words");
        word = words.findOne("{id:" + id + "}").as(Word.class);
        return word;
    }
}
