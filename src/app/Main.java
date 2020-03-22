package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application {

    private Button uploaderBtn;


    /**
     * Start the primary stage
     *
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Welcome");
        Parent welcome = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        stage.setScene(new Scene(welcome));
        stage.show();
    }
    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
