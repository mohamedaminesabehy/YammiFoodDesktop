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
                Image image = new Image(new ByteArrayInputStream(recette.getImage()));
                id_img.setImage(image);
            }

        }}

}

