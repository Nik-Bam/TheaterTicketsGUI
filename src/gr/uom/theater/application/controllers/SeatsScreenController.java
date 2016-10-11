package gr.uom.theater.application.controllers;

import gr.uom.theater.resources.Data;
import gr.uom.theater.resources.Util;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class SeatsScreenController {

    private static final int GRID_ROWS = 10;
    private static final int GRID_COLS = 10;

    @FXML
    public GridPane seatsGrid;

    @FXML
    private TextField txtSeats;

    @FXML
    private Label lblPricePerSeat, lblTotalPrice;

    @FXML
    private Button btnBack, btnSubmit;

    private ArrayList<ToggleButton> seats;

    @FXML
    private void initialize() {
        seats = new ArrayList<>();
        populateSeats();

        txtSeats.setTooltip(Data.SEATS_TOOLTIP);
        txtSeats.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.equals("") || newValue.equals("0")) {
                txtSeats.clear();
                lblPricePerSeat.setText("-");
                lblTotalPrice.setText("-");
                btnSubmit.setDisable(true);
            } else {
                lblPricePerSeat.setText(String.valueOf(Data.selectedPerformance.getPricePerSeat()));
                lblTotalPrice.setText(String.valueOf(Data.selectedSeats * Data.selectedPerformance.getPricePerSeat()));
                btnSubmit.setDisable(false);
            }
        });
    }

    private void populateSeats() {
        for(int i = 0; i < GRID_ROWS; i++) {
            for(int j = 0; j < GRID_COLS; j++) {
                ToggleButton btn = new ToggleButton(Util.mapNumberToLetter(i) + j);
                btn.setPrefWidth(40);
                btn.setDisable(true);
                btn.getStyleClass().add("unavailable");
                seats.add(btn);
                seatsGrid.add(btn, j, i);
            }
        }
        Random rand = new Random();

        for(int i = 0; i < Data.selectedPerformance.getAvailableTickets(); i++) {
            ToggleButton seat;

            do {
                seat = seats.get(rand.nextInt(100));
            } while (!seat.isDisabled());

            seat.setDisable(false);
            seat.getStyleClass().clear();
            seat.getStyleClass().add("toggle-button");
            seat.selectedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue && Data.selectedSeats > 0) {
                    Data.selectedSeats--;
                    txtSeats.setText(String.valueOf(Data.selectedSeats));
                } else {
                    Data.selectedSeats++;
                    txtSeats.setText(String.valueOf(Data.selectedSeats));
                }
            });
        }
    }

    @FXML
    private void backAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/gr/uom/theater/gui/MainScreen.fxml"));

            Stage primaryStage = (Stage) ((Button) event.getSource()).getScene().getWindow();

            Scene scene = new Scene(root, Data.MAIN_SCREEN_WIDTH, Data.MAIN_SCREEN_HEIGHT);
            scene.getStylesheets().add(this.getClass().getResource("/gr/uom/theater/resources/css/Style.css").toExternalForm());

            primaryStage.centerOnScreen();
            primaryStage.setResizable(false);
            primaryStage.hide();
            primaryStage.setTitle("Έκδοση Εισητηρίων Θεάτρου");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void submitAction() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Επιτυχία!");
        alert.setHeaderText(null);
        Random rand = new Random();
        alert.setContentText("Η κράτηση σας ολοκληρώθηκε με επιτυχία.\nΟ κωδικός κράτησης είναι : " + rand.nextInt((516546516 - 123154646) + 1) + 123154646 + ".\nΘα ενημερωθείτε με e-mail!");

        alert.showAndWait();

        Data.selectedSeats = 0;
        btnBack.fire();
    }
}
