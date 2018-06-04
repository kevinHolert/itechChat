package View;

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

import java.io.IOException;
import java.util.ArrayList;

public class mainWindowController {

        @FXML
        private TextField searchUserNameTextField;

        @FXML
        private Button searchButton;

        @FXML
        private ListView<?> usersListTextArea;

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

        @FXML
        void search(ActionEvent event) {

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
            ArrayList<String> user = new ArrayList<>();
            //Datenbankuser zur List adden
            //Backen


        }

    }



