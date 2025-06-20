package week9;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class App extends Application {
    private TextField nicknameTextField = new TextField();
    private TextField fullnameTextField = new TextField();
    public User user;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("My Moment");
        showInputUserAccount(primaryStage);
        primaryStage.show();
    }

    private void showInputUserAccount(Stage stage) {
        Label label = new Label("Input User Account");
        label.setStyle("-fx-font-weight: bold;");

        ImageView profileImage = new ImageView();
        profileImage.setFitHeight(100);
        profileImage.setFitWidth(100);

        Circle clip = new Circle(50, 50, 50);
        profileImage.setClip(clip);

        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(10);
        dropShadow.setOffsetX(3);
        dropShadow.setOffsetY(3);
        dropShadow.setColor(Color.rgb(0, 0, 0, 0.5));
        profileImage.setEffect(dropShadow);

        Label nicknameLabel = new Label("NickName");
        nicknameTextField.setPromptText("Insert nickname here . . .");
        nicknameTextField.setMaxWidth(300);

        Label fullnameLabel = new Label("FullName");
        fullnameTextField.setPromptText("Insert fullname here . . .");
        fullnameTextField.setMaxWidth(300);

        Button uploadFotoProfilButton = new Button("Upload profile picture");
        uploadFotoProfilButton.setOnAction(e -> {
            File file = chooseFile(stage);
            if (file != null) {
                Image image = new Image(file.toURI().toString());
                profileImage.setImage(image);
            }
        });

        Button submitButton = new Button("Submit");

        submitButton.setOnAction(event -> {
            if (nicknameTextField.getText().isEmpty() || fullnameTextField.getText().isEmpty()) {
                showError("Nickname or Fullname cant be empty");
            } else {
                this.user = new User(nicknameTextField.getText(), fullnameTextField.getText(), profileImage);
                showProfileScene(stage);
            }
        });

        VBox root = new VBox(15);
        root.setAlignment(Pos.TOP_CENTER);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(
                label,
                nicknameLabel,
                nicknameTextField,
                fullnameLabel,
                fullnameTextField,
                uploadFotoProfilButton,
                profileImage,
                submitButton);

        Scene scene = new Scene(root, 500, 600);
        stage.setScene(scene);
    }

    private void showProfileScene(Stage stage) {
        // Header: Profil pengguna
        Label nickNameLabel = new Label(user.nickName);
        nickNameLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        Label fullNameLabel = new Label(user.fullName);
        Button addPostButton = new Button("Add Post");
        addPostButton.setOnAction(event -> {
            showAddPostScene(stage);
        });

        VBox nameBox = new VBox(10, nickNameLabel, fullNameLabel, addPostButton);
        nameBox.setAlignment(Pos.CENTER);

        HBox heroBox = new HBox(10, user.profileImage, nameBox);
        heroBox.setAlignment(Pos.CENTER);

        // GridPane untuk menampilkan postingan dalam grid 3 kolom
        GridPane postGrid = new GridPane();
        postGrid.setHgap(10);
        postGrid.setVgap(10);
        postGrid.setPadding(new Insets(10));

        // Mengatur lebar kolom agar merata (3 kolom)
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(33.33);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(33.33);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPercentWidth(33.33);
        postGrid.getColumnConstraints().addAll(col1, col2, col3);

        // Looping untuk menambahkan postingan ke GridPane
        int row = 0;
        int col = 0;
        for (Post post : user.posts) {
            // Membuat VBox untuk setiap post (gambar + caption)
            ImageView postImage = new ImageView(post.postImage.getImage());
            postImage.setFitHeight(100);
            postImage.setFitWidth(100);
            postImage.setPreserveRatio(true);

            Label captionLabel = new Label(post.caption);
            captionLabel.setWrapText(true); // Membungkus teks jika terlalu panjang
            captionLabel.setMaxWidth(100); // Membatasi lebar caption

            VBox postBox = new VBox(5, postImage, captionLabel);
            postBox.setAlignment(Pos.CENTER);

            // Menambahkan postBox ke GridPane
            postGrid.add(postBox, col, row);
            GridPane.setHalignment(postBox, HPos.CENTER);

            // Update kolom dan baris
            col++;
            if (col > 2) { // Pindah ke baris berikutnya setelah 3 kolom
                col = 0;
                row++;
            }
        }

        // Membungkus GridPane dalam ScrollPane
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(postGrid);
        scrollPane.setFitToWidth(true); // Grid menyesuaikan lebar ScrollPane
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED); // Bilah gulir vertikal jika perlu
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER); // Tanpa bilah gulir horizontal

        // Menambahkan heroBox dan scrollPane ke root
        VBox root = new VBox(15, heroBox, scrollPane);
        root.setAlignment(Pos.TOP_CENTER);
        root.setPadding(new Insets(20));

        Scene scene = new Scene(root, 500, 600);
        stage.setScene(scene);
    }

    private void showAddPostScene(Stage stage) {
        ImageView postImage = new ImageView();
        postImage.setFitHeight(100);
        postImage.setFitWidth(100);

        Button uploadImageButton = new Button("Upload Image");
        uploadImageButton.setOnAction(e -> {
            File file = chooseFile(stage);
            if (file != null) {
                Image image = new Image(file.toURI().toString());
                postImage.setImage(image);
            }
        });

        Label label = new Label("Caption");
        TextField captionTextField = new TextField();
        captionTextField.setPromptText("Masukkan caption . . .");

        Button submitButton = new Button("Submit");
        submitButton.setOnAction(event -> {
            if (postImage.getImage() == null) { // Perbaikan: Cek null dengan benar
                showError("Please select an image");
            } else if (captionTextField.getText().isEmpty()) {
                showError("Caption cannot be empty");
            } else {
                Post post = new Post(captionTextField.getText(), postImage);
                user.addPost(post);
                showProfileScene(stage);
            }
        });

        VBox box = new VBox(15, uploadImageButton, postImage, label, captionTextField, submitButton);
        box.setAlignment(Pos.TOP_CENTER);
        box.setPadding(new Insets(20));

        Scene scene = new Scene(box, 500, 600);
        stage.setScene(scene);
    }

    private File chooseFile(Stage primaryStage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Pilih Foto Profil");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "Gambar (*.jpg, *.png, *.jpeg)", "*.jpg", "*.png", "*.jpeg");
        fileChooser.getExtensionFilters().add(extFilter);
        return fileChooser.showOpenDialog(primaryStage);
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}