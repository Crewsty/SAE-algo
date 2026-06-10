package iut.sae.algo.sobriete.etu86;

public class TasDeSable {
    private static final int[] dirRow = { -1, 0, 1, 0 };
    private static final int[] dirColumn = { 0, 1, 0, -1 };

    public static int[][] effondrer(int bac[][]) {
        int row = bac.length;
        int column = bac[0].length;

        boolean hasMoved = false;

        int nextR, nextC;
        int minR = 0, maxR = row - 1;
        int minC = 0, maxC = column - 1;

        do {
            hasMoved = false;

            int nextMinR = row, nextMaxR = -1;
            int nextMinC = column, nextMaxC = -1;

            for (int indexR = minR; indexR <= maxR; indexR++) {
                for (int indexC = minC; indexC <= maxC; indexC++) {

                    for (int i = 0; i < 4; i++) {
                        nextR = indexR + dirRow[i]; 
                        nextC = indexC + dirColumn[i];

                        if (nextR >= 0 && nextR < row && nextC >= 0 && nextC < column) {
                            if (bac[indexR][indexC] - bac[nextR][nextC] > 1) {
                                bac[indexR][indexC]--;
                                bac[nextR][nextC]++;

                                hasMoved = true;

                                nextMinR = Math.min(nextMinR, Math.min(indexR, nextR));
                                nextMaxR = Math.max(nextMaxR, Math.max(indexR, nextR));
                                nextMinC = Math.min(nextMinC, Math.min(indexC, nextC));
                                nextMaxC = Math.max(nextMaxC, Math.max(indexC, nextC));
                            }
                        }
                    }

                }
            }

            if(hasMoved) {
                    minR = Math.max(0, nextMinR - 1);
                    maxR = Math.min(row - 1, nextMaxR + 1);
                    minC = Math.max(0, nextMinC - 1);
                    maxC = Math.min(column - 1, nextMaxC + 1);
                }

        } while (hasMoved);
        
        return bac;
    }
}
