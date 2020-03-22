package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

public class MainController {

    private Stage stage = new Stage();

    @FXML
    private VBox window;

    @FXML
    private FileChooser fc = Utils.FileDialog();


    public void encodeFile(ActionEvent e) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/app/result.fxml"));
        Parent result = (Parent) loader.load();

        ResultController rc = loader.getController();

        File file = fc.showOpenDialog(new Stage());

        rc.showFileSize(Integer.toString(Utils.getByte(Utils.getFileContents(file.getCanonicalPath()))));

        window.getChildren().setAll(result);
    }


    @FXML
    public void decodeFile(ActionEvent e) {


        File file = fc.showSaveDialog(new Stage());

        Utils.saveToFile("Hello world", file);

    }

}
