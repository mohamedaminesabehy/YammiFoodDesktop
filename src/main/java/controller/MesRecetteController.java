package controller;

import entite.Recette;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import services.RecetteService;

import java.io.IOException;
import java.util.List;

public class MesRecetteController {

    @FXML
    private VBox chosenFruitCard;

    @FXML
    private GridPane grid;

    @FXML
    private Button id_ajouter;

    @FXML
    private ImageView id_imageee;

    @FXML
    private ImageView id_logo;

    @FXML
    private Button id_recette;

    @FXML
    private ScrollPane scroll;

    @FXML
    private Button id_delete;

    @FXML
    void AfficherRecette(ActionEvent event) {

    }
    @FXML
    void delete_recette(ActionEvent event) {

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
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/informationRecette.fxml"));
                Node cardRecetteNode = loader.load();

                InformationRecetteController cardController = loader.getController();
                cardController.displayRecetteData(recette.getId());

                // Set columnIndex to 0 for each recipe to place it in a new row
                columnIndex = 0;

                // Increment rowIndex for each new row
                rowIndex++;

                grid.add(cardRecetteNode, columnIndex, rowIndex);

            } catch (IOException e) {
                e.printStackTrace(); // Handle exception appropriately
            }
        }
    }}
