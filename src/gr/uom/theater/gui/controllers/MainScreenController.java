package gr.uom.theater.gui.controllers;

import gr.uom.theater.application.Performance;
import gr.uom.theater.application.Play;
import gr.uom.theater.resources.Data;
import gr.uom.theater.resources.Util;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.controlsfx.control.CheckComboBox;

import java.io.IOException;

public class MainScreenController {

    @FXML
    TextArea lblSummary;
    @FXML
    private TableColumn theaterCol, dateCol, timeCol, availableCol;
    @FXML
    private Button btnClear, btnApplyFilters, btnSubmit;
    @FXML
    private TableView tablePlays;
    @FXML
    private Label lblCostumes, lblMusic, lblActors, lblDirector, lblWriter;
    @FXML
    private ImageView imgPoster;

    @FXML
    private ComboBox<String> cbCities, cbYearFrom, cbYearTo;

    @FXML
    private CheckComboBox<String> cbWriters, cbDirectors, cbActors, cbMusic, cbCostumes;

    @FXML
    private HBox playWrapper, playInfoWrapper, performanceWrapper;

    @FXML
    private TextField txtYearFrom, txtYearTo;

    @FXML
    private ListView<Play> lvPlays;

    @FXML
    private void initialize() {
        cbCities.setTooltip(Data.CITY_TOOLTIP);
        cbCities.setItems(Data.CITIES);
        cbCities.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            String city = cbCities.getSelectionModel().getSelectedItem();
            cityChanged(city);
        });

        cbYearFrom.getItems().add("π.Χ.");
        cbYearFrom.getItems().add("μ.Χ.");
        cbYearFrom.getSelectionModel().select(1);

        cbYearTo.getItems().add("π.Χ.");
        cbYearTo.getItems().add("μ.Χ.");
        cbYearTo.getSelectionModel().select(1);

        cbWriters.getItems().add("<Όλους>");
        cbDirectors.getItems().add("<Όλους>");
        cbActors.getItems().add("<Όλους>");
        cbMusic.getItems().add("<Όλους>");
        cbCostumes.getItems().add("<Όλους>");

        cbWriters.getCheckModel().getCheckedItems().addListener(Util.getCCBChangeListener(cbWriters));
        cbDirectors.getCheckModel().getCheckedItems().addListener(Util.getCCBChangeListener(cbDirectors));
        cbActors.getCheckModel().getCheckedItems().addListener(Util.getCCBChangeListener(cbActors));
        cbMusic.getCheckModel().getCheckedItems().addListener(Util.getCCBChangeListener(cbMusic));
        cbCostumes.getCheckModel().getCheckedItems().addListener(Util.getCCBChangeListener(cbCostumes));

        tablePlays.setTooltip(Data.THEATERS_TOOLTIP);
        tablePlays.setPlaceholder(new Label(Data.TABLE_PLACEHOLDER));

        lvPlays.setTooltip(Data.PLAYS_TOOLTIP);
        lvPlays.setCellFactory(new Callback<ListView<Play>, ListCell<Play>>() {

            @Override
            public ListCell<Play> call(ListView<Play> p) {
                return new ListCell<Play>() {
                    @Override
                    protected void updateItem(Play t, boolean bln) {
                        super.updateItem(t, bln);
                        if (t != null) {
                            setText(t.getTitle() + " (" + t.getYear() + ")");
                        }
                    }
                };
            }
        });

        theaterCol.setCellValueFactory(
                new PropertyValueFactory<Performance, String>("theater"));
        dateCol.setCellValueFactory(
                new PropertyValueFactory<Performance, String>("date"));
        timeCol.setCellValueFactory(
                new PropertyValueFactory<Performance, String>("time"));
        availableCol.setCellValueFactory(
                new PropertyValueFactory<Performance, String>("availableTickets"));

        tablePlays.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                Data.selectedPerformance = (Performance) newSelection;
                btnSubmit.setDisable(false);
            } else {
                btnSubmit.setDisable(true);
            }
        });

        btnSubmit.setOnAction(event -> {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/gr/uom/theater/gui/SeatsScreen.fxml"));

                Stage primaryStage = (Stage) ((Button) event.getSource()).getScene().getWindow();

                Scene scene = new Scene(root, Data.SEATS_SCREEN_WIDTH, Data.SEATS_SCREEN_HEIGHT);
                scene.getStylesheets().add(this.getClass().getResource("/gr/uom/theater/resources/css/Style.css").toExternalForm());

                primaryStage.centerOnScreen();
                primaryStage.setResizable(false);
                primaryStage.hide();
                primaryStage.setTitle("Επιλογή Θέσεων");
                primaryStage.setScene(scene);
                primaryStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

    private void cityChanged(String city) {
        Data.selectedCity = city;
        playWrapper.setDisable(false);
        lvPlays.setItems(Data.PLAYS);
        cbWriters.getItems().addAll(Util.personListToStringList(Data.WRITERS));
        cbDirectors.getItems().addAll(Util.personListToStringList(Data.DIRECTORS));
        cbActors.getItems().addAll(Util.personListToStringList(Data.ACTORS));
        cbMusic.getItems().addAll(Util.personListToStringList(Data.MUSICIANS));
        cbCostumes.getItems().addAll(Util.personListToStringList(Data.COSTUMES));
        cbWriters.getCheckModel().check(0);
        cbDirectors.getCheckModel().check(0);
        cbActors.getCheckModel().check(0);
        cbMusic.getCheckModel().check(0);
        cbCostumes.getCheckModel().check(0);

        lvPlays.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                playInfoWrapper.setDisable(false);
                imgPoster.setImage(newValue.getPoster());
                performanceWrapper.setDisable(false);
                lblWriter.setText(Util.listToString(newValue.getWriters()));
                lblDirector.setText(Util.listToString(newValue.getDirectors()));
                lblActors.setText(Util.listToString(newValue.getActors()));
                lblMusic.setText(Util.listToString(newValue.getMusicians()));
                lblCostumes.setText(Util.listToString(newValue.getCostumes()));
                lblSummary.setText(newValue.getSummary());
                tablePlays.setItems(FXCollections.observableArrayList(newValue.getPerformances(Data.selectedCity)));
            } else {
                imgPoster.setImage(Data.NO_IMAGE);
                performanceWrapper.setDisable(true);
                lblWriter.setText("-");
                lblDirector.setText("-");
                lblActors.setText("-");
                lblMusic.setText("-");
                lblCostumes.setText("-");
                lblSummary.setText("-");
                btnSubmit.setDisable(true);
                tablePlays.getItems().clear();
            }
        });
    }
}
