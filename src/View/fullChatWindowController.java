package View;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class fullChatWindowController {

    @FXML
    private AnchorPane chatPane;

    @FXML
    private Label ownMessage4;

    @FXML
    private Label receivedMessage5;

    @FXML
    private Label ownMessage5;

    @FXML
    private Label receivedMessage6;

    @FXML
    private Label ownMessage6;

    @FXML
    private Label receivedMessage7;

    @FXML
    private Label ownMessage7;

    @FXML
    private Label receivedMessage8;

    @FXML
    private Label ownMessage8;

    @FXML
    private Label receivedMessage4;

    @FXML
    private Label ownMessage3;

    @FXML
    private Label receivedMessage3;

    @FXML
    private Label ownMessage2;

    @FXML
    private Label receivedMessage2;

    @FXML
    private Label ownMessage1;

    @FXML
    private Label receivedMessage1;

    @FXML
    private Button backToMainWindowButton;

    @FXML
    void backToMainWindow(ActionEvent event) {

    }

    void ownMessageSetter(String Datenbankeintrag){
        if (ownMessage1.getText().isEmpty()) {
            ownMessage1.setText(Datenbankeintrag);
        } else if (ownMessage2.getText().isEmpty()) {
            ownMessage2.setText(Datenbankeintrag);
        } else if (ownMessage3.getText().isEmpty()) {
            ownMessage3.setText(Datenbankeintrag);
        } else if (ownMessage4.getText().isEmpty()) {
            ownMessage4.setText(Datenbankeintrag);
        } else if (ownMessage5.getText().isEmpty()) {
            ownMessage5.setText(Datenbankeintrag);
        } else if (ownMessage6.getText().isEmpty()) {
            ownMessage6.setText(Datenbankeintrag);
        } else if (ownMessage7.getText().isEmpty()) {
            ownMessage7.setText(Datenbankeintrag);
        } else if (ownMessage8.getText().isEmpty()) {
            ownMessage8.setText(Datenbankeintrag);
        } else if (!ownMessage1.getText().isEmpty() && !ownMessage2.getText().isEmpty() && !ownMessage3.getText().isEmpty() && !ownMessage4.getText().isEmpty()
                && !ownMessage5.getText().isEmpty() && !ownMessage6.getText().isEmpty() && !ownMessage7.getText().isEmpty() && !ownMessage8.getText().isEmpty()) {
            clearOwnMessages();
            ownMessage1.setText(Datenbankeintrag);
        }

    }
    public void clearOwnMessages(){
        ownMessage1.setText("");
        ownMessage2.setText("");
        ownMessage3.setText("");
        ownMessage4.setText("");
        ownMessage5.setText("");
        ownMessage6.setText("");
        ownMessage7.setText("");
        ownMessage8.setText("");
    }

    void receivedMessageSetter(String Datenbankeintrag){
        if (receivedMessage1.getText().isEmpty()) {
            receivedMessage1.setText(Datenbankeintrag);
        } else if (receivedMessage2.getText().isEmpty()) {
            receivedMessage2.setText(Datenbankeintrag);
        } else if (receivedMessage3.getText().isEmpty()) {
            receivedMessage3.setText(Datenbankeintrag);
        } else if (receivedMessage4.getText().isEmpty()) {
            receivedMessage4.setText(Datenbankeintrag);
        } else if (receivedMessage5.getText().isEmpty()) {
            receivedMessage5.setText(Datenbankeintrag);
        } else if (receivedMessage6.getText().isEmpty()) {
            ownMessage6.setText(Datenbankeintrag);
        } else if (receivedMessage7.getText().isEmpty()) {
            receivedMessage7.setText(Datenbankeintrag);
        } else if (receivedMessage8.getText().isEmpty()) {
            receivedMessage8.setText(Datenbankeintrag);
        } else if (!receivedMessage1.getText().isEmpty() && !receivedMessage2.getText().isEmpty() && !receivedMessage3.getText().isEmpty() && !receivedMessage4.getText().isEmpty()
                && !receivedMessage5.getText().isEmpty() && !receivedMessage6.getText().isEmpty() && !receivedMessage7.getText().isEmpty() && !receivedMessage8.getText().isEmpty()) {
            clearOwnMessages();
            ownMessage1.setText(Datenbankeintrag);
        }

    }
    public void clearReceivedMessages(){
        receivedMessage1.setText("");
        receivedMessage2.setText("");
        receivedMessage3.setText("");
        receivedMessage4.setText("");
        receivedMessage5.setText("");
        receivedMessage6.setText("");
        receivedMessage7.setText("");
        receivedMessage8.setText("");
    }

}
