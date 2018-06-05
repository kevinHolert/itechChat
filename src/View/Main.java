package View;


import backend.dbConnect;
import backend.user;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

@Override
public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("itechChatLoginWindow.fxml"));
        primaryStage.setFullScreen(false);
        primaryStage.setTitle("itech Chat");
        primaryStage.setScene(new Scene(root));
        primaryStage.setMinHeight(400);
        primaryStage.setMinWidth(420);
        primaryStage.setResizable(false);
        primaryStage.show();
        }



public static void main(String[] args) {
        //user user = new user("Kevin","nurderhsv");
        launch(args);
        
        }

}
