package utils;

import java.util.Date;
import java.util.List;

public class Cours {
    private int id;
    private String nom;
    private String description;
    private Date date_debut;
    private Date date_fin;



    // getters
    public int getId() {
        return id;
    }
    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public Date getDateDebut() {
        return date_debut;
    }

    public Date getDateFin() {
        return date_fin;
    }

    // setters
    public void setId(int id) {
        this.id = id;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateDebut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public void setDateFin(Date date_fin) {
        this.date_fin = date_fin;
    }
}