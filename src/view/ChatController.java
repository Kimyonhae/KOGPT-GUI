package view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ChatController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField chatData;

    @FXML
    private Button logout;

    @FXML
    private Button sendBtn;

    @FXML
    void logoutEvent(ActionEvent event) {
        // LoginController에 있는 객체를 가져와서 해당 메서드를 변형시킨 함수를 실행합니다.
        LoginController controller = new LoginController();
        controller.loginSuccess(event, "login.fxml");
    }

    @FXML
    void sendDataEvent(ActionEvent event) {
        
    }

    @FXML
    void initialize() {
        assert chatData != null : "fx:id=\"chatData\" was not injected: check your FXML file 'chat.fxml'.";
        assert logout != null : "fx:id=\"logout\" was not injected: check your FXML file 'chat.fxml'.";
        assert sendBtn != null : "fx:id=\"sendBtn\" was not injected: check your FXML file 'chat.fxml'.";

    }

}
