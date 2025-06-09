package SnapGalery.scene;

import java.io.File;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import SnapGalery.model.User;

public class RegisterPage {

    private User registeredUser;

    public Scene getRegisterScene(Stage primaryStage, Runnable onRegisterComplete) {
        // Layout utama
        VBox root = new VBox(15);
        root.setPadding(new Insets(30));
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #fdf6f0;");

        // Judul
        Label title = new Label("Welcome to SnapGalery!");
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #5a4e7c;");

        // Input fields
        TextField nicknameField = new TextField();
        nicknameField.setPromptText("Nickname");

        TextField fullNameField = new TextField();
        fullNameField.setPromptText("Full Name");

        // Upload profile image
        Button uploadBtn = new Button("Choose Profile Image");
        ImageView profilePreview = new ImageView();
        profilePreview.setFitHeight(100);
        profilePreview.setFitWidth(100);
        profilePreview.setPreserveRatio(true);

        final Image[] profileImage = {null};

        uploadBtn.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select Profile Picture");
            fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
            );
            File file = fileChooser.showOpenDialog(primaryStage);
            if (file != null) {
                profileImage[0] = new Image(file.toURI().toString());
                profilePreview.setImage(profileImage[0]);
            }
        });

        // Submit button
        Button submitBtn = new Button("Submit");
        submitBtn.setStyle("-fx-background-color: #f4c2c2; -fx-font-weight: bold;");
        submitBtn.setOnMouseEntered(e -> submitBtn.setStyle("-fx-background-color: #f08b8b; -fx-font-weight: bold;"));
        submitBtn.setOnMouseExited(e -> submitBtn.setStyle("-fx-background-color: #f4c2c2; -fx-font-weight: bold;"));

        submitBtn.setOnAction(e -> {
            String nickname = nicknameField.getText();
            String fullName = fullNameField.getText();

            if (nickname.isEmpty() || fullName.isEmpty() || profileImage[0] == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill in all fields and upload a profile picture.");
                alert.showAndWait();
                return;
            }

            registeredUser = new User(nickname, fullName, profileImage[0]);
            onRegisterComplete.run(); // lanjut ke home
        });

        // Layout form
        VBox formBox = new VBox(10, nicknameField, fullNameField, uploadBtn, profilePreview, submitBtn);
        formBox.setAlignment(Pos.CENTER);

        root.getChildren().addAll(title, formBox);
        return new Scene(root, 400, 500);
    }

    public User getRegisteredUser() {
        return registeredUser;
    }
}

