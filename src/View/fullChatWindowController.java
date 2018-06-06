package View;

import backend.Chat;
import backend.dbConnect;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class fullChatWindowController implements Initializable{

    //Button
    @FXML
    private Button sendButton;
    @FXML
    private Button logOutButton;
    @FXML
    private Button messagesDeleteButton;
    @FXML
    private Button loadMessageButton;
    @FXML
    private Button backToMainWindowButton;

    //Text
    @FXML
    private TextArea fullChatTextArea;
    @FXML
    private TextField MessageTextField;

    //Pane
    @FXML
    private AnchorPane chatPane;

    //Label
    @FXML
    private Label receiverLabel;


    @Override
    public void initialize(URL url, ResourceBundle bundle){
        ActionEvent event = new ActionEvent();
        loadMessages(event);
        receiverLabel.setText(mainWindowController.receiver.getUsername());
    }

    @FXML
    void backToMainWindow(ActionEvent event) throws IOException {
        loginWindowController login = new loginWindowController();
        login.openMainWindow(event);
    }

    @FXML
    void loadMessages(ActionEvent event){
        fullChatTextArea.clear();
        Chat chat = new Chat();
        System.out.println(loginWindowController.loggedIn.getUsername());
        System.out.println(mainWindowController.receiver.getUsername());
        chat = chat.getwholeChat(loginWindowController.loggedIn,mainWindowController.receiver);

        int size = chat.getAllMessages().size();

        for(int i=0;i<size;i++){
            fullChatTextArea.appendText(chat.getAllMessages().get(i).getUserFrom().getUsername()+": "+chat.getAllMessages().get(i).getMessage()+System.getProperty("line.separator"));
        }

    }

    @FXML
    void logOut(ActionEvent event) throws IOException {
        loginWindowController itech = new loginWindowController();
        itech.openloginWindow(event);
    }

    @FXML
    void sendMessage(ActionEvent event) {
        dbConnect db = new dbConnect();
        mainWindowController main = new mainWindowController();
        db.insertMessage(loginWindowController.loggedIn.getUserid(),main.receiver.getUserid(),MessageTextField.getText());
        MessageTextField.setText("");
        loadMessages(event);
    }
    @FXML
    void deleteMessages(ActionEvent event) {
        fullChatTextArea.clear();

    }


}
