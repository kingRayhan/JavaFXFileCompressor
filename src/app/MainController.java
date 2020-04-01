package app;

import Algo.HuffmanEncoder;
import Algo.HuffmanEncodedResult;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class MainController {

    private HuffmanEncoder hf = new HuffmanEncoder();

    @FXML
    private TextField compressorSourceFileLocationTextField;
    @FXML
    private TextField extractorSourceFileLocationTextField;


    @FXML
    void comporessorChooseSourceFileLocation(ActionEvent event) {
        FileChooser fc = Utils.fileDialog("txt");
        File file = fc.showOpenDialog(new Stage());
        compressorSourceFileLocationTextField.setText(file.getAbsolutePath());
    }

    @FXML
    void extractorChooseSourceFileLocation(ActionEvent event) {
        FileChooser fc = Utils.fileDialog("ez");
        File file = fc.showOpenDialog(new Stage());
        extractorSourceFileLocationTextField.setText(file.getAbsolutePath());
    }

    @FXML
    void handleCompressButtonClick(ActionEvent event) {
        String fileLocation = compressorSourceFileLocationTextField.getText();
        String fileContent = Utils.getFileContents(fileLocation);

        /**
         * Compressed file string with huffman algo
         */
        HuffmanEncodedResult encoded = hf.compress(fileContent); // encode file content

        // dialog box
        Alert dialog = new Alert(Alert.AlertType.INFORMATION);
        dialog.setHeaderText(null);




        //File chooser
        FileChooser fc = Utils.fileDialog("ez");
        File file = fc.showSaveDialog(new Stage());

        dialog.setContentText("Successfully compressed to destination location\nSaved in: " +  file.getAbsolutePath());

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file.getAbsolutePath()));
            out.writeObject(encoded);
            dialog.showAndWait();
        } catch (IOException e) {
            System.out.println("");
            e.printStackTrace();
            dialog.showAndWait();
        }
    }

    @FXML
    void handleExtractButtonClick(ActionEvent event) {
        String fileLocation = extractorSourceFileLocationTextField.getText();

        // dialog box
        Alert dialog = new Alert(Alert.AlertType.INFORMATION);
        dialog.setHeaderText(null);


        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileLocation));
            HuffmanEncodedResult decoded = (HuffmanEncodedResult) in.readObject();

            //Set extension filter for text files
            FileChooser fc = Utils.fileDialog("txt");
            File file = fc.showSaveDialog(new Stage());

            dialog.setContentText("Successfully extracted to destination location\nSaved in: " + file.getAbsolutePath());


            String decodedContent = hf.decompress(decoded);
            Utils.saveToFile(decodedContent, file);

            dialog.showAndWait();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            dialog.showAndWait();
        }
    }
}
