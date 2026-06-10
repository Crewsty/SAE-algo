package iut.sae.algo.sobriete.etu84;

public class TasDeSable {
    public static int[][] effondrer(int[][] bac) {
        boolean mouvement = true;


        while (mouvement) { //boucle tant que la grille a une possibilité d'instabilité
            mouvement = false;

            for (int lig = 0; lig < bac.length; lig++) {
                for (int col = 0; col < bac[lig].length; col++) {
                    
                    int grainsCase = bac[lig][col];

                    if(grainsCase <2){continue;}

                    //on regarde si au moins un voisin a >= 2 grains de moins
                    // celui du haut
                    if (lig - 1 >= 0 && (grainsCase - bac[lig - 1][col] >= 2)) {
                        bac[lig][col] --;
                        bac[lig - 1][col] ++;
                        grainsCase --;
                        mouvement = true;
                    }
                    // celui de droite
                    if (col + 1 < bac[lig].length && (grainsCase - bac[lig][col + 1] >= 2)) {
                        bac[lig][col] --;
                        bac[lig][col + 1] ++;
                        grainsCase --;
                        mouvement = true;
                    }
                    // celui du bas
                    if (lig + 1 < bac.length && (grainsCase - bac[lig + 1][col] >= 2)) {
                        bac[lig][col] --;
                        bac[lig + 1][col] ++;
                        grainsCase --;
                        mouvement = true;
                    }
                    // celui de gauche
                    if (col - 1 >= 0 && (grainsCase - bac[lig][col - 1] >= 2)) {
                        bac[lig][col] --;
                        bac[lig][col - 1] ++;
                        grainsCase --;
                        mouvement = true;
                    }  
                }
            }
        }

        // On retourne le tableau final stabilisé
        return bac;
    } 
}
