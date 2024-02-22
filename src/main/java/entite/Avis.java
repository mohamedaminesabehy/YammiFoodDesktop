package entite;

import java.util.Date;

public class Avis {
    private int idAvis;
    private Date date;
    private int note;
    private String commentaire;
    private int idUser;
    private int idRecette;

    public Avis() {
    }

    public Avis(int idAvis, Date date, int note, String commentaire, int idUser, int idRecette) {
        this.idAvis = idAvis;
        this.date = date;
        this.note = note;
        this.commentaire = commentaire;
        this.idUser = idUser;
        this.idRecette = idRecette;
    }

    public int getIdAvis() {
        return idAvis;
    }

    public void setIdAvis(int idAvis) {
        this.idAvis = idAvis;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdRecette() {
        return idRecette;
    }

    public void setIdRecette(int idRecette) {
        this.idRecette = idRecette;
    }

    @Override
    public String toString() {
        return "Avis{" +
                "idAvis=" + idAvis +
                ", date='" + date + '\'' +
                ", note=" + note +
                ", commentaire='" + commentaire + '\'' +
                ", idUser=" + idUser +
                ", idRecette=" + idRecette +
                '}';
    }


}
