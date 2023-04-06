package Morpion;

import java.util.Scanner;

public class MainMorpion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenue dans le jeu de Morpion !");
        System.out.print("Choisissez la taille du plateau (3, 5, 7) : ");
        int taille = sc.nextInt();
        Plateau plateau = new Plateau(taille);
        int joueurActuel = 1;
        while (true) {
            System.out.println("Tour du joueur " + joueurActuel);
            System.out.print("Ligne : ");
            int ligne = sc.nextInt();
            System.out.print("Colonne : ");
            int colonne = sc.nextInt();
            try {
                plateau.jouerCoup(joueurActuel, ligne, colonne);
            } catch (IllegalArgumentException e) {
                System.out.println("Case déjà occupée !");
                continue;
            }
            plateau.AffichageTableau(plateau.getTableau());
            if (plateau.estGagnant(joueurActuel)) {
                System.out.println("Le joueur " + joueurActuel + " a gagné !");
                break;
            }
            if (plateau.estPlein()) {
                System.out.println("Plateau plein, match nul !");
                break;
            }
            joueurActuel = joueurActuel == 1 ? 2 : 1;
        }
    }
}