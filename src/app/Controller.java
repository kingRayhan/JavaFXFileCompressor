package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;


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
        String txt = Utils.readFile(file.getAbsolutePath());

        System.out.println(Utils.getByte(txt));

//        stage.setScene(new Scene(Fxml));

    }

}
