package Morpion;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {

        System.out.println("Bienvenue dans le jeu du Morpion (version wish car fait en java)");
        Scanner FirtsEnter = new Scanner(System.in);
        System.out.println("Entrez un nombre entre 3 et 5");
        int nbr = FirtsEnter.nextInt();
        int[][] Plateau = null;
        if (nbr < 3 || nbr > 5 || nbr % 2 == 0) {
            System.out.println("Taille non valide !");
            main(args);
        } else {
            Plateau = new int[nbr + 2][nbr + 2];
            Methodes.AffichageTableau(Plateau);
        }

        Scanner EnterJoueur = new Scanner(System.in);
        System.out.println("Quel joueur veut commencer ? 1 ou 2 ?");
        int Joueur = EnterJoueur.nextInt();

        if (Joueur != 1 && Joueur != 2) {
            test.main(args);
        } else {
            System.out.println("Le premier Joueur est le numero " + Joueur);
        }

        int continuer = 0;
        while (continuer == 0) {
            if (Joueur == 1) {
                Scanner ligneJoueur1 = new Scanner(System.in);
                System.out.println("Dans quelle ligne le joueur 1 veut-il jouer ? ");
                int ligne1 = ligneJoueur1.nextInt();

                Scanner colonnejoueur1 = new Scanner(System.in);
                System.out.println("Dans quelle colonne le joueur 1 veut-il jouer ? ");
                int colonne1 = colonnejoueur1.nextInt();

                if (Plateau[ligne1][colonne1] == 0) {
                    Plateau[ligne1][colonne1] = 1;
                    Joueur = 2;
                    Methodes.AffichageTableau(Plateau);
                    System.out.println(" ");
                } else {
                    System.out.println(" Rejouer ");
                    Joueur = 1;
                    Methodes.AffichageTableau(Plateau);
                }

            }
            if (Joueur == 2) {
                Scanner ligneJoueur2 = new Scanner(System.in);
                System.out.println("Dans quelle ligne le joueur 2 veut-il jouer ? ");
                int ligne2 = ligneJoueur2.nextInt();

                Scanner colonnejoueur2 = new Scanner(System.in);
                System.out.println("Dans quelle colonne le joueur 2 veut-il jouer ? ");
                int colonne2 = colonnejoueur2.nextInt();

                if (Plateau[ligne2][colonne2] == 0) {
                    Plateau[ligne2][colonne2] = 2;
                    Joueur = 1;
                    Methodes.AffichageTableau(Plateau);
                    System.out.println(" ");
                } else {
                    System.out.println(" Rejouer ");
                    Joueur = 2;
                    Methodes.AffichageTableau(Plateau);
                }
            }
        }
    }

    public static class Methodes {
        public static void AffichageTableau(int [][] Plateau) {
            for (int i=0; i < Plateau.length; i++) {
                System.out.println();
                for (int j=0; j < Plateau.length; j++) {
                    Plateau[0][j]=99;
                    Plateau[i][0]=99;
                    Plateau[Plateau.length-1][j]=99;
                    Plateau[i][Plateau.length-1]=99;

                    if (Plateau[i][j]==1) {
                        System.out.print(("X"));
                    }
                    if (Plateau[i][j]==2) {
                        System.out.print(("O"));
                    }

                    if (Plateau[i][j]==99) {
                        System.out.print(("#"));
                    }
                    if (Plateau[i][j]==0) {
                        System.out.print(("-"));
                    }

                }
            }
        }
    }
}
