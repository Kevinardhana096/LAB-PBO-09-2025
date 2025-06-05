import javafx.application.Application;
import javafx.stage.Stage;
public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        RegisterScene registerScene = new RegisterScene();
        primaryStage.setTitle("Photo Sharing App");
        primaryStage.setScene(registerScene.getScene(primaryStage, user -> {
            HomeScene homeScene = new HomeScene();
            primaryStage.setScene(homeScene.getScene(primaryStage, user));
        }));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
