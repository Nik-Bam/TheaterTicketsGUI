package gr.uom.theater.application.controllers;

import gr.uom.theater.resources.Data;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class WelcomeScreenController {

    @FXML
    private Button btnEnter;

    @FXML
    private ComboBox<String> cbConnectAs;

    @FXML
    private StackPane container;

    @FXML
    private void initialize() {
        cbConnectAs.getItems().addAll(Data.USERS);
        cbConnectAs.getSelectionModel().selectFirst();

        btnEnter.setOnAction(event -> {
            Parent root = null;
            String title = "";

            try {
                if (cbConnectAs.getSelectionModel().getSelectedItem().equals("Διαχειριστής")) {
                    root = FXMLLoader.load(getClass().getResource("/gr/uom/theater/gui/AdminLoginScreen.fxml"));
                    title = "Είσοδος Διαχειριστή";
                } else {
                    root = FXMLLoader.load(getClass().getResource("/gr/uom/theater/gui/ViewerLoginScreen.fxml"));
                    title = "Στοιχεία Κράτησης";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            Stage primaryStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, Data.SMALL_SCREEN_WIDTH, Data.SMALL_SCREEN_HEIGHT);
            scene.getStylesheets().add(this.getClass().getResource("/gr/uom/theater/resources/css/Style.css").toExternalForm());

            primaryStage.centerOnScreen();
            primaryStage.setResizable(false);
            primaryStage.hide();
            primaryStage.setTitle(title);
            primaryStage.setScene(scene);
            primaryStage.show();
        });
    }
}
