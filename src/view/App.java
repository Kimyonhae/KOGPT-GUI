package view;

import javafx.application.Application;
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
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        // 크기를 구하는 class
        AppRatio ratio = new AppRatio();
        ratio.setRatio(); // 높이와 너비를 초기화 합니다.

        // image Node
        Image gptImage = new Image("file:image/kogpt-image.png");
        ImageView imgviewr = new ImageView();
        imgviewr.setImage(gptImage); // ImageView class 에 image를 넣어줍니다.
        imgviewr.setLayoutX(ratio.deskTopWidth / 4); // GPT iamge x좌표 설정.
        imgviewr.setLayoutY(-30); // GPT iamge y좌표 설정.

        // label , textFeild, passwordFeild, button Node
        Label userLabel = new Label("userId : ");
        TextField userId = new TextField(); // userId Node
        Label passwordLabel = new Label("password : ");
        PasswordField password = new PasswordField(); // password Node
        Button loginBtn = new Button("Log in");
        Button registerBtn = new Button("Register in");

        // pane Container
        GridPane gridPane = new GridPane();
        gridPane.addRow(0, new Label(" ")); // 공백 추가
        gridPane.addRow(1, userLabel, userId);
        gridPane.addRow(2, passwordLabel, password);
        gridPane.addRow(3, loginBtn, registerBtn);
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setAlignment(Pos.CENTER);

        // Stack pane
        StackPane stackPane = new StackPane(); // stackPane은 다른 노드들을 중첩해서 나타냅니다.
        stackPane.getChildren().add(gridPane);
        stackPane.getChildren().add(imgviewr);
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
