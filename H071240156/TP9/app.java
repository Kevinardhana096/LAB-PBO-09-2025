import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;

public class app extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Photo Register App");
        Scene registerScene = RegisterScene.createRegisterScene(stage, user -> {
            Scene home = HomeScene.createHomeScene(stage, user);
            home.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
            stage.setScene(home);
        });
        registerScene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(registerScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class User {
    private String nickName;
    private String fullName;
    private String profileImagePath;

    public User(String nickName, String fullName, String profileImagePath) {
        this.nickName = nickName;
        this.fullName = fullName;
        this.profileImagePath = profileImagePath;
    }

    public String getNickName() {
        return nickName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getProfileImagePath() {
        return profileImagePath;
    }
}

class Post {
    private String caption;
    private String postImagePath;

    public Post(String caption, String postImagePath) {
        this.caption = caption;
        this.postImagePath = postImagePath;
    }

    public String getCaption() {
        return caption;
    }

    public String getPostImagePath() {
        return postImagePath;
    }
}

class RegisterScene {

    public static Scene createRegisterScene(Stage stage, Callback callback) {
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));

        TextField nickNameField = new TextField();
        TextField fullNameField = new TextField();
        Button uploadBtn = new Button("Upload Profile Image");
        Button registerBtn = new Button("Register");
        ImageView imageView = new ImageView();
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        imageView.setPreserveRatio(true);
        final String[] profileImagePath = new String[1];

        uploadBtn.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(stage);
            if (file != null) {
                profileImagePath[0] = file.toURI().toString();
                Image image = new Image(profileImagePath[0]);

                imageView.setImage(image);
                imageView.setFitWidth(100);
                imageView.setFitHeight(100);
                imageView.setPreserveRatio(false); // ini penting agar bisa mengisi area bulat

                // Bikin klip lingkaran di tengah-tengah imageView
                Circle clip = new Circle(50, 50, 50); // x=50, y=50, radius=50
                imageView.setClip(clip);

            }
        });

        registerBtn.setOnAction(e -> {
            if (nickNameField.getText().isEmpty() || fullNameField.getText().isEmpty() || profileImagePath[0] == null) {
                new Alert(Alert.AlertType.ERROR, "Isi semua field").show();
            } else {
                User user = new User(nickNameField.getText(), fullNameField.getText(), profileImagePath[0]);
                callback.onRegister(user);
            }
        });

        layout.getChildren().addAll(
                new Label("Nickname:"), nickNameField,
                new Label("Fullname:"), fullNameField,
                uploadBtn, imageView, registerBtn);

        return new Scene(layout, 300, 400);
    }

    public interface Callback {
        void onRegister(User user);
    }
}

class HomeScene {

    private static final ArrayList<Post> posts = new ArrayList<>();

    public static Scene createHomeScene(Stage stage, User user) {
        VBox layout = new VBox(15);
        layout.setPadding(new Insets(20));

        // Nickname di tengah atas
        Label nickLabel = new Label(user.getNickName());
        nickLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        HBox nickBox = new HBox(nickLabel);
        nickBox.setStyle("-fx-alignment: center;");

        // Grid layout
        GridPane postGrid = new GridPane();
        postGrid.setHgap(10);
        postGrid.setVgap(10);
        postGrid.setPadding(new Insets(10));

        // Horizontal box untuk Foto Profile, Fullname, dan Add Post
        ImageView profileImg = new ImageView(new Image(user.getProfileImagePath(), 80, 80, true, true));
        Circle clip = new Circle(40, 40, 40);
        Label fullLabel = new Label(user.getFullName());
        fullLabel.setStyle("-fx-font-size: 14px;");

        Button addPostBtn = new Button("Add Post");
        addPostBtn.setOnAction(e -> {
            openAddPostWindow(stage, postGrid);
        });

        HBox infoBox = new HBox(20, profileImg, fullLabel, addPostBtn);
        infoBox.setStyle("-fx-alignment: center_left;");

        ScrollPane scrollPane = new ScrollPane(postGrid);
        scrollPane.setFitToWidth(true);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        layout.getChildren().addAll(nickBox, infoBox, scrollPane);
        return new Scene(layout, 500, 600);
    }

    private static void openAddPostWindow(Stage parent, GridPane postGrid) {
        Stage stage = new Stage();
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));

        TextField captionField = new TextField();
        Button uploadBtn = new Button("Upload Image");
        Button saveBtn = new Button("Save");
        final String[] postImagePath = new String[1];

        uploadBtn.setOnAction(e -> {
            FileChooser fc = new FileChooser();
            File file = fc.showOpenDialog(parent);
            if (file != null) {
                postImagePath[0] = file.toURI().toString();
            }
        });

        saveBtn.setOnAction(e -> {
            if (captionField.getText().isEmpty() || postImagePath[0] == null) {
                new Alert(Alert.AlertType.ERROR, "Isi semua field").show();
            } else {
                Post post = new Post(captionField.getText(), postImagePath[0]);
                posts.add(post);
                updatePostsDisplay(postGrid);
                stage.close();
            }
        });

        layout.getChildren().addAll(
                new Label("Caption:"), captionField, uploadBtn, saveBtn);

        stage.setScene(new Scene(layout, 300, 200));
        stage.setTitle("Add Post");
        stage.show();
    }

    private static void updatePostsDisplay(GridPane postGrid) {
        postGrid.getChildren().clear();
        for (int i = 0; i < posts.size(); i++) {
            Post p = posts.get(i);
            VBox postPane = new VBox(5);
            ImageView img = new ImageView(new Image(p.getPostImagePath(), 150, 150, true, true));
            Label caption = new Label(p.getCaption());
            caption.setVisible(false);

            img.setOnMouseEntered(e -> caption.setVisible(true));
            img.setOnMouseExited(e -> caption.setVisible(false));

            postPane.getChildren().addAll(img, caption);

            int col = i % 3;
            int row = i / 3;
            postGrid.add(postPane, col, row);
        }
    }
}
