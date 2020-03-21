package app;

import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.text.Text;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class ResultController implements Initializable {
    private Label fileSize;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void showFileSize(int size) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setContentText(Integer.toString(size));
        a.show();
    }


}
