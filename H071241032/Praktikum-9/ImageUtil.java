import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import java.io.File;

public class ImageUtil {
    public static Image chooseImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Image");
        fileChooser.getExtensionFilters().add(
            new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
        );
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            return new Image(file.toURI().toString());
        }
        return null;
    }
}
