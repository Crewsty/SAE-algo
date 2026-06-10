package iut.sae.algo.efficacite.etu77;

public class TasDeSable {

    private static final int[] DEPLACEMENT_LIGNE = {-1, 0, 1, 0};
    private static final int[] DEPLACEMENT_COLONNE = {0, 1, 0, -1};

    public static int[][] effondrer(int[][] bac) {
        if (bac == null) return null;

        int[][] grille = copierBac(bac);
        boolean aBouge = true;

        while (aBouge) {
            aBouge = false;

            for (int ligne = 0; ligne < grille.length; ligne++) {
                for (int colonne = 0; colonne < grille[ligne].length; colonne++) {
                    for (int direction = 0; direction < 4; direction++) {
                        int voisinLigne = ligne + DEPLACEMENT_LIGNE[direction];
                        int voisinColonne = colonne + DEPLACEMENT_COLONNE[direction];

                        if (estValide(grille, voisinLigne, voisinColonne)
                                && grille[ligne][colonne] - grille[voisinLigne][voisinColonne] > 1) {
                            grille[ligne][colonne]--;
                            grille[voisinLigne][voisinColonne]++;
                            aBouge = true;
                        }
                    }
                }
            }
        }

        return grille;
    }

    private static int[][] copierBac(int[][] bac) {
        int[][] copie = new int[bac.length][];
        for (int ligne = 0; ligne < bac.length; ligne++) {
            copie[ligne] = bac[ligne].clone();
        }
        return copie;
    }

    private static boolean estValide(int[][] bac, int ligne, int colonne) {
        return ligne >= 0 && ligne < bac.length
                && colonne >= 0 && colonne < bac[ligne].length;
    }
}
