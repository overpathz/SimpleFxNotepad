import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveTextController {

    public static String lastFilePath;

    @FXML
    private TextField filePathEntry;

    @FXML
    private Button saveBtn;

    @FXML
    void initialize() {

        if (lastFilePath != null && !lastFilePath.isEmpty()) {
            filePathEntry.setText(lastFilePath);
        }
    }

    @FXML
    void save(ActionEvent event) {

        String filePath = filePathEntry.getText();
        File file = new File(filePath);

        String textToSave = BufferText.getText();

        lastFilePath = filePath;

        try (FileWriter fileWriter = new FileWriter(file);){
            fileWriter.write(textToSave);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Text has been saved!");
        alert.show();

    }

    public static String getLastFilePath() {
        synchronized (SaveTextController.class) {
            return lastFilePath;
        }
    }

    public static void setLastFilePath(String lastFilePath) {
        synchronized (SaveTextController.class) {
            SaveTextController.lastFilePath = lastFilePath;
        }
    }
}
