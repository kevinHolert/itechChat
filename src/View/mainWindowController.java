package View;

import backend.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import backend.dbConnect;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class mainWindowController implements Initializable{
        @Override
        public void initialize(URL url, ResourceBundle bundle){
            showUsers();
        }

        //Button
        @FXML
        private Button searchButton;
        @FXML
        private Button logOutButton;
        @FXML
        private Button viewFullChatButton;
        @FXML
        private Button sendMessageButton;

        //Label
        @FXML
        private Label messageToLabel;
        @FXML
        private Label userNotKnownLabel;
        @FXML
        private Label receivingUserLabel;

        //Text
        @FXML
        private TextField searchUserNameTextField;
        @FXML
        private TextArea usersListTextArea;
        @FXML
        private TextArea sendMessageTextArea;

    public static User receiver = new User();

        void checkUserName(){
            dbConnect db = new dbConnect();
            if(db.confirmUsername(searchUserNameTextField.getText())){
                 receiver = db.getUser(searchUserNameTextField.getText());
                messageToLabel.setText("Nachricht an " + searchUserNameTextField.getText());
            } else {
                userNotKnownLabel.setVisible(true);
            }
        }


        @FXML
        void handleErrorMessage(MouseEvent event) {
            userNotKnownLabel.setVisible(false);
        }

        @FXML
        void search(ActionEvent event) {
            loginWindowController login = new loginWindowController();
            checkUserName();
        }

        @FXML
        void showFullChatWindow(ActionEvent event) throws IOException {
            openFullChatWindow(event);

        }

        void openFullChatWindow(ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("fullChatWindow.fxml"));
            Stage stage = new Stage();
            stage.setTitle("FullChat");
            stage.setScene(new Scene(root, 550, 450));
            stage.setMinWidth(550);
            stage.setMinHeight(450);
            stage.setFullScreen(false);
            stage.show();
            ((Node) (event.getSource())).getScene().getWindow().hide();
        }

        public void showUsers(){

            dbConnect db = new dbConnect();
            ArrayList<User> user = new ArrayList<>();
            user = db.getAllUsers();
            for(int i=0; i < user.size();i++) {
                System.out.println(user.get(i).getUsername());
                usersListTextArea.appendText(user.get(i).getUsername()+ System.getProperty("line.separator"));
            }
        }

        @FXML
        void logOut(ActionEvent event) throws IOException {
                loginWindowController itech = new loginWindowController();
                itech.openloginWindow(event);
        }

    }



