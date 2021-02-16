package javaCode.Controllers;

import javaCode.Main;
import javaCode.Model.GamePhrase;
import javaCode.Model.Phrase;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

//  Controller for the game screen (playing the game)
public class GameController implements Initializable {

    public ImageView imgBase;
    public ImageView imgHead;
    public ImageView imgBody;
    public ImageView imgArm1;
    public ImageView imgArm2;
    public ImageView imgLeg1;
    public ImageView imgLeg2;
    //  This is the string with the spaces put in between characters and trimmed
    private String convertedString;

    //  The original string that is passed in from the phrase object
    private String originalString;

    //  This is an array that holds the converted string
    private char[] outputArray;
    private StringBuilder builder;

    //  Difficulty passed from previous screen
    private static String difficulty;


    //  Guesses remaining should be dependent on the difficulty
    //  Easy - up to 7
    //  Medium - 8-12
    //  Hard - 12 +
    //  Guesses..
    //  Easy - 6
    //  Medium - 4
    //  Hard - 4
    public Integer guessesRemaining = 6;


    //  Guesses remaining shown on screen
    public Text outputGuesses;
    //  This is what is shown on screen
    public Text outputPhrase;
    public Text outputCategory;

    public Button btnBackToMain;
    public Button btnExit;

    public Button btnKeyA = new Button("A");
    public Button btnKeyB = new Button("B");
    public Button btnKeyC = new Button("C");
    public Button btnKeyD = new Button("D");
    public Button btnKeyE = new Button("E");
    public Button btnKeyF = new Button("F");
    public Button btnKeyG = new Button("G");
    public Button btnKeyH = new Button("H");
    public Button btnKeyI = new Button("I");
    public Button btnKeyJ = new Button("J");
    public Button btnKeyK = new Button("K");
    public Button btnKeyL = new Button("L");
    public Button btnKeyM = new Button("M");
    public Button btnKeyN = new Button("N");
    public Button btnKeyO = new Button("O");
    public Button btnKeyP = new Button("P");
    public Button btnKeyQ = new Button("Q");
    public Button btnKeyR = new Button("R");
    public Button btnKeyS = new Button("S");
    public Button btnKeyT = new Button("T");
    public Button btnKeyU = new Button("U");
    public Button btnKeyV = new Button("V");
    public Button btnKeyW = new Button("W");
    public Button btnKeyX = new Button("X");
    public Button btnKeyY = new Button("Y");
    public Button btnKeyZ = new Button("Z");

