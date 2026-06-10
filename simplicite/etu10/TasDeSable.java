package iut.sae.algo.simplicite.etu10;

public class TasDeSable {

    // Renvoie vrai si la case (r, c) peut donner un grain a un voisin
    private static boolean estInstable(int[][] g, int r, int c) {
        int rows = g.length;
        int cols = g[0].length;
        if (r - 1 >= 0 && g[r][c] - g[r - 1][c] > 1) {
            return true; // haut
        }
        if (c + 1 < cols && g[r][c] - g[r][c + 1] > 1) {
            return true; // droite
        }
        if (r + 1 < rows && g[r][c] - g[r + 1][c] > 1) {
            return true; // bas
        }
        if (c - 1 >= 0 && g[r][c] - g[r][c - 1] > 1) {
            return true;  // gauche
        }
        return false;
    }

    // Fait s'effondrer la case (r, c) vers ses voisins dans l'ordre horaire
    private static void effondrerCase(int[][] g, int r, int c) {
        int rows = g.length;
        int cols = g[0].length;
        if (r - 1 >= 0 && g[r][c] - g[r - 1][c] > 1) { 
            g[r][c]--; g[r - 1][c]++; 
        } // haut
        if (c + 1 < cols && g[r][c] - g[r][c + 1] > 1) { 
            g[r][c]--; g[r][c + 1]++; 
        } // droite
        if (r + 1 < rows && g[r][c] - g[r + 1][c] > 1) { 
            g[r][c]--; g[r + 1][c]++; 
        } // bas
        if (c - 1 >= 0 && g[r][c] - g[r][c - 1] > 1) { 
            g[r][c]--; g[r][c - 1]++; 
        }  // gauche
    }

    // Renvoie une copie de la grille
    private static int[][] copierGrille(int[][] bac) {
        int[][] copie = new int[bac.length][];
        for (int i = 0; i < bac.length; i++) {
            copie[i] = bac[i].clone();
        }
        return copie;
    }

    // Renvoie vrai si aucune case n'est instable
    private static boolean grilleEstStable(int[][] g) {
        for (int r = 0; r < g.length; r++) {
            for (int c = 0; c < g[0].length; c++) {
                if (estInstable(g, r, c)) {
                    return false;
                } 
            }
        }
        return true;
    }

    public static int[][] effondrer(int bac[][]) {
        if (bac == null || bac.length == 0) return bac;
        int[][] g = copierGrille(bac);
        while (!grilleEstStable(g)) {
            for (int r = 0; r < g.length; r++) {
                for (int c = 0; c < g[0].length; c++) {
                    effondrerCase(g, r, c);
                }
            }
        }
        return g;
    }
}
