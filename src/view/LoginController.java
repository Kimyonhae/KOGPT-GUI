package view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import service.UserService;

public class LoginController {

    UserService service = new UserService();

    @FXML
    private TextField userField;
    @FXML
    private TextField passwordField;
    @FXML
    private Button loginBtn;
    @FXML
    private Button registerBtn;
    @FXML
    private Text errorMessage;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void initialize() {
    }

    public void loginEvent() {
        if (userField.getText().isEmpty() || passwordField.getText().isEmpty()) {
            errorMessage.setText("userId 또는 password가 비어있습니다.");
            return;
        }
        if (userField.getText().length() < 3 || passwordField.getText().length() < 5) {
            errorMessage.setText("userId는 최소 3개의 문자 | password는 최소 5개의 문자 입니다.");
            return;
        }
        if (userField.getText().equals(passwordField.getText())) {
            errorMessage.setText("userId 와 password는 같으면 안됩니다.");
            return;
        }
        // login success
        String responseMsg = service.login(userField.getText(), passwordField.getText());
        if (responseMsg == "메세지 보내기 성공입니다.") {
            errorMessage.setFill(Color.GREEN);
            // 다른 page로 가는 code를 작성해주세요.
        }
        errorMessage.setText(responseMsg);
        userField.setText("");
        passwordField.setText("");
    }

    public void registerEvent() {
        String responseMsg = service.register(userField.getText(), passwordField.getText());
        if (responseMsg == "회원등록이 완료되었습니다.") {
            errorMessage.setFill(Color.GREEN);
        }
        errorMessage.setText(responseMsg);
        userField.setText("");
        passwordField.setText("");
    }
}
