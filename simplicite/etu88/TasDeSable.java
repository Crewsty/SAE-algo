package iut.sae.algo.simplicite.etu88;

public class TasDeSable {

    /**
     * Permet de faire s'effondrer un tas de sable dans un bac de taille defini.
     * @param bac tableau d'entier à 2 entrées représentant le bac.
     * @return le bac avec le tas de sable effondré.
     * @author FRANCISCO Lilian
     */
    public static int[][] effondrer(int[][] bac) {
        boolean instable = true;
        int nbLigne = bac.length;
        int nbColonne = bac[0].length;

        while (instable) {
            instable = false;
            for (int Ligne = 0; Ligne < nbLigne; Ligne++) {
                for (int Colonne = 0; Colonne < nbColonne; Colonne++) {
                    if (Ligne > 0 && bac[Ligne][Colonne] - bac[Ligne - 1][Colonne] > 1) {
                        Effondrement(4, Ligne, Colonne, bac);
                        instable = true;
                    }
                    if (Colonne < nbColonne - 1 && bac[Ligne][Colonne] - bac[Ligne][Colonne + 1] > 1) {
                        Effondrement(3, Ligne, Colonne, bac);
                        instable = true;
                    }
                    if (Ligne < nbLigne - 1 && bac[Ligne][Colonne] - bac[Ligne + 1][Colonne] > 1) {
                        Effondrement(2, Ligne, Colonne, bac);
                        instable = true;
                    }
                    if (Colonne > 0 && bac[Ligne][Colonne] - bac[Ligne][Colonne - 1] > 1) {
                        Effondrement(1, Ligne, Colonne, bac);
                        instable = true;
                    }
                }
            }
        }
        return bac;
    }

    /**
     * Permet de faire les effondrements dans le bac pour chaque direction possible
     * @param Etape etape de l'effondrement
     * @param EffondrementLigne ligne actuelle où l'effondrement se produit
     * @param EffondrementColonne colonne actuelle où l'effondrement se produit
     * @param bac bac dans lequel l'effondrement se passe
     * @return le bac mis à jour
     * @author FRANCISCO Lilian
     */
    public static int[][] Effondrement(int Etape, int EffondrementLigne, int EffondrementColonne, int[][] bac){
        switch (Etape) {
            case 1:
                bac[EffondrementLigne][EffondrementColonne]--;
                bac[EffondrementLigne][EffondrementColonne - 1]++;
                break;
            case 2:
                bac[EffondrementLigne][EffondrementColonne]--;
                bac[EffondrementLigne + 1][EffondrementColonne]++;
                break;
            case 3:
                bac[EffondrementLigne][EffondrementColonne]--;
                bac[EffondrementLigne][EffondrementColonne + 1]++;
                break;
            case 4:
                bac[EffondrementLigne][EffondrementColonne]--;
                bac[EffondrementLigne - 1][EffondrementColonne]++;
                break;
        }
        return bac;
    }
}



