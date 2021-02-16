package javaCode.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

//  Title screen controller
public class TitleController implements Initializable {


    public Button btnPlayGame;
    public Button btnExit;

    public ComboBox<String> cmbDifficulty;
    public Label errorMessage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cmbDifficulty.setPromptText("Difficulty...");

        errorMessage.setVisible(false);

        //  List of the difficulties
        List<String> difficultyList = new ArrayList<>();
        difficultyList.add("Easy");
        difficultyList.add("Medium");
        difficultyList.add("Hard");
        ObservableList<String> observableList = FXCollections.observableList(difficultyList);
        cmbDifficulty.getItems().clear();
        cmbDifficulty.setItems(observableList);
    }

    // This button starts the game
    public void playTheGame(ActionEvent actionEvent) throws IOException {

        //  If difficulty is not selected prompt user to select difficulty
        if (cmbDifficulty.getSelectionModel().isEmpty()){
            // Show error
            errorMessage.setVisible(true);
        }else {
            GameController.transferDifficultyChosen(cmbDifficulty.getSelectionModel());

            Parent gameViewParent = FXMLLoader.load(getClass().getResource("/game.fxml"));
            Scene gameViewScene = new Scene(gameViewParent);

            // Get the Stage
            Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            stage.setScene(gameViewScene);
            stage.show();
        }


    }

    //  This button exits the game
    public void exitGame(ActionEvent actionEvent) {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }


}
