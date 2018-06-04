package View;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class mainWindowController {

    @FXML
    private TextField searchUserNameTextField;

    @FXML
    private Button searchButton;

    @FXML
    private ListView<?> chatsListView;

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

}

