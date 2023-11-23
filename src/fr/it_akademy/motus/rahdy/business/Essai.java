package fr.it_akademy.motus.rahdy.business;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Essai {
    private Long id;
    private String contenu;
    private LocalDateTime dateHeureDebut = LocalDateTime.now();
    private Partie partie;
    private static Long compteur = 0L;

    public Essai(String contenu,LocalDateTime dateHeureDebut){
        id = ++compteur;
        this.contenu=contenu;
        this.dateHeureDebut=dateHeureDebut;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public LocalDateTime getDateHeureDebut() {
        return dateHeureDebut;
    }

    public void setDateHeureDebut(LocalDateTime dateHeureDebut) {
        this.dateHeureDebut = dateHeureDebut;
    }

    public Partie getPartie() {
        return partie;
    }

    public void setPartie(Partie partie) {
        this.partie = partie;
    }

    public static Long getCompteur() {
        return compteur;
    }

    public static void setCompteur(Long compteur) {
        Essai.compteur = compteur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Essai essai = (Essai) o;
        return Objects.equals(id, essai.id) && Objects.equals(contenu, essai.contenu) && Objects.equals(dateHeureDebut, essai.dateHeureDebut) && Objects.equals(partie, essai.partie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, contenu, dateHeureDebut, partie);
    }

    @Override
    public String toString() {
        return "Essai{" +
                "id=" + id +
                ", contenu='" + contenu + '\'' +
                ", dateHeureDebut=" + dateHeureDebut +
                ", partie=" + partie +
                '}';
    }
}
