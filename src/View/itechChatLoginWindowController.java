package View;


import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class itechChatLoginWindowController {

    @FXML
    private TextField userNameTextField;

    @FXML
    private PasswordField passwortBox;

    @FXML
    private Button loginButton;

    @FXML
    void login(ActionEvent event) throws IOException {

        userNameTextField.clear();
        passwortBox.clear();
        openMainWindow(event);

    }

    void openMainWindow(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("mainWindow.fxml"));
        Stage stage = new Stage();
        stage.setTitle("scholzi");
        stage.setScene(new Scene(root, 450, 450));
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

}






