package app;

import Algo.HuffmanEncoder;
import Algo.HuffmanEncodedResult;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.UnsupportedEncodingException;

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
    void handleCompressButtonClick(ActionEvent event) throws UnsupportedEncodingException {
        String fileLocation = compressorSourceFileLocationTextField.getText();
        String fileContent = Utils.getFileContents(fileLocation);

        int beforeCompress = Utils.getByte(fileContent);
        HuffmanEncodedResult compressed = hf.compress(fileContent);

        int afterCompress = Utils.getByte(compressed.getEncodedData());

        System.out.println("Before compress: " + beforeCompress);
//        System.out.println("After compress: " + afterCompress);

        System.out.println(compressed.getEncodedData().length());

        System.out.println(hf.decompress(compressed));


    }

    @FXML
    void handleExtractButtonClick(ActionEvent event) {

    }

}
