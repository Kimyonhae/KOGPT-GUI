package view;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import controller.CustomListCeil;
import controller.JSonFillter;
import controller.JsonApiGPT;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.KogptModel;

public class ChatController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField chatData;

    @FXML
    private ListView<String> listview = new ListView<>();

    @FXML
    private Button logout;

    @FXML
    private Button sendBtn;

    ArrayList<String> chatList = new ArrayList<>();

    @FXML
    void logoutEvent(ActionEvent event) {
        // LoginController에 있는 객체를 가져와서 해당 메서드를 변형시킨 함수를 실행합니다.
        LoginController controller = new LoginController();
        controller.loginSuccess(event, "login.fxml");
    }

    @FXML
    void sendDataEvent(ActionEvent event) {
        String message = chatData.getText();
        if (!message.isEmpty()) {
            // 채팅이 비어있지 않다면
            listview.setCellFactory(value -> new CustomListCeil<>());
            listview.getItems().add(message); // 채팅을 추가합니다.
            chatData.clear(); // 채팅의 내용을 지웁니다.
            KogptModel gptModel = new KogptModel();
            gptModel.setGPT(0.3, message);
            JSONObject data = new JSONObject();
            data.put("prompt", gptModel.getContent());
            data.put("max_tokens", 120);
            data.put("n", 1);

            String requestData = data.toJSONString();
            System.out.println(requestData);
            JSONObject response = JsonApiGPT.apiKoGPT(requestData);
            // json 파일을 매개변수로 해서 key:"text" 값에 있는 값을 String 값으로 가져옵니다.
            String textData = JSonFillter.jsonToString(response);
            listview.getItems().add(textData); // text 를 보내줍니다.
        }
    }

    @FXML
    void initialize() {
        assert chatData != null : "fx:id=\"chatData\" was not injected: check your FXML file 'chat.fxml'.";
        assert listview != null : "fx:id=\"listview\" was not injected: check your FXML file 'chat.fxml'.";
        assert logout != null : "fx:id=\"logout\" was not injected: check your FXML file 'chat.fxml'.";
        assert sendBtn != null : "fx:id=\"sendBtn\" was not injected: check your FXML file 'chat.fxml'.";
    }
}
