package pg.cyber.cyber;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class CryptApplication extends Application {
    public static byte[] SALT = new byte[16];

    private void generateSalt() {
        SALT[0] = (byte) 0x02;
        SALT[1] = (byte) 0x55;
        SALT[2] = (byte) 0xf6;
        SALT[3] = (byte) 0xbf;
        SALT[4] = (byte) 0xcf;
        SALT[5] = (byte) 0xfd;
        SALT[6] = (byte) 0xd3;
        SALT[7] = (byte) 0xfd;
        SALT[8] = (byte) 0xf3;
        SALT[9] = (byte) 0xe2;
        SALT[10] = (byte) 0xc3;
        SALT[11] = (byte) 0xb3;
        SALT[12] = (byte) 0x5f;
        SALT[13] = (byte) 0xf1;
        SALT[14] = (byte) 0xd3;
        SALT[15] = (byte) 0xae;
    }
    @Override
    public void start(Stage stage) throws IOException {
        generateSalt();
        FXMLLoader fxmlLoader = new FXMLLoader(CryptApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("cyber.css")).toExternalForm());
        stage.setTitle("Encrypter (EIN EKRIPIONEN MACHINE)");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
