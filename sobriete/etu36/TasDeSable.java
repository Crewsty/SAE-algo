package iut.sae.algo.sobriete.etu36;

public class TasDeSable {
    public static int[][] effondrer(int bac[][]) {
        boolean instable = true;
        while (instable) {
            instable = false;
            for (int i = 0; i < bac.length; i++) {
                for (int j = 0; j < bac[0].length; j++) {
                    if (i > 0 && bac[i][j] - bac[i-1][j] > 1) {
                        bac[i][j]--;
                        bac[i-1][j]++;
                        instable = true;
                    }
                    if (j < bac[0].length-1 && bac[i][j] - bac[i][j+1] > 1) {
                        bac[i][j]--;
                        bac[i][j+1]++;
                        instable = true;
                    }
                    if (i < bac.length-1 && bac[i][j] - bac[i+1][j] > 1) {
                        bac[i][j]--;
                        bac[i+1][j]++;
                        instable = true;
                    }
                    if (j > 0 && bac[i][j] - bac[i][j-1] > 1) {
                        bac[i][j]--;
                        bac[i][j-1]++;
                        instable = true;
                    }
                }
            }
        }
        return bac;
    }
}
