package app;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.PublicKey;

public class Utils {
    public static FXMLLoader loadView(String location) throws IOException {
        FXMLLoader root = FXMLLoader.load(Utils.class.getResource(location));
        return root;
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

    // Source: https://www.genuinecoder.com/save-files-javafx-filechooser/
    public static void saveToFile(String content, File file) {
        try {
            PrintWriter writer;
            writer = new PrintWriter(file);
            writer.println(content);
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static FileChooser fileDialog(String ext) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Select txt file (*." + ext + ")", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        fileChooser.setTitle("Select a text file");
        return fileChooser;
    }

    public static FileChooser fileDialog() {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Select txt file (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        fileChooser.setTitle("Select a text file");
        return fileChooser;
    }

    public static DirectoryChooser directoryDialog(String title) {
        DirectoryChooser dc = new DirectoryChooser();
        dc.setTitle(title);
        return dc;
    }

    public static DirectoryChooser directoryDialog() {
        DirectoryChooser dc = new DirectoryChooser();
        dc.setTitle("Select directory");
        return dc;
    }
}
