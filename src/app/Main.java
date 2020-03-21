package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Main extends Application {

    public Stage mainWIndow;

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        Scene scene = new Scene(root , 350 , 250);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Welcome Screen");
        primaryStage.show();

        mainWIndow = primaryStage;

    }


    public static void main(String[] args)
    {
        launch(args);
    }
}
