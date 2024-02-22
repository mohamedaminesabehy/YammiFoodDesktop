package org.example;

import entite.Avis;
import entite.Recette;
import services.AvisService;
import services.PdfExporter;
import services.RecetteService;
import utils.DataSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //test de connection
        // DataSource ds1 = DataSource.getInstance();
        // System.out.println(ds1);

        RecetteService recetteService = new RecetteService();
        Recette recette = new Recette();
/*
        String imagePath = "C:\\Users\\asus\\OneDrive\\Bureau\\rev\\restaurant\\src\\main\\java\\image\\recipe-image.jpg";
        String videoPath = "C:\\Users\\asus\\OneDrive\\Bureau\\rev\\restaurant\\src\\main\\java\\image\\Cheesefacile.mp4";

        try {
            byte[] imageBytes = readImageBytes(imagePath);
            byte[] videoBytes = readVideoBytes(videoPath);
            Recette recipe = new Recette();
            recipe.setTitre("Pasta Carbonara");
            recipe.setDescription("Classic Italian pasta dish with eggs, cheese, and pancetta");
            recipe.setIngredients("Spaghetti, eggs, Parmesan cheese, pancetta");
            recipe.setEtape("Cook pancetta, mix eggs and cheese, combine with cooked spaghetti");
            recipe.setId_user(1);
            recipe.setImage(imageBytes);
            recipe.setVideo(videoBytes);
            recetteService.add(recipe);

            System.out.println("Recipe added successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }

*/
        /*
        Recette recetteToDelete = new Recette();
        recetteToDelete.setId(6);
        recetteService.delete(recetteToDelete);
        */

        /*
        Recette recetteUpdate = new Recette();
        recetteUpdate.setId(1);
        recetteUpdate.setTitre("Updated Spaghetti Carbonara");
        recetteUpdate.setDescription("Updated description");
        recetteService.update(recetteUpdate);
       */


        System.out.println("List of Recipes:");
        List<Recette> recipes = recetteService.readAll();
        for (Recette recipe : recipes) {
        System.out.println(recipe);
        }


        /*
          Recette recetteById = recetteService.readById(3);
          if (recetteById != null) {
          System.out.println("Recette with ID 3: " + recetteById);
          } else {
          System.out.println("Recette with ID 3 not found");
          }
        */

         /*
        // imprimé
        List<Recette> recettes = recetteService.readAll();
        PdfExporter pdfExporter = new PdfExporter();
        pdfExporter.exportToPdf(recettes, "recette.pdf",13);
          */

        AvisService serviceAvis = new AvisService();
        /*
        Avis nouvelAvis = new Avis();
        nouvelAvis.setNote(5);
        nouvelAvis.setCommentaire("délicieux !");
        nouvelAvis.setIdUser(1);
        nouvelAvis.setIdRecette(1);
        serviceAvis.add(nouvelAvis);
        */


        /*
        List<Avis> listeAvis = serviceAvis.readAll();
        for (Avis avis : listeAvis) {
            System.out.println(avis);
        }
         */

        /*
        Avis AvisToDelete = new Avis();
        AvisToDelete.setIdAvis(1);
        serviceAvis.delete(AvisToDelete);
         */


        /*
        Avis avisById = serviceAvis.readById(2);
        if (avisById != null) {
            System.out.println("Avis with ID 2: " + avisById);
        } else {
            System.out.println("Avis with ID 2 not found");
        }
      */
    }

    private static byte[] readImageBytes(String imagePath) throws IOException {
        Path path = Paths.get(imagePath);
        return Files.readAllBytes(path);
    }
    private static byte[] readVideoBytes(String videoPath) throws IOException {
        Path path = Paths.get(videoPath);
        byte[] videoBytes = Files.readAllBytes(path);
        return videoBytes;
    }
}
