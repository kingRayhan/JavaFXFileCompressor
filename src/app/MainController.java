package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class MainController {

    @FXML
    public void uploadFile(ActionEvent e) throws IOException {

        ((Node)e.getTarget()).getScene().getWindow().hide();

        Stage stage = new Stage();
//        Stage stage2 = new Stage();
//        FileChooser fc = new FileChooser();
//        File file = fc.showOpenDialog(stage);
//        String txt = Utils.getFileContents(file.getCanonicalPath());
//


        stage.setScene(Utils.loadView("result.fxml"));
        stage.show();


    }

}
