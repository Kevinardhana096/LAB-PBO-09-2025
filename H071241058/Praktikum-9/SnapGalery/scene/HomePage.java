package SnapGalery.scene;
import javafx.scene.shape.Circle;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import SnapGalery.model.Post;
import SnapGalery.model.User;

import java.util.ArrayList;

public class HomePage {

    private final ArrayList<Post> postList = new ArrayList<>();
    private final VBox postContainer = new VBox(15); // tempat menampilkan post

    public Scene getHomeScene(Stage primaryStage, User user) {
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(20));
        root.setStyle("-fx-background-color: #fdfaf5;");

        // ================= HEADER =================
        HBox header = new HBox(15);
        header.setAlignment(Pos.CENTER_LEFT);

        ImageView profileImg = new ImageView(user.getProfileImage());
        profileImg.setFitHeight(60);
        profileImg.setFitWidth(60);
        profileImg.setClip(new Circle(30, 30, 30)); // tampilan bulat

        VBox userInfo = new VBox(
                new Label("@" + user.getNickName()),
                new Label(user.getFullName())
        );
        userInfo.setStyle("-fx-font-size: 14px; -fx-text-fill: #333;");

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Button addPostBtn = new Button("Add Post");
        addPostBtn.setStyle("-fx-background-color: #b8e0d2; -fx-font-weight: bold;");
        addPostBtn.setOnMouseEntered(e -> addPostBtn.setStyle("-fx-background-color: #90cfc1; -fx-font-weight: bold;"));
        addPostBtn.setOnMouseExited(e -> addPostBtn.setStyle("-fx-background-color: #b8e0d2; -fx-font-weight: bold;"));

        header.getChildren().addAll(profileImg, userInfo, spacer, addPostBtn);
        root.setTop(header);

        // ================= POST AREA =================
        ScrollPane scrollPane = new ScrollPane(postContainer);
        scrollPane.setFitToWidth(true);
        postContainer.setPadding(new Insets(20, 0, 0, 0));
        root.setCenter(scrollPane);

        // ================= ADD POST ACTION =================
        addPostBtn.setOnAction(e -> {
            UploadPostWindow upload = new UploadPostWindow();
            upload.showUploadWindow(primaryStage, (post) -> {
                postList.add(0, post); // tambah ke atas
                updatePostView();
            });
        });

        return new Scene(root, 600, 600);
    }

    private void updatePostView() {
        postContainer.getChildren().clear();
        for (Post post : postList) {
            VBox card = new VBox(5);
            card.setPadding(new Insets(10));
            card.setStyle("-fx-background-color: white; -fx-background-radius: 10; -fx-effect: dropshadow(gaussian, gray, 5, 0.3, 0, 2);");

            ImageView imageView = new ImageView(post.getPostImage());
            imageView.setFitWidth(400);
            imageView.setPreserveRatio(true);

            Label caption = new Label(post.getCaption());
            caption.setWrapText(true);
            caption.setStyle("-fx-text-fill: #555; -fx-font-size: 13px;");

            card.getChildren().addAll(imageView, caption);
            postContainer.getChildren().add(card);
        }
    }
}
