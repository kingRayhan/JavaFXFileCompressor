package app;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application {

    private Button uploaderBtn;


    /**
     * Start the primary stage
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(Utils.loadView("welcome.fxml"));
        primaryStage.setTitle("Welcome");
        primaryStage.show();
    }

    /**
     * Main method
     * @param args
     */
    public static void main(String[] args)
    {
        launch(args);
    }
}
