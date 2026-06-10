package iut.sae.algo.efficacite.etu96;

public class TasDeSable {

    /**
     * Effondre un bac de sable selon les règles du tas de sable.
     * @param bac Le tableau 2D représentant le bac de sable.
     * @return Le bac après effondrement.
     */
    public static int[][] effondrer(int[][] bac) {
        if (bac == null || bac.length == 0 || bac[0].length == 0) {
            return bac;
        }

        int lignes = bac.length;
        int colonnes = bac[0].length;
        int[][] resultat = new int[lignes][colonnes];
        copierTableau(bac, resultat);

        boolean modifie;
        do {
            modifie = false;
            for (int i = 0; i < lignes; i++) {
                for (int j = 0; j < colonnes; j++) {
                    if (resultat[i][j] >= 4) {
                        int grains = resultat[i][j] / 4;
                        resultat[i][j] %= 4;
                        modifie = true;

                        // Distribuer les grains aux voisins
                        if (i > 0) {
                            resultat[i - 1][j] += grains;
                        }
                        if (i < lignes - 1) {
                            resultat[i + 1][j] += grains;
                        }
                        if (j > 0) {
                            resultat[i][j - 1] += grains;
                        }
                        if (j < colonnes - 1) {
                            resultat[i][j + 1] += grains;
                        }
                    }
                }
            }
        } while (modifie);

        return resultat;
    }

    /**
     * Copie le contenu d'un tableau 2D dans un autre.
     * @param source Le tableau source.
     * @param destination Le tableau de destination.
     */
    private static void copierTableau(int[][] source, int[][] destination) {
        for (int i = 0; i < source.length; i++) {
            System.arraycopy(source[i], 0, destination[i], 0, source[i].length);
        }
    }
}
