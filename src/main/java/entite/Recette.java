package entite;

public class Recette {
    private int id;
    private String titre;
    private String description;
    private String ingredients;
    private String etape;
    private byte[] image;
    private byte[] video;
    private int id_user;

    public Recette() {
    }

    public Recette(int id, String titre, String description, String ingredients, String etape, byte[] image, byte[] video, int id_user) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.ingredients = ingredients;
        this.etape = etape;
        this.image = image;
        this.video = video;
        this.id_user = id_user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getEtape() {
        return etape;
    }

    public void setEtape(String etape) {
        this.etape = etape;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public byte[] getVideo() {
        return video;
    }

    public void setVideo(byte[] video) {
        this.video = video;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    @Override
    public String toString() {
        return "Recette{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", etape='" + etape + '\'' +
                ", id_user=" + id_user +
                '}';
    }
}