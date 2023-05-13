package view;

import java.io.IOException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
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
    void initialize() {
    }

    // login Event
    @FXML
    public void loginEvent(ActionEvent event) {
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
            // event는 fxml 파일의 event 핸들러를 그대로 받습니다. ex)onAction
            loginSuccess(event, "chat.fxml");
        }
        errorMessage.setText(responseMsg);
        userField.setText("");
        passwordField.setText("");
    }

    // register Event
    @FXML
    public void registerEvent() {
        String responseMsg = service.register(userField.getText(), passwordField.getText());
        if (responseMsg == "회원등록이 완료되었습니다.") {
            errorMessage.setFill(Color.GREEN);
        }
        errorMessage.setText(responseMsg);
        userField.setText("");
        passwordField.setText("");
    }

    // 로그인이 성공하면 다음 page로 이동
    public void loginSuccess(ActionEvent e, String sourceFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(sourceFile));
            Parent root = loader.load();

            Scene newScene = new Scene(root);

            // 현재 stage 가져오기
            Stage currentStage = (Stage) ((Node) e.getSource()).getScene().getWindow();

            // 현재 stage를 가져왔으므로 교체 시켜줍니다.
            currentStage.setScene(newScene);

            currentStage.show();
        } catch (IOException error) {
            System.out.println("error가 들어옵니다! loginSuccess error");
            error.printStackTrace();
        }
    }
}
