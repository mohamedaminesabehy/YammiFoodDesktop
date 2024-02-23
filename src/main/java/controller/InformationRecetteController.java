package controller;

import entite.Recette;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import services.RecetteService;

import java.awt.event.ActionEvent;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

public class InformationRecetteController {

    @FXML
    private ImageView id_img;

    @FXML
    private Label id_titre;


    private RecetteService recetteService = new RecetteService();

    public void initialize() {
        displayRecetteData(13);
    }


    public void displayRecetteData(int recetteId) {

        Recette recette = recetteService.readById(recetteId);
        if (recette != null) {
            id_titre.setText("" + recette.getTitre());
            if (recette.getImage() != null) {
                // Modify the path to use a File object and convert it to URL
                String imagePath = recette.getImage();
                File file = new File(imagePath);

                try {
                    // Convert the File to URL
                    String imageUrl = file.toURI().toURL().toString();
                    // Now use this URL to create the Image
                    Image image = new Image(imageUrl);
                    id_img.setImage(image);
                } catch (Exception e) {
                    e.printStackTrace();  // Handle the exception according to your needs
                }
            }

        }}
}

