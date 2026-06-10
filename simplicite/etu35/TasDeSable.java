package iut.sae.algo.simplicite.etu35;

public class TasDeSable {
    public static int[][] effondrer(int[][] bac) {
        
        int nbLignes = bac.length;
        int nbCol = bac[0].length;
        boolean encoreInstable = true;

        // Boucle tant qu'il y a du mouvement, on continue
        while (encoreInstable) {
            encoreInstable = false;

            // On parcourt tout le tableau case par case
            for (int i = 0; i < nbLignes; i++) {
                for (int j = 0; j < nbCol; j++) {

                    
                    int grainsDeBase = bac[i][j];
                    boolean caVaBouger = false;

                    // On check si la case a une différence > 1 avec un de ses voisins
                    if (i > 0 && grainsDeBase - bac[i-1][j] > 1) {
                        caVaBouger = true;
                    }
                    if (j < nbCol - 1 && grainsDeBase - bac[i][j+1] > 1) {
                        caVaBouger = true;
                    }
                    if (i < nbLignes - 1 && grainsDeBase - bac[i+1][j] > 1) {
                        caVaBouger = true;
                    }
                    if (j > 0 && grainsDeBase - bac[i][j-1] > 1) {
                        caVaBouger = true;
                    }

                    
                    if (caVaBouger) {
                        if (i > 0 && grainsDeBase - bac[i-1][j] > 1) {
                            bac[i][j]--;
                            bac[i-1][j]++;
                            encoreInstable = true;
                        }
                        if (j < nbCol - 1 && grainsDeBase - bac[i][j+1] > 1) {
                            bac[i][j]--;
                            bac[i][j+1]++;
                            encoreInstable = true;
                        }
                        if (i < nbLignes - 1 && grainsDeBase - bac[i+1][j] > 1) {
                            bac[i][j]--;
                            bac[i+1][j]++;
                            encoreInstable = true;
                        }
                        if (j > 0 && grainsDeBase - bac[i][j-1] > 1) {
                            bac[i][j]--;
                            bac[i][j-1]++;
                            encoreInstable = true;
                        }
                    }
                }
            }
        }
        return bac;
    }
}
