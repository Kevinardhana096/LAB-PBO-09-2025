import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class HomeScene {
    private VBox postContainer = new VBox(10);
    private List<Post> posts = new ArrayList<>();

    public Scene getScene(Stage stage, User user) {
        ImageView profilePic = new ImageView(user.getProfileImage());
        profilePic.setFitWidth(100);
        profilePic.setFitHeight(100);

        Label nameLabel = new Label(user.getFullName() + " (" + user.getNickName() + ")");
        Button addPostBtn = new Button("Add Post");
        addPostBtn.setOnAction(e -> {
            new UploadWindow().show(post -> {
                posts.add(post);
                postContainer.getChildren().add(createPostView(post));
            });
        });

        VBox root = new VBox(10, profilePic, nameLabel, addPostBtn, new Separator(), postContainer);
        root.setStyle("-fx-padding: 20;");
        return new Scene(root, 600, 600);
    }

    private StackPane createPostView(Post post) {
        ImageView imageView = new ImageView(post.getPostImage());
        imageView.setFitWidth(200);
        imageView.setFitHeight(200);

        Label captionLabel = new Label(post.getCaption());
        captionLabel.setStyle("-fx-background-color: rgba(0,0,0,0.6); -fx-text-fill: white; -fx-padding: 5;");
        captionLabel.setVisible(false);

        StackPane stack = new StackPane(imageView, captionLabel);
        stack.setOnMouseEntered(e -> captionLabel.setVisible(true));
        stack.setOnMouseExited(e -> captionLabel.setVisible(false));
        return stack;
    }
}
