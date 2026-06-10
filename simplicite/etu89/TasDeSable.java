package iut.sae.algo.simplicite.etu89;

public class TasDeSable {

    /**
     * Fait s'effondrer le tas de sable jusqu'à ce qu'il soit stable.
     * L'effondrement se fait sans le sens des aiguilles d'une montre.
     * Un tas est stable quand aucune case ne diffère de plus de 1 avec ses voisins.
     *
     * @param bac Tableau à 2 entrées représentant le tas de sable
     * @return Tableau stabilisé
     */
    public static int[][] effondrer(int bac[][]) {
        int nbLignes = bac.length;
        int nbColonnes = bac[0].length;
        boolean changement = false;

        do {
            changement = false;
            for (int indexLignes = 0; indexLignes < nbLignes; indexLignes++) {
                for (int indexColonnes = 0; indexColonnes < nbColonnes; indexColonnes++) {
                    // Si un écoulement est fait, propager() renvoie true
                    // On change donc l'état de changement
                    if (propager(bac, indexLignes, indexColonnes)) {
                        changement = true;
                    }
                }
            }
            // On répète jusqu'a qu'aucun grain ne bouge. (-> changement==false)
        } while (changement);

        return bac;
    }

    /**
     * Propage les grains d'une case vers ses voisins
     * si l'écart est supérieur ou égal à 2.
     *
     * @param bac     Tableau à deux entrées représentant le tas de sable
     * @param ligne   L'index de la ligne de la case$
     * @param colonne L'index de la colonne de la case
     * @return true si au moins un grain a été déplacé, retourne false sinon
     */
    private static boolean propager(int bac[][], int ligne, int colonne) {
        boolean unGrainABouge = false;

        if (propagerVersHaut(bac, ligne, colonne)) {
            unGrainABouge = true;
        }
        if (propagerVersDroite(bac, ligne, colonne)) {
            unGrainABouge = true;
        }
        if (propagerVersBas(bac, ligne, colonne)) {
            unGrainABouge = true;
        }
        if (propagerVersGauche(bac, ligne, colonne)) {
            unGrainABouge = true;
        }

        return unGrainABouge;
    }

    /**
     * Déplace un grain vers le haut si il faut
     *
     * @param bac     Tableau à deux entrées représentant le tas de sable
     * @param ligne   L'index de la ligne de la case
     * @param colonne L'index de la colonne de la case
     * @return true si au moins un grain a été déplacé, retourne false sinon
     */
    private static boolean propagerVersHaut(int[][] bac, int ligne, int colonne) {
        // On vérifie qu'on ne soit pas sur un bord:
        if (ligne == 0)
            return false;
        if (bac[ligne][colonne] - bac[ligne - 1][colonne] < 2)
            return false;

        // On propage si c'est bon
        bac[ligne][colonne] -= 1;
        bac[ligne - 1][colonne] += 1;
        return true;
    }

    /**
     * Déplace un grain vers la droite si il faut
     *
     * @param bac     Tableau à deux entrées représentant le tas de sable
     * @param ligne   L'index de la ligne de la case
     * @param colonne L'index de la colonne de la case
     * @return true si au moins un grain a été déplacé, retourne false sinon
     */
    private static boolean propagerVersDroite(int[][] bac, int ligne, int colonne) {
        // On vérifie qu'on ne soit pas sur un bord:
        if (colonne == bac[0].length - 1)
            return false;
        if (bac[ligne][colonne] - bac[ligne][colonne + 1] < 2)
            return false;

        // On propage si c'est bon
        bac[ligne][colonne] -= 1;
        bac[ligne][colonne + 1] += 1;
        return true;
    }

    /**
     * Déplace un grain vers le bas si il faut
     *
     * @param bac     Tableau à deux entrées représentant le tas de sable
     * @param ligne   L'index de la ligne de la case$
     * @param colonne L'index de la colonne de la case
     * @return true si au moins un grain a été déplacé, retourne false sinon
     */
    private static boolean propagerVersBas(int[][] bac, int ligne, int colonne) {
        // On vérifie qu'on ne soit pas sur un bord:
        if (ligne == bac.length - 1)
            return false;
        if (bac[ligne][colonne] - bac[ligne + 1][colonne] < 2)
            return false;

        // On propage si c'est bon
        bac[ligne][colonne] -= 1;
        bac[ligne + 1][colonne] += 1;
        return true;
    }

    /**
     * Déplace un grain vers la gauche si il faut
     *
     * @param bac     Tableau à deux entrées représentant le tas de sable
     * @param ligne   L'index de la ligne de la case$
     * @param colonne L'index de la colonne de la case
     * @return true si au moins un grain a été déplacé, retourne false sinon
     */
    private static boolean propagerVersGauche(int[][] bac, int ligne, int colonne) {
        // On vérifie qu'on ne soit pas sur un bord:
        if (colonne == 0)
            return false;
        if (bac[ligne][colonne] - bac[ligne][colonne - 1] < 2)
            return false;

        // On propage si c'est bon
        bac[ligne][colonne] -= 1;
        bac[ligne][colonne - 1] += 1;
        return true;
    }
}
