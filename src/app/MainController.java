package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class MainController {

    @FXML
    private TextField compressorSourceFileLocationTextField;
    @FXML
    private TextField extractorSourceFileLocationTextField;
    @FXML
    private TextField compressorDestTextField;
    @FXML
    private TextField extractorDestTextField;


    private FileChooser fc = Utils.fileDialog();

    @FXML
    void comporessorChooseDestinitionFileLocation(ActionEvent event) {
        DirectoryChooser dc = new DirectoryChooser();
        File file = dc.showDialog(new Stage());
        compressorDestTextField.setText(file.getAbsolutePath());
    }

    @FXML
    void comporessorChooseSourceFileLocation(ActionEvent event) {
        File file = fc.showOpenDialog(new Stage());
        compressorSourceFileLocationTextField.setText(file.getAbsolutePath());
    }

    @FXML
    void extractorChooseDestinitionFileLocation(ActionEvent event) {
        DirectoryChooser dc = Utils.directoryDialog();
        File dir = dc.showDialog(new Stage());
        extractorDestTextField.setText(dir.getAbsolutePath());
    }

    @FXML
    void extractorChooseSourceFileLocation(ActionEvent event) {
        File file = fc.showOpenDialog(new Stage());
        extractorSourceFileLocationTextField.setText(file.getAbsolutePath());
    }

    @FXML
    void handleCompressButtonClick(ActionEvent event) {
        System.out.println(compressorSourceFileLocationTextField.getText());
    }

    @FXML
    void handleExtractButtonClick(ActionEvent event) {

    }

}
