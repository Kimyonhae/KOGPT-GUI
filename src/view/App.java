package view;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        // 크기를 구하는 class
        Rectangle2D visibleBound = Screen.getPrimary().getVisualBounds();
        double deskTopWidth = visibleBound.getMaxX() - 500; // window or mac 의 창 너비 - 500
        double deskTopHeight = visibleBound.getMaxY() - 200; // window or mac 의 창 높이 - 200

        // label Node
        Label textLabel = new Label();
        textLabel.setText("view file 안에 있는 상태");

        // image Node
        Image gptImage = new Image("file:image/kogpt-image.png");
        ImageView imgviewr = new ImageView();
        imgviewr.setImage(gptImage); // ImageView class 에 image를 넣어줍니다.

        // pane Container
        StackPane pane = new StackPane();
        pane.getChildren().add(textLabel); // label 을 Container와 연결.
        pane.getChildren().add(imgviewr); // imgviewr 을 Container와 연결.

        // Scene
        Scene scene = new Scene(pane, deskTopWidth, deskTopHeight);
        stage.show();
        stage.setTitle("KOGPT-GUI");
        stage.setScene(scene);
        stage.setResizable(false);
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }

}
