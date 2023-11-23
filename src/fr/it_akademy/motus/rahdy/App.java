package fr.it_akademy.motus.rahdy;

import fr.it_akademy.motus.rahdy.business.Mot;
import fr.it_akademy.motus.rahdy.business.Partie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.*;

public class App {

    private static List<Mot> motList = new ArrayList<>();
    private static LocalDateTime date = LocalDateTime.now();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        importerMots();
        jouerUnePartie();

    }

    private static void jouerUnePartie() {
        System.out.println("Bienvenue sur Motus");
        System.out.println("Vous avez 6 essais pour trouver le mot secret");
        tirageMot();
    }

    private static void tirageMot() {
        Random nbm = new Random();
        int positionHsd = motList.size();
        Mot motHsd = motList.get(nbm.nextInt(positionHsd));
        Partie partie = new Partie(date);
        partie.setMot(motHsd);

        char[] motArray = new char[7];
        motArray[0] = motHsd.getNom().charAt(1);
        motArray[1] = motHsd.getNom().charAt(2);
        motArray[2] = motHsd.getNom().charAt(3);
        motArray[3] = motHsd.getNom().charAt(4);
        motArray[4] = motHsd.getNom().charAt(5);
        motArray[5] = motHsd.getNom().charAt(6);
        motArray[6] = motHsd.getNom().charAt(7);

        System.out.println(motArray);
        String tire = "_______";
        char[] motsUtilisateur = new char[7];
        motsUtilisateur[0] = motHsd.getNom().charAt(1);
        motsUtilisateur[1] = tire.charAt(0);
        motsUtilisateur[2] = tire.charAt(1);
        motsUtilisateur[3] = tire.charAt(2);
        motsUtilisateur[4] = tire.charAt(3);
        motsUtilisateur[5] = tire.charAt(4);
        motsUtilisateur[6] = tire.charAt(5);
        System.out.println(motsUtilisateur);

        int compteur = 0;
        while (compteur < 6) {
            System.out.println("Saisir un mot : ");
            String motSaisie = scanner.nextLine();

            if (motSaisie.length() != 7) {
                System.out.println("Veuillez saisir un mot de 7 caractères.");
                continue;
            }

            char[] motsUtilisateurSaisi = motSaisie.toCharArray();
            compareGrilles(motsUtilisateurSaisi, motArray);
            compteur++;
            System.out.println("essaye n°"+compteur+" vous avez saisie "+motSaisie);
            System.out.println(motsUtilisateurSaisi);


        }
    }

    private static void compareGrilles(char[] grilleJoueur, char[] grilleGagnante) {
        boolean correspondance = true;

        for (int i = 0; i < grilleJoueur.length; i++) {
            if (grilleJoueur[i] == grilleGagnante[i]) {
                // Garder l'élément s'il correspond à la même position dans l'autre grille
            } else if (contains(grilleGagnante, grilleJoueur[i])) {
                grilleJoueur[i] = '_'; // Remplacer si présent mais à la mauvaise position
                correspondance = false;
            } else {
                grilleJoueur[i] = '_'; // Autre élément non trouvé dans la grilleGagnante
                correspondance = false;
            }
        }
        if (!correspondance) {
            System.out.println("Certains éléments ne sont pas à la bonne position.");
        }


    }

    private static boolean contains(char[] array, char value) {
        for (char c : array) {
            if (c == value) {
                return true;
            }
        }
        return false;
    }

    private static void importerMots() {
        try {
            URL url = new URL("https://raw.githubusercontent.com/gverdier/motus/master/Console/Dictionnaire7.txt");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                String[] resultat = inputLine.split("/n");
                Mot mot = new Mot(Arrays.toString(resultat));
                motList.add(mot);
            }

            in.close();
        } catch (MalformedURLException e) {
            System.out.println("URL incorrecte");
            System.exit(-1);
        } catch (IOException e) {
            System.out.println("Problème réseau");
            System.exit(-1);
        }

        System.out.println("Nombre de mots importés : " + motList.size());
    }
}