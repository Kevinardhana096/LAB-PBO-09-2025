package SnapGalery;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import SnapGalery.model.User;
import SnapGalery.scene.HomePage;
import SnapGalery.scene.RegisterPage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("SnapGalery");

        RegisterPage registerPage = new RegisterPage();
        HomePage homePage = new HomePage();

        // Mulai dari halaman register
        Scene registerScene = registerPage.getRegisterScene(primaryStage, () -> {
            // Saat user selesai register
            User user = registerPage.getRegisteredUser();
            Scene homeScene = homePage.getHomeScene(primaryStage, user);
            primaryStage.setScene(homeScene);
        });

        primaryStage.setScene(registerScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
