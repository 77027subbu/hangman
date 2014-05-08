package org.hangman.pages;

import org.apache.commons.lang.CharUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.tapestry5.EventConstants;
import org.apache.tapestry5.annotations.Log;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionAttribute;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hangman.models.Word;
import org.hangman.services.IDBHandler;
import org.slf4j.Logger;

import java.util.Random;

/**
 * Created by subbu on 06/05/14.
 */
public class Index {

    private final Random random = new Random(System.nanoTime());
    @Inject
    private Logger logger;
    @Property
    private String _chosenChar;
    @SessionAttribute("characters")
    @Property
    private String[] characters;
    @SessionAttribute("hasChosen")
    @Property
    private Boolean hasChosen;
    @SessionAttribute("gameUp")
    @Property
    private Boolean gameUp;
    @SessionAttribute("hangmanString")
    @Property
    private String hangmanString;
    @SessionAttribute("missedCount")
    @Property
    private int missedCount;
    @SessionAttribute("score")
    @Property
    private int score;
    @Inject
    private IDBHandler mongoDB;

    @Log
    @OnEvent(value = EventConstants.ACTIVATE)
    void thisPageBeenRequested() {
        if (characters == null) {
            int target = random.nextInt(3) + 1;
            Word word = mongoDB.getWord(target);
            hangmanString = word.getWord();
            logger.info("words - " + word);
            characters = new String[hangmanString.length()];
            missedCount = 0;
            score = 0;
            gameUp = Boolean.FALSE;
        }
    }

    @Log
    @OnEvent(value = "letterClicked")
    void add(String _char) {
        hasChosen = Boolean.TRUE;
        if (isPresent(_char)) {
            int[] loc = atLocation(_char);
            for (int i = 0; i < loc.length; i++) {
                logger.info("atLocation - " + loc[i]);
                characters[loc[i]] = _char.toLowerCase();
            }
        } else {
            missedCount += 1;
        }
        logger.info("Missed count - " + missedCount + " - guessed string - " + StringUtils.join(characters));
        if (missedCount == 10 || StringUtils.join(characters).equalsIgnoreCase(hangmanString)) {
            if (StringUtils.join(characters).equalsIgnoreCase(hangmanString)) {
                for (int i = 0; i < characters.length; i++) {
                    score += getScore(characters[i]);
                }
                logger.info("Your score - " + score);
            }
            logger.info("Game up");
            gameUp = Boolean.TRUE;
        }
    }

    @Log
    @OnEvent(value = "startOver")
    void startOver() {
        characters = null;
        gameUp = Boolean.FALSE;
        hasChosen = Boolean.FALSE;
        missedCount = 0;
        score = 0;
    }

    private boolean isPresent(String _char) {
        return (hangmanString.contains(_char));
    }

    @Log
    private int[] atLocation(String _char) {
        int[] result = new int[StringUtils.countMatches(hangmanString, _char)];
        logger.info("Found number of times - " + StringUtils.countMatches(hangmanString, _char));
        if (StringUtils.countMatches(hangmanString, _char) == 1) {
            result[0] = (hangmanString.indexOf(_char));
        } else {
            for (int i = 0, j = 0; i < hangmanString.length(); i++) {
                logger.info("Character being compared - " + hangmanString.charAt(i) + " - against - " + _char);
                if (String.valueOf(hangmanString.charAt(i)).equalsIgnoreCase(_char)) {
                    logger.info("Found char - " + _char + " - at - " + i);
                    result[j] = i;
                    j++;
                }
            }
        }
        return result;
    }

    @Log
    private int getScore(String _char) {
        int _score = 0;
        switch (CharUtils.toChar(_char.toUpperCase())) {
            case 'A':
                _score = 1;
                break;
            case 'B':
                _score = 3;
                break;
            case 'C':
                _score = 3;
                break;
            case 'D':
                _score = 2;
                break;
            case 'E':
                _score = 1;
                break;
            case 'F':
                _score = 4;
                break;
            case 'G':
                _score = 1;
                break;
            case 'H':
                _score = 4;
                break;
            case 'I':
                _score = 1;
                break;
            case 'J':
                _score = 8;
                break;
            case 'K':
                _score = 5;
                break;
            case 'L':
                _score = 1;
                break;
            case 'M':
                _score = 3;
                break;
            case 'N':
                _score = 1;
                break;
            case 'O':
                _score = 1;
                break;
            case 'P':
                _score = 3;
                break;
            case 'Q':
                _score = 10;
                break;
            case 'R':
                _score = 1;
                break;
            case 'S':
                _score = 1;
                break;
            case 'T':
                _score = 1;
                break;
            case 'U':
                _score = 1;
                break;
            case 'V':
                _score = 4;
                break;
            case 'W':
                _score = 4;
                break;
            case 'X':
                _score = 8;
                break;
            case 'Y':
                _score = 4;
                break;
            case 'Z':
                _score = 10;
                break;
        }
        return _score;
    }
}