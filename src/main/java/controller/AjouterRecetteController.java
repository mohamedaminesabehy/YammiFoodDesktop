package controller;

import entite.Recette;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import services.RecetteService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;

public class AjouterRecetteController {

    @FXML
    private TextField titreField;

    @FXML
    private TextField descriptionField;

    @FXML
    private TextField ingredientsField;

    @FXML
    private TextField etapeField;

    @FXML
    private Label selectedImagePathLabel;

    @FXML
    private Label selectedVideoPathLabel;

    @FXML
    private void browseImage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image File");
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            selectedImagePathLabel.setText(selectedFile.getAbsolutePath());
        }
    }

    @FXML
    private void browseVideo(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Video File");
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            selectedVideoPathLabel.setText(selectedFile.getAbsolutePath());
        }
    }

    @FXML
    private void ajouterRecette(ActionEvent event) {
        try {
            // Get data from UI fields
            String titre = titreField.getText();
            String description = descriptionField.getText();
            String ingredients = ingredientsField.getText();
            String etape = etapeField.getText();
            String imagePath = selectedImagePathLabel.getText();
            String videoPath = selectedVideoPathLabel.getText();

            // Validate required fields
            if (titre.isEmpty() || description.isEmpty() || ingredients.isEmpty() || etape.isEmpty()) {
                // Display an alert or handle validation error as needed
                System.out.println("Please fill in all required fields.");
                return;
            }

            // Create a Recette object with the data
            Recette recette = new Recette();
            recette.setTitre(titre);
            recette.setDescription(description);
            recette.setIngredients(ingredients);
            recette.setEtape(etape);

            // Add logic to handle image and video byte arrays based on file paths
            // For simplicity, let's assume you have methods getImageBytes and getVideoBytes for conversion
            // You may need to handle exceptions and implement these methods based on your requirements


            recette.setImage(imagePath);
            recette.setVideo(videoPath);
            recette.setId_user(1);

            // Assuming you have an instance of RecetteService
            RecetteService recetteService = new RecetteService();
            recetteService.add(recette);

            // Optionally, you can display a success message or reset the form
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("Recette est ajouter");
            alert.showAndWait();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("erreur");
            alert.setContentText("Veuillez compléter tous les champs, s'il vous plaît");
            alert.showAndWait();
        }
    }



}