    //  This transfers the difficulty selected to this page
    public static void transferDifficultyChosen(SingleSelectionModel<String> selectionModel) {
        difficulty = selectionModel.getSelectedItem();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //  Make hangman parts invisible
        imgHead.setVisible(false);
        imgBody.setVisible(false);
        imgArm1.setVisible(false);
        imgArm2.setVisible(false);
        imgLeg1.setVisible(false);
        imgLeg2.setVisible(false);

        btnBackToMain.setOnAction((e) -> {
            try {
                returnToMenu(e, false);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        if ("Easy".equals(difficulty)) {
            guessesRemaining = 6;
        } else {
            guessesRemaining = 4;
        }

        Phrase phrase = GamePhrase.searchForGamePhrase(difficulty);

        outputGuesses.setText(guessesRemaining.toString());

        originalString = phrase.word;
        convertedString = phrase.word.replace("", " ").trim();

        //  Get length and build output array
        getPhraseCharacteristics(convertedString);

        outputCategory.setText(phrase.category);
        outputPhrase.setText(builder.toString());
    }

    //  Convert the string for correct output to be displayed
    public void getPhraseCharacteristics(String phrase) {

        outputArray = new char[phrase.length()];
        builder = new StringBuilder();

        outputArray = phrase.toCharArray();

        //  For each char that isn't a ' ' add a _
        for (int i = 0; i < phrase.length(); i++) {
            if (outputArray[i] != ' ') {
                outputArray[i] = '_';
            }
        }

        //  To build the string for the output
        for (char c : outputArray) {
            builder.append(c);
        }
    }

    //   This takes the button pressed and compares the letter to the array.
    //  If the letter is correct it hides the letter and adds to the solution phrase
    //  If the letter is incorrect it still hides the letter but it adds a wrong guess to guesses remaining
    public void btnPressed(ActionEvent actionEvent) {
        //  Check for correct letter
        String buttonPressed = ((Button) actionEvent.getSource()).getText();

        ((Button) actionEvent.getSource()).setVisible(false);


        //  If the buttonPressed letter is in the string replace it
        if (contains(convertedString, buttonPressed.charAt(0))) {
            updateOutput(buttonPressed.charAt(0), convertedString);

        } else {
            //  Otherwise remove a guess
            if (guessesRemaining > 1) {
                guessesRemaining--;
                outputGuesses.setText(guessesRemaining.toString());
                drawHangman(guessesRemaining, difficulty);

            } else {
                guessesRemaining--;
                outputGuesses.setText(guessesRemaining.toString());
                drawHangman(guessesRemaining, difficulty);

                showPopUpWindow("No more guesses...");
            }
        }


    }

    //  This function draws the picture correctly
    public void drawHangman(Integer guesses, String diff){
        //  So if the difficulty is easy we have 6 guesses which in turn means drawing 6 body parts
        if (diff.equals("Easy")){
            switch (guesses){
                case 5:
                    imgHead.setVisible(true);
                    break;
                case 4:
                    imgBody.setVisible(true);
                    break;
                case 3:
                    imgArm1.setVisible(true);
                    break;
                case 2:
                    imgArm2.setVisible(true);
                    break;
                case 1:
                    imgLeg1.setVisible(true);
                    break;
                case 0:
                    imgLeg2.setVisible(true);
                    break;
            }
        }else{
            switch (guesses){
                case 3:
                    imgHead.setVisible(true);
                    break;
                case 2:
                    imgBody.setVisible(true);
                    break;
                case 1:
                    imgArm1.setVisible(true);
                    imgArm2.setVisible(true);
                    break;
                case 0:
                    imgLeg1.setVisible(true);
                    imgLeg2.setVisible(true);
                    break;
            }
        }
        //  Otherwise we only have 4 guesses which means we lump together arms and legs

    }

    //  Check for char in string
    public boolean contains(String str, char chr) {
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) == chr)
                return true;
        return false;
    }

    //  Update the output string when correct character is guessed
    public void updateOutput(char c, String phrase) {

        char[] compareOutputArray;

        builder = new StringBuilder();

        //  This array holds the original converted phrase {A, , P, , P, , L, , E}
        compareOutputArray = phrase.toCharArray();

        //  So we go through the length of the convertedString and use the compareOutputToOld array to see if the
        //  letter is in the string. if it is we replace and update the output array
        for (int i = 0; i < phrase.length(); i++) {
            if (compareOutputArray[i] == c) {
                outputArray[i] = c;
            }
        }

        //  To build the string for the output
        for (char ch : outputArray) {
            builder.append(ch);
        }

        outputPhrase.setText(builder.toString());
        checkForWin(Arrays.toString(outputArray), Arrays.toString(compareOutputArray));

    }

    //  Checks for a win depending on if the entered string from the game output is the same as the string provided
    public void checkForWin(String enteredString, String checkerString) {
        if (enteredString.equals(checkerString)) {
            //  Game won
            //  Show modal and return to main screen
            showPopUpWindow("Well done");
        }


    }

    //  Show modal popup window
    private void showPopUpWindow(String messageToUser) {
        //  Call the no guesses remaining function
        Stage popupWindow = new Stage();
        popupWindow.initModality(Modality.APPLICATION_MODAL);
        popupWindow.centerOnScreen();
        Label label1 = new Label(messageToUser);

        Label label2 = new Label("Phrase was: " + originalString);


        Button button1 = new Button("Return to main menu");

        button1.setOnAction(e -> {
            try {
                returnToMenu(e, true);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        VBox layout = new VBox(10);

        layout.getChildren().addAll(label1, label2, button1);

        layout.setAlignment(Pos.CENTER);

        Scene scene1 = new Scene(layout, 300, 250);
        layout.setStyle("-fx-background-color: #79C3CB;");
        popupWindow.setScene(scene1);

        popupWindow.showAndWait();
    }




    //  This button returns to main menu
    public void returnToMenu(ActionEvent actionEvent, Boolean modal) throws IOException {
        //  Keep in mind the correct fxml file path
        Parent titleViewParent = FXMLLoader.load(getClass().getResource("/title.fxml"));
        Scene titleViewScene = new Scene(titleViewParent);

        //  Get primary stage to go back to
        Stage mainStage = Main.getPrimaryStage();

        System.out.println(actionEvent.getClass());

        if (modal) {
            Stage modalStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

            //  Close the modal
            modalStage.close();
        }


        //  Navigate back to the primary stage
        mainStage.setScene(titleViewScene);
        mainStage.show();
    }


    //  This button exits the game
    public void exitGame(ActionEvent actionEvent) {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }
}
