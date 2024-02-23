package services;

import entite.Recette;
import utils.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecetteService implements IService<Recette>{
    private Connection connexion;
    private Statement ste;
    private PreparedStatement pst;

    public RecetteService() {
        connexion = DataSource.getInstance().getCnx();
    }

    @Override
    public void add(Recette recette) {
        String requete = "INSERT INTO recette (titre, description, ingredients, etape, image, video, id_user) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            pst = connexion.prepareStatement(requete);
            pst.setString(1, recette.getTitre());
            pst.setString(2, recette.getDescription());
            pst.setString(3, recette.getIngredients());
            pst.setString(4, recette.getEtape());
            pst.setString(5, recette.getImage());
            pst.setString(6, recette.getVideo());
            pst.setInt(7, recette.getId_user());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Recette recette) {
        String requete = "DELETE FROM recette WHERE id = ?";

        try {
            pst = connexion.prepareStatement(requete);
            pst.setInt(1, recette.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Recette recette) {
        String requete = "UPDATE recette SET titre = ?, description = ?, ingredients = ?, etape = ?, " +
                "image = ?, video = ? WHERE id = ?";

        try {
            pst = connexion.prepareStatement(requete);
            pst.setString(1, recette.getTitre());
            pst.setString(2, recette.getDescription());
            pst.setString(3, recette.getIngredients());
            pst.setString(4, recette.getEtape());
            pst.setString(5, recette.getImage());
            pst.setString(6, recette.getVideo());
            pst.setInt(7, recette.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Recette> readAll() {
        String requete = "SELECT * FROM recette";
        List<Recette> list = new ArrayList<>();
        try {
            ste = connexion.createStatement();
            ResultSet rs = ste.executeQuery(requete);
            while (rs.next()) {
                list.add(new Recette(
                        rs.getInt("id"),
                        rs.getString("titre"),
                        rs.getString("description"),
                        rs.getString("ingredients"),
                        rs.getString("etape"),
                        rs.getString("image"),
                        rs.getString("video"),
                        rs.getInt("id_user")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public Recette readById(int id) {
        String requete = "SELECT * FROM recette WHERE id = ?";
        Recette recette = null;

        try (PreparedStatement pst = connexion.prepareStatement(requete)) {
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                recette = new Recette(
                        rs.getInt("id"),
                        rs.getString("titre"),
                        rs.getString("description"),
                        rs.getString("ingredients"),
                        rs.getString("etape"),
                        rs.getString("image"),
                        rs.getString("video"),
                        rs.getInt("id_user")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return recette;
    }
}
