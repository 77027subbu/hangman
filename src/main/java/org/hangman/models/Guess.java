package org.hangman.models;

/**
 * Created by subbu on 08/05/14.
 */
public class Guess {

    private String[] characters;
    private Boolean hasChosen;
    private Boolean gameUp;
    private String hangmanString;
    private int missedCount;
    private int score;

    public String[] getCharacters() {
        return characters;
    }

    public void setCharacters(String[] characters) {
        this.characters = characters;
    }

    public Boolean getHasChosen() {
        return hasChosen;
    }

    public void setHasChosen(Boolean hasChosen) {
        this.hasChosen = hasChosen;
    }

    public Boolean getGameUp() {
        return gameUp;
    }

    public void setGameUp(Boolean gameUp) {
        this.gameUp = gameUp;
    }

    public String getHangmanString() {
        return hangmanString;
    }

    public void setHangmanString(String hangmanString) {
        this.hangmanString = hangmanString;
    }

    public int getMissedCount() {
        return missedCount;
    }

    public void setMissedCount(int missedCount) {
        this.missedCount = missedCount;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
