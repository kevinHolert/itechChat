package View;

import backend.User;
import javafx.beans.value.ObservableStringValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import backend.dbConnect;

import java.io.IOException;
import java.util.ArrayList;

public class mainWindowController {
        @FXML
        private Button logOutButton;

        @FXML
        private TextField searchUserNameTextField;

        @FXML
        private Button searchButton;

        @FXML
        private TextArea usersListTextArea;

        @FXML
        private Label messageToLabel;

        @FXML
        private Button viewFullChatButton;

        @FXML
        private Label receivingUserLabel;

        @FXML
        private TextArea sendMessageTextArea;

        @FXML
        private Button sendMessageButton;

        void checkUserName(){
            dbConnect db = new dbConnect();
            if(db.confirmUsername(searchUserNameTextField.getText())){
                messageToLabel.setText("Nachricht an " + searchUserNameTextField.getText());
            } else {
                // TODO: Kevin muss hier ein Fenster mit einer Fehlermeldung bauen!!!!
            }
        }

        @FXML
        void search(ActionEvent event) {
            itechChatLoginWindowController login = new itechChatLoginWindowController();
            checkUserName();
            showUsers();
        }

        @FXML
        void sendMessage(ActionEvent event) {

        }

        @FXML
        void showFullChatWindow(ActionEvent event) throws IOException {
            openFullChatWindow(event);

        }

        void openFullChatWindow(ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("fullChatWindow.fxml"));
            Stage stage = new Stage();
            stage.setTitle("FullChat");
            stage.setScene(new Scene(root, 450, 450));
            stage.setFullScreen(true);
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }

        public void showUsers(){

            dbConnect db = new dbConnect();
            ArrayList<User> user = new ArrayList<>();
            user = db.getAllUsers();
            for(int i=0; i < user.size();i++) {
                System.out.println(user.get(i).getUsername());
                usersListTextArea.appendText(user.get(i).getUsername()+ System.getProperty("line.separator"));
            }
            //usersListTextArea.setText(user);

        }
        @FXML
        void logOut(ActionEvent event) {
            fullChatWindowController fullch = new fullChatWindowController();
            fullch.logOut(event);
        }

    }



