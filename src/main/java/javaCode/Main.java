package javaCode;

import javaCode.Model.GamePhrase;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private static Stage primaryStage;

    public static Stage getPrimaryStage(){
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage){
        Main.primaryStage= primaryStage;
    }


    @Override
    public void start(Stage primaryStage) throws Exception{
        setPrimaryStage(primaryStage);

        Parent root = FXMLLoader.load(getClass().getResource("/title.fxml"));
        primaryStage.setTitle("Hangman");
        primaryStage.setScene(new Scene(root, 1280, 800));
        primaryStage.show();
    }


    public static void main(String[] args) {
        //  Make a list from the JSON file
        try {
            GamePhrase.JSONFunc();
        } catch (Exception e) {
            e.printStackTrace();
        }
        launch(args);

    }
}
