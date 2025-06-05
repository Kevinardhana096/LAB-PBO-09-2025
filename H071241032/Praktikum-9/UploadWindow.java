import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.*;

import java.util.function.Consumer;

public class UploadWindow {
    public void show(Consumer<Post> onPostCreated) {
        Stage window = new Stage();
        window.setTitle("Upload Post");

        TextField captionField = new TextField();
        ImageView imageView = new ImageView();
        imageView.setFitHeight(150);
        imageView.setFitWidth(150);
        Image[] selectedImage = new Image[1];

        Button uploadBtn = new Button("Choose Image");
        uploadBtn.setOnAction(e -> {
            selectedImage[0] = ImageUtil.chooseImage();
            if (selectedImage[0] != null) {
                imageView.setImage(selectedImage[0]);
            }
        });

        Button postBtn = new Button("Post");
        postBtn.setOnAction(e -> {
            if (selectedImage[0] != null && !captionField.getText().isEmpty()) {
                onPostCreated.accept(new Post(captionField.getText(), selectedImage[0]));
                window.close();
            }
        });

        VBox root = new VBox(10, new Label("Caption:"), captionField, uploadBtn, imageView, postBtn);
        root.setStyle("-fx-padding: 20;");
        window.setScene(new Scene(root, 300, 400));
        window.initModality(Modality.APPLICATION_MODAL);
        window.showAndWait();
    }
}
