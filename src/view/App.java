package view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        // 크기를 구하는 class
        AppRatio ratio = new AppRatio();
        ratio.setRatio(); // 높이와 너비를 초기화 합니다.

        // image Node
        Image gptImage = new Image("file:image/kogpt-image.png"); // image 경로를 알려주는 것
        ImageView imgviewr = new ImageView();
        imgviewr.setImage(gptImage); // ImageView class 에 image를 넣어줍니다.

        // label , textFeild, passwordFeild, button Node
        Label userLabel = new Label("userId : ");
        TextField userId = new TextField(); // userId Node
        Label passwordLabel = new Label("password : ");
        PasswordField password = new PasswordField(); // password Node
        Button loginBtn = new Button("Log in");
        Button registerBtn = new Button("Register in");
        // error message
        final Text errorMessage = new Text();
        errorMessage.setFill(Color.RED); // default color = red
        errorMessage.setFont(new Font("Arial", 14)); // font size and font style

        // pane Container
        GridPane gridPane = new GridPane();
        gridPane.addRow(0, new Label(" ")); // 공백 추가
        gridPane.addRow(1, userLabel, userId);
        gridPane.addRow(2, passwordLabel, password);
        gridPane.addRow(3, loginBtn, registerBtn);
        gridPane.addRow(4, errorMessage);
        gridPane.setHgap(20); // 높이 차이
        gridPane.setVgap(20); // 너비 차이
        gridPane.setPadding(new Insets(100, 25, 25, 25));
        gridPane.setAlignment(Pos.CENTER);
        ColumnConstraints limit = new ColumnConstraints();
        limit.setPrefWidth(100); // 너비를 저장합니다.
        gridPane.getColumnConstraints().add(limit);

        // login button click Event
        loginBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                // login logic
                if (userId.getText().isEmpty() || password.getText().isEmpty()) {
                    errorMessage.setText("userId 또는 password가 비어있습니다.");
                    return;
                }
                if (userId.getText().length() < 3 || password.getText().length() < 5) {
                    errorMessage.setText("userId는 최소 3개의 문자 | password는 최소 5개의 문자 입니다.");
                    return;
                }
                if (userId.getText().equals(password.getText())) {
                    errorMessage.setText("userId 와 password는 같으면 안됩니다.");
                    return;
                }
                // login success
                errorMessage.setFill(Color.GREEN);
                errorMessage.setText("로그인 버튼이 눌렸습니다!");
            }
        });
        // register button click Event
        registerBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                // 회원가입 gui 로 이동합니다.
            }
        });

        // Stack pane
        StackPane stackPane = new StackPane(); // stackPane은 다른 노드들을 중첩해서 나타냅니다.
        stackPane.getChildren().addAll(imgviewr, gridPane);
        stackPane.setAlignment(Pos.TOP_CENTER); // img는 상단 가운데 정렬

        // 배경색/ 지정
        stackPane.setBackground(
                new Background(new BackgroundFill(Color.web("#50586C"), CornerRadii.EMPTY, Insets.EMPTY)));

        // Scene
        Scene scene = new Scene(stackPane, ratio.deskTopWidth, ratio.deskTopHeight);
        stage.show();
        stage.setTitle("KOGPT-GUI"); // window OR mac title
        stage.setScene(scene);
        stage.setResizable(false); // size를 바꿀수 없습니다.
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
