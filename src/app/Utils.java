package app;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Utils {
    public static Scene loadView(String location) throws IOException {
        return new Scene(FXMLLoader.load(Utils.class.getResource(location)));
    }

    public static String getFileContents(String fileLocation) {
        String fileData = "";
        try {
            fileData = new String(Files.readAllBytes(Paths.get(fileLocation)));
        } catch (IOException e) {
            System.out.println("File not found...");
            e.printStackTrace();
        }
        return fileData;
    }

    public static int getByte(String txt) throws UnsupportedEncodingException {
        return txt.getBytes(StandardCharsets.UTF_8).length;
    }
}
