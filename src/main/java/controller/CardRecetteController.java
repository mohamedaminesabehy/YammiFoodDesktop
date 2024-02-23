package controller;

import entite.Recette;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import services.RecetteService;

import java.io.File;

public class CardRecetteController {

    @FXML
    private Label TitreLabel;

    @FXML
    private Label descriptionLable;

    @FXML
    private ImageView img;

    @FXML
    void click(MouseEvent event) {
        // Handle the click event if needed
    }

    private RecetteService recetteService = new RecetteService();

    public void initialize() {
        displayRecetteData(26);
    }

    public void displayRecetteData(int recetteId) {
        Recette recette = recetteService.readById(recetteId);
        if (recette != null) {
            TitreLabel.setText("" + recette.getTitre());
            descriptionLable.setText("" + recette.getDescription());
            if (recette.getImage() != null) {
                // Modify the path to use a File object and convert it to URL
                String imagePath = recette.getImage();
                File file = new File(imagePath);

                try {
                    // Convert the File to URL
                    String imageUrl = file.toURI().toURL().toString();
                    // Now use this URL to create the Image
                    Image image = new Image(imageUrl);
                    img.setImage(image);
                } catch (Exception e) {
                    e.printStackTrace();  // Handle the exception according to your needs
                }
            }
        }
    }
}