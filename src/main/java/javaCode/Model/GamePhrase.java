package javaCode.Model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.*;

public class GamePhrase {

    //  This variable will hold all the phrases loaded from the object
    static ArrayList<Phrase> phraseList = new ArrayList<>();

    //  Parse the JSON file adding to the full phrases list
    public static void JSONFunc() throws Exception {
        //  Parse the JSON file
        Object object = new JSONParser().parse(new FileReader("src/main/java/javaCode/phrasesJSON/phrases.json"));

        //  Convert the object to a JSON array
        JSONArray jsonArray = (JSONArray) object;

        //  Traverse through the JSON array creating a list of phrases
        for (Object item : jsonArray){
            JSONObject itemObject = (JSONObject) item;
            Phrase phrase = new Phrase((String) itemObject.get("difficulty"),(String) itemObject.get("category"),(String) itemObject.get("word"));

            phraseList.add(phrase);
        }
    }

    //  This function searches the phrases list based on the difficulty
    public static Phrase searchForGamePhrase(String difficulty){
        //  Get a searchable list for example all the phrases with 'Easy'
        //  then get the size of the list
        //  pick a random index within the range of the size
        //  Use that randomly chosen word to output to the game
        ArrayList<Phrase> gameList = new ArrayList<>();

        for (Phrase phrase : phraseList) {
            if (phrase.difficulty.equals(difficulty)){
                gameList.add(phrase);
            }
        }

        int index = new Random().nextInt(gameList.size());

        return gameList.get(index);

    }

}
