package View;


import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import backend.*;

import java.io.IOException;

public class itechChatLoginWindowController {
    public static User loggedIn = new User();
    @FXML
    public TextField userNameTextField;

    @FXML
    public PasswordField passwortBox;

    @FXML
    private Button loginButton;

    @FXML
    private TextField registerTextField;

    @FXML
    private PasswordField registerPasswort;


    @FXML
    private PasswordField registerPasswortConfirm;

    @FXML
    private Button saveRegisterButton;

    @FXML
    private Label errorLabel;


    @FXML
    private Label wrongUserLabel;


    @FXML
    void login(ActionEvent event) throws IOException {
        dbConnect db = new dbConnect();
        User user = new User();
        
        if(db.confirmUsername(userNameTextField.getText())){
            user =db.getUser(userNameTextField.getText());
        	System.out.println("User confirmed");
            if(user.checkPw(user, userNameTextField.getText(),passwortBox.getText())){
                loggedIn = db.getUser(userNameTextField.getText());
                System.out.println("open next window");
            	openMainWindow(event);
            }else{
                wrongUserLabel.setVisible(true);
            }
        }else {
                wrongUserLabel.setVisible(true);
            }
        }



    @FXML
    void handleErrorMessage(MouseEvent event) {
        wrongUserLabel.setVisible(false);
    }

    void openMainWindow(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("mainWindow.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Itech Chat");
        stage.setScene(new Scene(root, 550, 550));
        stage.setFullScreen(true);
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void register(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("registerWindow.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Itech Chat");
        stage.setScene(new Scene(root, 400, 420));
        stage.setFullScreen(false);
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();

    }

    @FXML
    void saveRegister(ActionEvent event) throws IOException {
        //registerTextField.getText();
        //passwortBox.getCharacters();
        dbConnect db = new dbConnect();
        if(!db.confirmUsername(registerTextField.getText()) && !registerTextField.getText().isEmpty() && !registerPasswort.getText().isEmpty()){
            if(registerPasswort.getText().equals(registerPasswortConfirm.getText())){
                User user = new User();
                user.setPw(user.hashpassword(registerPasswort.getText()));
                user.setUsername(registerTextField.getText());
                //System.out.println(user.getUsername()+user.getPw());
                db.insertUser(user);
                openloginWindow(event);
            }else{
                errorLabel.setVisible(true);
            }
        }else{
            errorLabel.setVisible(true);
        }





    }

    void openloginWindow(ActionEvent event)throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("itechChatLoginWindow.fxml"));
        Stage stage = new Stage();
        stage.setTitle("itech Chat");
        stage.setScene(new Scene(root, 480, 420));
        stage.setFullScreen(false);
        stage.setResizable(false);
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
}






