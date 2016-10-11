package gr.uom.theater.application.controllers;

import gr.uom.theater.resources.Data;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminLoginScreenController {

    @FXML
    private Button btnLogin, btnBack;

    @FXML
    private void initialize() {
        btnBack.setOnAction(event -> {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/gr/uom/theater/gui/WelcomeScreen.fxml"));

                Stage primaryStage = (Stage) ((Button) event.getSource()).getScene().getWindow();

                Scene scene = new Scene(root, Data.SMALL_SCREEN_WIDTH, Data.SMALL_SCREEN_HEIGHT);
                scene.getStylesheets().add(this.getClass().getResource("/gr/uom/theater/resources/css/Style.css").toExternalForm());

                primaryStage.centerOnScreen();
                primaryStage.setResizable(false);
                primaryStage.hide();
                primaryStage.setTitle("Σύνδεση ως");
                primaryStage.setScene(scene);
                primaryStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        btnLogin.setOnAction(event -> {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/gr/uom/theater/gui/AdminMainScreen.fxml"));

                Stage primaryStage = (Stage) ((Button) event.getSource()).getScene().getWindow();

                Scene scene = new Scene(root, Data.MAIN_SCREEN_WIDTH, Data.MAIN_SCREEN_HEIGHT);
                scene.getStylesheets().add(this.getClass().getResource("/gr/uom/theater/resources/css/Style.css").toExternalForm());

                primaryStage.centerOnScreen();
                primaryStage.setResizable(false);
                primaryStage.hide();
                primaryStage.setTitle("Πίνακας Διαχείρισης");
                primaryStage.setScene(scene);
                primaryStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
