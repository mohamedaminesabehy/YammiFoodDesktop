package controller;

import entite.Recette;
import entite.User;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaView;
import services.PdfExporter;
import services.RecetteService;

import java.io.ByteArrayInputStream;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import javafx.event.ActionEvent;

import java.util.List;

public class AfficherRecetteController {

    @FXML
    private Label titleLabel;

    @FXML
    private Label descriptionLabel;

    @FXML
    private Label ingredientsLabel;

    @FXML
    private Label stepsLabel;

    @FXML
    private Label usernameLabel;

    @FXML
    private ImageView imageView;

    @FXML
    private MediaView videoView;
    @FXML
    private Button printButton;
    @FXML
    private ImageView image1;

    @FXML
    private ImageView imageview1;

    @FXML
    void handlePrintButtonClick(ActionEvent event) {
        pdfExporter.exportToPdf(recettes, outputPath, targetRecipeId);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText("Merci pour l'impression");
        alert.showAndWait();
    }
    private RecetteService recetteService = new RecetteService();
    private PdfExporter pdfExporter = new PdfExporter();
    List<Recette> recettes = recetteService.readAll();
    private String outputPath = "recette.pdf";
    private int targetRecipeId = 13;


    public void initialize() {
        displayRecetteData(20);
        printButton.setOnAction(this::handlePrintButtonClick);


    }


    public void displayRecetteData(int recetteId) {

        Recette recette = recetteService.readById(recetteId);

        if (recette != null) {
            titleLabel.setText("" + recette.getTitre());
            descriptionLabel.setText("" + recette.getDescription());
            ingredientsLabel.setText("" + recette.getIngredients());
            stepsLabel.setText("" + recette.getEtape());

            if (recette.getImage() != null) {
                Image image = new Image(new ByteArrayInputStream(recette.getImage()));
                imageView.setImage(image);
            }

            if (recette.getVideo() != null) {
                try {
                    File tempFile = File.createTempFile("video", ".mp4"); // Change extension as needed
                    Files.write(tempFile.toPath(), recette.getVideo());

                    Media videoMedia = new Media(tempFile.toURI().toString());
                    MediaPlayer mediaPlayer = new MediaPlayer(videoMedia);
                    videoView.setMediaPlayer(mediaPlayer);
                    mediaPlayer.play();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
