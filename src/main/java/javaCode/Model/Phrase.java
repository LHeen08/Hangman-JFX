package javaCode.Model;

public class Phrase {

    public String word;
    public String category;
    String difficulty;

    public Phrase(String difficulty, String category, String word) {
        this.word = word;
        this.category = category;
        this.difficulty = difficulty;
    }

}
