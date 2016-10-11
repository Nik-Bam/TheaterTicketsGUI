package gr.uom.theater.application;

import gr.uom.theater.resources.Data;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/gr/uom/theater/gui/WelcomeScreen.fxml"));
        primaryStage.setTitle("Σύνδεση ως");

        Scene scene = new Scene(root, Data.SMALL_SCREEN_WIDTH, Data.SMALL_SCREEN_HEIGHT);
        scene.getStylesheets().add(this.getClass().getResource("/gr/uom/theater/resources/css/Style.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
