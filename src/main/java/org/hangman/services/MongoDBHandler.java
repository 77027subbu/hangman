package org.hangman.services;

import com.mongodb.*;
import org.apache.tapestry5.annotations.Log;
import org.hangman.models.Word;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by subbu on 08/05/14.
 */
public class MongoDBHandler implements IMongoDBHandler {
    private DB db;

    public MongoDBHandler() throws UnknownHostException, MongoException {
        //set up db connection
        connectToDatabase();
    }

    @Log
    private void connectToDatabase() throws UnknownHostException, MongoException {
        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
        this.db = mongoClient.getDB("hangman");
    }

    @Log
    public List<Word> getAllWords() {
        List<Word> words = new ArrayList<Word>();
        DBCollection dbCollection = db.getCollection("words");
        dbCollection.setObjectClass(Word.class);
        DBCursor dbCursor = dbCollection.find();
        while(dbCursor.hasNext()) {
            Word word = (Word) dbCursor.next();
            words.add(word);
        }
        return words;
    }

    @Log
    public Word getWord(int id){
        Word word = null;
        DBCollection dbCollection = db.getCollection("words");
        dbCollection.setObjectClass(Word.class);
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("id", Integer.valueOf(id));
        word = (Word)dbCollection.findOne(whereQuery);
        return word;
    }
}
