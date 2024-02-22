package controller;

import entite.Recette;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import services.RecetteService;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.util.List;

public class ListeDesRecetteController {

    @FXML
    private GridPane grid;

    @FXML
    private ScrollPane scroll;
    @FXML
    void AfficherRecette(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/AjouterRecette.fxml"));
            grid.getScene().setRoot(root); // Assuming grid is a control from the current scene
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void AfficherMesRecettes(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/MesRecette.fxml"));
            grid.getScene().setRoot(root); // Assuming grid is a control from the current scene
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void initialize() {
        // Retrieve all recipes from the data source
        RecetteService recetteService = new RecetteService();
        List<Recette> allRecettes = recetteService.readAll();

        // Load and display each recipe in a CardRecette
        int columnIndex = 0;
        int rowIndex = 1;

        for (Recette recette : allRecettes) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/cardRecette.fxml"));
                Node cardRecetteNode = loader.load();

                CardRecetteController cardController = loader.getController();
                cardController.displayRecetteData(recette.getId());
                cardRecetteNode.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> handleCardClick(recette.getId()));
                columnIndex++;
                if (columnIndex == 3) { // Change this number according to your desired number of columns
                    columnIndex = 0;
                    ++rowIndex;
                }
                grid.add(cardRecetteNode, columnIndex, rowIndex);
                this.grid.setMinWidth(-1.0);
                this.grid.setPrefWidth(-1.0);
                this.grid.setMaxWidth(Double.NEGATIVE_INFINITY);
                this.grid.setMinHeight(-1.0);
                this.grid.setPrefHeight(-1.0);
                this.grid.setMaxHeight(Double.NEGATIVE_INFINITY);
                GridPane.setMargin(cardRecetteNode, new Insets(10.0));

            } catch (IOException e) {
                e.printStackTrace(); // Handle exception appropriately
            }

        }
    }

    private void handleCardClick(int recetteId) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/AfficherRecette.fxml"));
            Parent root = loader.load();

            AfficherRecetteController afficherRecetteController = loader.getController();
            afficherRecetteController.displayRecetteData(recetteId);

            grid.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace(); // Handle exception appropriately
        }
    }
}