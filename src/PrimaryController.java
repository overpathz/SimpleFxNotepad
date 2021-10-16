import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class PrimaryController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea textArea;

    @FXML
    private SplitMenuButton menu;

    @FXML
    private MenuItem mItemBlack;

    @FXML
    private MenuItem mItemRed;

    @FXML
    private MenuItem mItemGreen;

    @FXML
    private MenuItem mItemBlue;

    @FXML
    private Button saveBtn;

    @FXML
    void save(ActionEvent event) {

        String text = textArea.getText();

        if (text.length() < 1) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Text area is empty. Type something to save");
            alert.show();
        } else {
            BufferText.setText(text);

            Stage saveStage = new Stage();

            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("SaveText.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            Scene scene = new Scene(root);
            saveStage.setScene(scene);
            saveStage.show();
        }

    }

    @FXML
    void initialize() {
        mItemBlack.setOnAction(event -> {
            textArea.setStyle("-fx-text-fill: black");
        });

        mItemRed.setOnAction(event -> {
            textArea.setStyle("-fx-text-fill: red");
        });

        mItemGreen.setOnAction(event -> {
            textArea.setStyle("-fx-text-fill: green");
        });

        mItemBlue.setOnAction(event -> {
            textArea.setStyle("-fx-text-fill: blue");
        });
    }
}
