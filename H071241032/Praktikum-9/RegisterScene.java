import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;


public class RegisterScene {
    private TextField nickNameField, fullNameField;
    private ImageView profileView;
    private Image selectedImage;

    public Scene getScene(javafx.stage.Stage stage, java.util.function.Consumer<User> onRegister) {
        nickNameField = new TextField();
        fullNameField = new TextField();
        profileView = new ImageView();
        profileView.setFitHeight(100);
        profileView.setFitWidth(100);

        Button uploadBtn = new Button("Upload Profile Image");
        uploadBtn.setOnAction(e -> {
            selectedImage = ImageUtil.chooseImage();
            if (selectedImage != null) {
                profileView.setImage(selectedImage);
            }
        });

        Button registerBtn = new Button("Register");
        registerBtn.setOnAction(e -> {
            User user = new User(nickNameField.getText(), fullNameField.getText(), selectedImage);
            onRegister.accept(user);
        });

        VBox root = new VBox(10, new Label("Nickname:"), nickNameField,
                                  new Label("Full Name:"), fullNameField,
                                  uploadBtn, profileView, registerBtn);
        root.setStyle("-fx-padding: 20;");
        return new Scene(root, 400, 400);
    }
}
