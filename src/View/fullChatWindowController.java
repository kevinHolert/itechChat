package View;

import backend.Chat;
import backend.User;
import backend.dbConnect;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class fullChatWindowController {

    //public static User receiver = new User();

    @FXML
    private AnchorPane chatPane;

    @FXML
    private TextArea fullChatTextArea;


    @FXML
    private TextField MessageTextField;

    @FXML
    private Button sendButton;

    @FXML
    private Button backToMainWindowButton;

    @FXML
    private Button logOutButton;

    @FXML
    private Button messagesDeleteButton;

    @FXML
    private Button loadMessageButton;

    @FXML
    void backToMainWindow(ActionEvent event) throws IOException {
        itechChatLoginWindowController login = new itechChatLoginWindowController();
        login.openMainWindow(event);
    }


    @FXML
    void deleteMessages(ActionEvent event) {
        clearReceivedMessages();
        clearOwnMessages();
    }

    @FXML
    void loadMessages(ActionEvent event){

        Chat chat = new Chat();
        System.out.println(itechChatLoginWindowController.loggedIn.getUsername());
        System.out.println(mainWindowController.receiver.getUsername());
        chat = chat.getChat(itechChatLoginWindowController.loggedIn,mainWindowController.receiver);

        int sizeReceived = chat.getReceivedMessages().size();
        int sizeSent = chat.getSentMessages().size();

        for(int i=0;i<sizeReceived+sizeSent;i++){

        }
        if(sizeReceived != 0 && sizeSent!=0){
            if(i<sizeReceived){
                ownMessage1.setText(chat.getSentMessages().get(i).getMessage());
                i++;
            }
        }

        for(int i=0;i < chat.getReceivedMessages().size();i++){
            fullChatTextArea.setText(chat.getSentMessages().get(i).getMessage());
        }

    }

    void ownMessageSetter(String Datenbankeintrag){
        Chat chat = new Chat();
        chat = chat.getChat(itechChatLoginWindowController.loggedIn,mainWindowController.receiver);

        for(int i=0;i < chat.getReceivedMessages().)
            fullChatTextArea.setText(chat.getSentMessages().get(0).getMessage());
    }



    }
    public void clearOwnMessages(){

    }

    void receivedMessageSetter(String Datenbankeintrag) {

    }


    public void clearReceivedMessages(){

    }

    @FXML
    void logOut(ActionEvent event) {

    }

    @FXML
    void sendMessage(ActionEvent event) {
        dbConnect db = new dbConnect();
        mainWindowController main = new mainWindowController();
        db.insertMessage(itechChatLoginWindowController.loggedIn.getUserid(),main.receiver.getUserid(),MessageTextField.getText());
        MessageTextField.setText("");
    }

}
