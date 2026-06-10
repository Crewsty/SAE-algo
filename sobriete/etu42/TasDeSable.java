package iut.sae.algo.sobriete.etu42;

public class TasDeSable {

    
    public static int[][] effondrer(int[][] bac) {

        int nbLignes = bac.length;
        int nbCols   = bac[0].length;

        int[][] copie = new int[nbLignes][nbCols];
        for (int i = 0; i < nbLignes; i++)
            for (int j = 0; j < nbCols; j++)
                copie[i][j] = bac[i][j];

        boolean changed = true;

        while (changed) {
            changed = false;
            for (int l = 0; l < nbLignes; l++) {
                for (int c = 0; c < nbCols; c++) {
                    if (l > 0 && copie[l][c] - copie[l-1][c] > 1) {
                        copie[l][c]--; copie[l-1][c]++; changed = true;
                    }
                    if (c < nbCols-1 && copie[l][c] - copie[l][c+1] > 1) {
                        copie[l][c]--; copie[l][c+1]++; changed = true;
                    }
                    if (l < nbLignes-1 && copie[l][c] - copie[l+1][c] > 1) {
                        copie[l][c]--; copie[l+1][c]++; changed = true;
                    }
                    if (c > 0 && copie[l][c] - copie[l][c-1] > 1) {
                        copie[l][c]--; copie[l][c-1]++; changed = true;
                    }
                }
            }
        }

        return copie;
    }
}
