package iut.sae.algo.efficacite.etu54;

public class TasDeSable {

    /** Complexité O(n * g) avec n=longueur*largeur le nombres de cases dans la grille et g le nombre total de grains */
    public static int[][] effondrer(int[][] bac) {
        if (bac.length==0 || bac[0].length==0)
            return bac;
        int largeur = bac.length;
        int longueur = bac[0].length;
        boolean edit=true;
        while(edit){
            edit = false;
            for (int i=0;i<largeur;i++) {
                for (int j=0;j<longueur;j++) {
                    int current=bac[i][j];
                    if (current<=1)
                        continue;
                    if (i>0 && current-bac[i-1][j]>1) {
                        bac[i][j]--;
                        bac[i-1][j]++;
                        current--;
                        edit=true;
                    }
                    if (j<longueur-1 && current-bac[i][j+1]>1) {
                        bac[i][j]--;
                        bac[i][j+1]++;
                        current--;
                        edit=true;
                    }
                    if (i<largeur-1 && current-bac[i+1][j]>1) {
                        bac[i][j]--;
                        bac[i+1][j]++;
                        current--;
                        edit=true;
                    }
                    if (j>0 && current-bac[i][j-1]>1) {
                        bac[i][j]--;
                        bac[i][j-1]++;
                        current--;
                        edit = true;
                    }
                }
            }
        } 
        return bac;
    }
}
