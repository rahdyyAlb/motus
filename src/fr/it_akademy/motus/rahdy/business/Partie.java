package fr.it_akademy.motus.rahdy.business;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Partie {
    private Long id;
    private LocalDateTime dateHeureDebut = LocalDateTime.now();
    private List<Essai> essais;
    private static Long compteur = 0L;
    private Mot mot;

    public Partie(LocalDateTime dateHeureDebut){
        id = ++compteur;
        this.dateHeureDebut=dateHeureDebut;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateHeureDebut() {
        return dateHeureDebut;
    }

    public void setDateHeureDebut(LocalDateTime dateHeureDebut) {
        this.dateHeureDebut = dateHeureDebut;
    }

    public List<Essai> getEssais() {
        return essais;
    }

    public void setEssais(List<Essai> essais) {
        this.essais = essais;
    }

    public static Long getCompteur() {
        return compteur;
    }

    public static void setCompteur(Long compteur) {
        Partie.compteur = compteur;
    }

    public Mot getMot() {
        return mot;
    }

    public void setMot(Mot mot) {
        this.mot = mot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Partie partie = (Partie) o;
        return Objects.equals(id, partie.id) && Objects.equals(dateHeureDebut, partie.dateHeureDebut) && Objects.equals(essais, partie.essais) && Objects.equals(mot, partie.mot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateHeureDebut, essais, mot);
    }

    @Override
    public String toString() {
        return "Partie{" +
                "id=" + id +
                ", dateHeureDebut=" + dateHeureDebut +
                ", essais=" + essais +
                ", mot=" + mot +
                '}';
    }
}
