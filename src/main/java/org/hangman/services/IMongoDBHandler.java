package org.hangman.services;

import org.hangman.models.Word;

import java.util.List;

/**
 * Created by subbu on 08/05/14.
 */
public interface IMongoDBHandler {

    public List<Word> getAllWords();

    public Word getWord(int id);
}
