package Morpion;

public class Plateau {
    private final int[][] tableau;
    private final int taille;

    public Plateau(int taille) {
        if (taille < 3 || taille > 5 || taille % 2 == 0) {
            throw new IllegalArgumentException("Taille non valide !");
        }
        this.taille = taille;
        tableau = new int[taille + 2][taille + 2];
        initPlateau();
    }

    public void AffichageTableau(int [][] Plateau) {
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

    private void initPlateau() {
        for (int i = 0; i < tableau.length; i++) {
            tableau[0][i] = 99;
            tableau[i][0] = 99;
            tableau[tableau.length - 1][i] = 99;
            tableau[i][tableau.length - 1] = 99;
        }
    }

    public void jouerCoup(int joueur, int ligne, int colonne) {
        if (tableau[ligne][colonne] == 0) {
            tableau[ligne][colonne] = joueur;
        } else {
            throw new IllegalArgumentException("Case déjà occupée !");
        }
    }

    public boolean estGagnant(int joueur) {
        for (int i = 1; i < tableau.length - 1; i++) {
            for (int j = 1; j < tableau.length - 1; j++) {
                if (tableau[i][j] == joueur) {
                    if (tableau[i][j + 1] == joueur && tableau[i][j + 2] == joueur) {
                        return true;
                    }
                    if (tableau[i + 1][j] == joueur && tableau[i + 2][j] == joueur) {
                        return true;
                    }
                    if (tableau[i + 1][j + 1] == joueur && tableau[i + 2][j + 2] == joueur) {
                        return true;
                    }
                    if (tableau[i - 1][j + 1] == joueur && tableau[i - 2][j + 2] == joueur) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean estPlein() {
        for (int i = 1; i < tableau.length - 1; i++) {
            for (int j = 1; j < tableau.length - 1; j++) {
                if (tableau[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public int getTaille() {
        return taille;
    }

    public int[][] getTableau() {
        return tableau;
    }
}