package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Label textLabel = new Label();
        textLabel.setText("view file 안에 있는 상태");
        StackPane pane = new StackPane();
        pane.getChildren().add(textLabel);

        Scene scene = new Scene(pane, 500, 500);
        stage.show();
        stage.setTitle("KOGPT-GUI");
        stage.setScene(scene);
        stage.setResizable(false);

    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }

}
