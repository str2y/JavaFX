package javafxapplication1;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.io.InputStream;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Alert;

public class FXMLDocumentController implements Initializable {

    @FXML
    private Button waifuButton;

    @FXML
    private ImageView imageView;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        try {
            URL url = new URL("https://pic.re/image");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {

                try (
                        InputStream inputStream = connection.getInputStream()) {

                    Image image = new Image(inputStream);

                    imageView.setImage(image);

                }
            } else {
                System.out.println("Failed to get cat ;-; . Response Code: " + responseCode);
            }

            connection.disconnect();
        } catch (IOException e) {
            e.getMessage();
        }
    }
}