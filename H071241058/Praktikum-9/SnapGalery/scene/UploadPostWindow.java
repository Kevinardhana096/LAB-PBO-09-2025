package SnapGalery.scene;

import java.io.File;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import SnapGalery.model.Post;

import java.io.File;
import java.util.function.Consumer;

public class UploadPostWindow {

    public void showUploadWindow(Stage owner, Consumer<Post> onPostUploaded) {
        Stage popup = new Stage();
        popup.initModality(Modality.APPLICATION_MODAL);
        popup.initOwner(owner);
        popup.setTitle("New Post");

        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #fff8f0;");

        // Upload image
        Button chooseImgBtn = new Button("Choose Image");
        ImageView preview = new ImageView();
        preview.setFitWidth(300);
        preview.setPreserveRatio(true);

        final Image[] postImage = {null};

        chooseImgBtn.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select Post Image");
            fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
            );
            File file = fileChooser.showOpenDialog(popup);
            if (file != null) {
                postImage[0] = new Image(file.toURI().toString());
                preview.setImage(postImage[0]);
            }
        });

        // Caption field
        TextArea captionArea = new TextArea();
        captionArea.setPromptText("Write a caption...");
        captionArea.setWrapText(true);
        captionArea.setMaxWidth(300);
        captionArea.setPrefRowCount(3);

        // Submit button
        Button submitBtn = new Button("Upload Post");
        submitBtn.setStyle("-fx-background-color: #ffd6d6; -fx-font-weight: bold;");
        submitBtn.setOnMouseEntered(e -> submitBtn.setStyle("-fx-background-color: #f3aaaa; -fx-font-weight: bold;"));
        submitBtn.setOnMouseExited(e -> submitBtn.setStyle("-fx-background-color: #ffd6d6; -fx-font-weight: bold;"));

        submitBtn.setOnAction(e -> {
            String caption = captionArea.getText();
            if (postImage[0] == null || caption.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please select an image and write a caption.");
                alert.showAndWait();
                return;
            }
            Post newPost = new Post(caption, postImage[0]);
            onPostUploaded.accept(newPost);
            popup.close();
        });

        root.getChildren().addAll(chooseImgBtn, preview, captionArea, submitBtn);

        Scene scene = new Scene(root, 350, 450);
        popup.setScene(scene);
        popup.showAndWait();
    }
}
