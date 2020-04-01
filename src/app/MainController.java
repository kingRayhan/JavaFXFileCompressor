package app;

import Algo.HuffmanEncoder;
import Algo.HuffmanEncodedResult;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.*;
import java.util.Arrays;

public class MainController {

    private HuffmanEncoder hf = new HuffmanEncoder();

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
        String fileLocation = compressorSourceFileLocationTextField.getText();
        String fileContent = Utils.getFileContents(fileLocation);
        HuffmanEncodedResult encoded = hf.compress(fileContent); // encode file content

        // dialog box
        Alert dialog = new Alert(Alert.AlertType.INFORMATION);
        dialog.setHeaderText(null);
        dialog.setContentText("Successfully compressed to destination location");

        //Set extension filter for text files
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Compressed file (*.expressZipper)", "*.expressZipper");
        fc.getExtensionFilters().add(extFilter);

        File file  = fc.showSaveDialog(new Stage());

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file.getAbsolutePath()));
            out.writeObject(encoded);


            dialog.showAndWait();

        } catch (IOException e) {
            System.out.println("");
            dialog.showAndWait();
        }
    }

    @FXML
    void handleExtractButtonClick(ActionEvent event) {
        String fileLocation = extractorSourceFileLocationTextField.getText();

        // dialog box
        Alert dialog = new Alert(Alert.AlertType.INFORMATION);
        dialog.setHeaderText(null);
        dialog.setContentText("Successfully extracted to destination location");

        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileLocation));
            HuffmanEncodedResult decoded = (HuffmanEncodedResult) in.readObject();

            //Set extension filter for text files
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Compressed file (*.txt)", "*.txt");
            fc.getExtensionFilters().add(extFilter);
            File file  = fc.showSaveDialog(new Stage());

            String decodedContent = hf.decompress(decoded);
            Utils.saveToFile(decodedContent , file);

            dialog.showAndWait();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("");
            dialog.showAndWait();
        }
    }
}
