package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Controller {

    private int counter = 0;



    @FXML
    private Label counterMonitor;

    @FXML
    public void uploadFile(ActionEvent e) throws IOException {
//        ((Node) e.getTarget()).getScene().getWindow().hide();
        Stage stage = new Stage();
        FileChooser fc = new FileChooser();
        File file = fc.showOpenDialog(stage);

        String txt = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));

        System.out.println(txt.getBytes("UTF-8").length);

    }

}
