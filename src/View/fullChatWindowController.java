package View;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class fullChatWindowController {

    @FXML
    private AnchorPane chatPane;

    @FXML
    private Label latestMessage1;

    @FXML
    private Label latestMessage2;

    @FXML
    private Label latestMessage3;

    @FXML
    private Label latestMessage4;

    @FXML
    private Label latestMessage5;

    @FXML
    private Label latestMessage6;

    @FXML
    private Label latestMessage7;

    @FXML
    private Label latestMessage8;

    @FXML
    private Label latestMessage9;

    @FXML
    private Button backToMainWindowButton;

    @FXML
    void backToMainWindow(ActionEvent event) throws IOException{
        itechChatLoginWindowController login = new itechChatLoginWindowController();
        login.openMainWindow(event);

    }


}
