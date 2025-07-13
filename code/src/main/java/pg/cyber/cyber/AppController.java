package pg.cyber.cyber;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import pg.cyber.cyber.crypt.decrypt.DecryptSelect;
import pg.cyber.cyber.crypt.encrypt.EncryptSelect;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.ResourceBundle;

public class AppController implements Initializable {
    private Payload payload;
    @FXML
    private Label welcomeText;
    @FXML
    private ComboBox<String> encryption;
    @FXML
    private TextField passwordField;


    private EncryptSelect encrypt;
    private DecryptSelect decrypt;

    @FXML
    protected void onHelloButtonClick() {
        FileChooser fileChooser = new FileChooser();

        fileChooser.setTitle("Open Resource File");
        var file = fileChooser.showOpenDialog(welcomeText.getScene().getWindow());
        payload.setFile(file);
        welcomeText.setText("File (selected " + file.getName()+")");

    }
    @FXML
    protected void onDecryptButtonClick() {
        payload.setPassword(passwordField.getText());


        payload.setAlgorithm(AlgorithmAES.valueOf(encryption.getSelectionModel().getSelectedItem()));

        if (payload.getPassword().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Input error");
            alert.setContentText("Please enter a password");
            alert.showAndWait();
            return;
        }
        if(payload.getFile() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Input error");
            alert.setContentText("Please select a file");
            alert.showAndWait();
            return;
        }

        if(!decrypt.decrypt(payload)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Decrypt error");
            alert.setContentText("Something went wrong");
            alert.showAndWait();

        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Success");
            alert.setContentText("Success");
            alert.showAndWait();
        }
    }
    @FXML
    protected void onEncryptButtonClick() {
        payload.setPassword(passwordField.getText());
        payload.setAlgorithm(AlgorithmAES.valueOf(encryption.getSelectionModel().getSelectedItem()));

        if (payload.getPassword().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Input error");
            alert.setContentText("Please enter a password");
            alert.showAndWait();
            return;
        }
        if(payload.getFile() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Input error");
            alert.setContentText("Please select a file");
            alert.showAndWait();
            return;
        }
        if(!encrypt.encrypt(payload)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Encrypt error");
            alert.setContentText("Something went wrong");
            alert.showAndWait();

        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Success");
            alert.setContentText("Success");
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        encryption.getItems().addAll("CTR", "ECB", "CBC");
        encryption.getSelectionModel().selectFirst();
        payload = new Payload();
        encrypt = new EncryptSelect();
        decrypt = new DecryptSelect();

    }


}
