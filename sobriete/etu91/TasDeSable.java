package iut.sae.algo.sobriete.etu91;

public class TasDeSable {

    /**
     * Effondre un bac de sable jusqu'à stabilisation.
     * 
     * Règle :
     * - chaque grain "tombe" vers un voisin plus bas
     * - priorité : haut, droite, bas, gauche
     * - on recommence jusqu'à stabilité complète
     */
    public static int[][] effondrer(int[][] bac) {

        if (bac == null || bac.length == 0) {
            return bac;
        }

        if (bac[0].length == 0) {
            return bac;
        }

        int lignes = bac.length;
        int colonnes = bac[0].length;

        // Cas trop petit
        if (lignes < 2 && colonnes < 2) {
            return copie(bac);
        }

        int[][] resultat = copie(bac);

        boolean modification = true;

        while (modification) {

            modification = false;

            int[][] suivant = copie(resultat);

            for (int i = 0; i < lignes; i++) {
                for (int j = 0; j < colonnes; j++) {

                    int hauteur = resultat[i][j];

                    // Haut
                    if (i > 0 && hauteur - resultat[i - 1][j] > 1) {
                        suivant[i][j]--;
                        suivant[i - 1][j]++;
                        modification = true;
                    }

                    // Droite
                    else if (j < colonnes - 1 && hauteur - resultat[i][j + 1] > 1) {
                        suivant[i][j]--;
                        suivant[i][j + 1]++;
                        modification = true;
                    }

                    // Bas
                    else if (i < lignes - 1 && hauteur - resultat[i + 1][j] > 1) {
                        suivant[i][j]--;
                        suivant[i + 1][j]++;
                        modification = true;
                    }

                    // Gauche
                    else if (j > 0 && hauteur - resultat[i][j - 1] > 1) {
                        suivant[i][j]--;
                        suivant[i][j - 1]++;
                        modification = true;
                    }
                }
            }

            resultat = suivant;
        }

        return resultat;
    }

    /**
     * Copie profonde d'un tableau 2D.
     */
    private static int[][] copie(int[][] tableau) {

        int[][] copie = new int[tableau.length][];

        for (int i = 0; i < tableau.length; i++) {
            copie[i] = tableau[i].clone();
        }

        return copie;
    }
}
