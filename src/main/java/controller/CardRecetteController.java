package controller;

import entite.Recette;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import services.RecetteService;

import java.io.ByteArrayInputStream;


public class CardRecetteController {

    @FXML
    private Label TitreLabel;

    @FXML
    private Label descriptionLable;

    @FXML
    private ImageView img;

    @FXML
    void click(MouseEvent event) {

    }
    private RecetteService recetteService = new RecetteService();
    public void initialize() {
        displayRecetteData(13);
    }


    public void displayRecetteData(int recetteId) {

        Recette recette = recetteService.readById(recetteId);
        if (recette != null) {
            TitreLabel.setText("" + recette.getTitre());
            descriptionLable.setText("" + recette.getDescription());
            if (recette.getImage() != null) {
                Image image = new Image(new ByteArrayInputStream(recette.getImage()));
                img.setImage(image);
            }

}}}




