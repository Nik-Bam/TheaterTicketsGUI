package gr.uom.theater.gui.controllers;

import gr.uom.theater.resources.Data;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class AdminMainScreenController {

    @FXML
    private ImageView image;

    @FXML
    private void initialize() {
        image.setImage(Data.NO_IMAGE);
    }
}
