package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

public class MainController {

    private Alert informationDialog = new Alert(Alert.AlertType.INFORMATION);
    private Stage stage = new Stage();
    private FileChooser fc = new FileChooser();


    @FXML
    public void uploadFile(ActionEvent e) throws IOException {
        ((Node) e.getTarget()).getScene().getWindow().hide();

        FXMLLoader result = new FXMLLoader(getClass().getResource("result.fxml"));
        Parent resultScene = result.load();
        ResultController rc = result.getController();

        File file = fc.showOpenDialog(stage);


        rc.showFileSize(Utils.getByte(file.getCanonicalPath()));

        stage.setScene(new Scene(resultScene));


    }

}
