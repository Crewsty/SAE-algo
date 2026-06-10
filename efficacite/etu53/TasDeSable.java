package iut.sae.algo.efficacite.etu53;

import iut.sae.algo.simplicite.DirectionEnum;

public class TasDeSable {

    /**
     * Complexité (N = nombre de cases, G = nombre total de grains) : un balayage
     * coûte N et il en faut de l'ordre de G avant stabilité, d'où un temps en
     * O(G × N) et un espace en O(1), tout se faisant sur place.
     *
     * @param bac la grille de départ
     * @return le bac une fois stable
     */
    public static int[][] effondrer(int[][] bac) {
        final int lignes = bac.length;
        boolean aChange = true;

        while (aChange) {
            aChange = false;
            for (int i = 0; i < lignes; i++) {
                int[] ligneCourante = bac[i];
                int colonnes = ligneCourante.length;
                for (int j = 0; j < colonnes; j++) {
                    if (ligneCourante[j] <= 1) {
                        continue;
                    }
                    for (DirectionEnum dir : DirectionEnum.values()) {
                        switch (dir) {
                            case HAUT:
                                if (i > 0 && ligneCourante[j] - bac[i - 1][j] > 1) {
                                    bac[i - 1][j]++;
                                    ligneCourante[j]--;
                                    aChange = true;
                                }
                                break;
                            case DROITE:
                                if (j < colonnes - 1 && ligneCourante[j] - ligneCourante[j + 1] > 1) {
                                    ligneCourante[j + 1]++;
                                    ligneCourante[j]--;
                                    aChange = true;
                                }
                                break;
                            case BAS:
                                if (i < lignes - 1 && ligneCourante[j] - bac[i + 1][j] > 1) {
                                    bac[i + 1][j]++;
                                    ligneCourante[j]--;
                                    aChange = true;
                                }
                                break;
                            case GAUCHE:
                                if (j > 0 && ligneCourante[j] - ligneCourante[j - 1] > 1) {
                                    ligneCourante[j - 1]++;
                                    ligneCourante[j]--;
                                    aChange = true;
                                }
                                break;
                        }
                    }
                }
            }
        }
        return bac;
    }
}
