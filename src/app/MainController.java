package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class MainController {

    FileChooser fc = Utils.FileDialog();

    @FXML
    private TextField comporessorFIleLocationTextField;

    public void comporessorChooseSourceFileLocation(ActionEvent e) {
//        File file = fc.showOpenDialog(new Stage());
        comporessorFIleLocationTextField.setText("hi");
    }

    public void comporessorChooseDestinitionFileLocation(ActionEvent e) {
    }

    public void extractorChooseSourceFileLocation(ActionEvent e) {
    }

    public void extractorChooseDestinitionFileLocation(ActionEvent e) {
    }


    public void handleCompressButtonClick(ActionEvent e) {
    }

    public void handleExtractButtonClick(ActionEvent e) {
    }

}
