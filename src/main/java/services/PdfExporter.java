package services;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import entite.Recette;

import java.io.FileOutputStream;
import java.util.List;
public class PdfExporter {

    public void exportToPdf(List<Recette> recipes, String outputPath, int targetRecipeId) {
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(outputPath));
            document.open();

            // Adding recipes to the PDF
            for (Recette recipe : recipes) {
                if (recipe.getId() == targetRecipeId) {
                    document.add(new Paragraph("Title: " + recipe.getTitre()));
                    document.add(new Paragraph("Description: " + recipe.getDescription()));
                    document.add(new Paragraph("Ingredients: " + recipe.getIngredients()));
                    document.add(new Paragraph("Steps: " + recipe.getEtape()));
                    if (recipe.getImage() != null) {
                        Image img = Image.getInstance(recipe.getImage());
                        document.add(img);
                    }

                    document.add(new Paragraph("----------------------------------------------"));
                    break;  // Stop after exporting the desired recipe
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }
}
