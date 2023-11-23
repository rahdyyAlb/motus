package fr.it_akademy.motus.rahdy.business;

import java.util.Objects;

public class Mot {
    private Long id;
    private String nom;

    private static Long compteur = 0L;

    public Mot(String nom){
        id = ++compteur;
        this.nom=nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }



    public static Long getCompteur() {
        return compteur;
    }

    public static void setCompteur(Long compteur) {
        Mot.compteur = compteur;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mot mot = (Mot) o;
        return Objects.equals(id, mot.id) && Objects.equals(nom, mot.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom);
    }

    @Override
    public String toString() {
        return "Mot{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
