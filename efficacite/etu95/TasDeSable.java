package iut.sae.algo.efficacite.etu95;

public class TasDeSable {
    
    /**
     * Version ultra-rapide de l'effondrement du tas de sable
     * Utilise une approche par file d'attente pour les cellules instables
     */
    public static int[][] effondrer(int[][] bac) {
        if (bac == null || bac.length == 0 || bac[0].length == 0) {
            return bac;
        }
        
        int hauteur = bac.length;
        int largeur = bac[0].length;
        
        // Copie directe de la grille
        int[][] grille = new int[hauteur][largeur];
        for (int i = 0; i < hauteur; i++) {
            System.arraycopy(bac[i], 0, grille[i], 0, largeur);
        }
        
        // File d'attente pour les cellules instables (optimisée avec un tableau)
        int maxCells = hauteur * largeur;
        int[] queueX = new int[maxCells];
        int[] queueY = new int[maxCells];
        int head = 0;
        int tail = 0;
        
        // Détection initiale des cellules instables
        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                if (grille[i][j] >= 4) {
                    queueX[tail] = i;
                    queueY[tail] = j;
                    tail++;
                }
            }
        }
        
        // Traitement de la file d'attente
        while (head < tail) {
            int i = queueX[head];
            int j = queueY[head];
            head++;
            
            int grains = grille[i][j];
            if (grains < 4) continue;
            
            int nbTombes = grains >> 2; // Division par 4 (plus rapide)
            grille[i][j] = grains & 3;   // Modulo 4 (grains % 4)
            
            // Distribution aux voisins avec mise en file directe
            if (i > 0) {
                grille[i-1][j] += nbTombes;
                if (grille[i-1][j] >= 4) {
                    queueX[tail] = i-1;
                    queueY[tail] = j;
                    tail++;
                }
            }
            if (i < hauteur-1) {
                grille[i+1][j] += nbTombes;
                if (grille[i+1][j] >= 4) {
                    queueX[tail] = i+1;
                    queueY[tail] = j;
                    tail++;
                }
            }
            if (j > 0) {
                grille[i][j-1] += nbTombes;
                if (grille[i][j-1] >= 4) {
                    queueX[tail] = i;
                    queueY[tail] = j-1;
                    tail++;
                }
            }
            if (j < largeur-1) {
                grille[i][j+1] += nbTombes;
                if (grille[i][j+1] >= 4) {
                    queueX[tail] = i;
                    queueY[tail] = j+1;
                    tail++;
                }
            }
        }
        
        return grille;
    }
    
    /**
     * Version optimisée pour les très grandes grilles
     * Utilise la même approche mais avec moins d'allocations mémoire
     */
    public static int[][] effondrerOptimized(int[][] bac) {
        if (bac == null || bac.length == 0 || bac[0].length == 0) {
            return bac;
        }
        
        int hauteur = bac.length;
        int largeur = bac[0].length;
        
        // Utilisation directe de la grille originale si possible
        int[][] grille = new int[hauteur][largeur];
        for (int i = 0; i < hauteur; i++) {
            System.arraycopy(bac[i], 0, grille[i], 0, largeur);
        }
        
        boolean changed = true;
        
        // Optimisation : plusieurs passes avec stockage des changements
        while (changed) {
            changed = false;
            
            for (int i = 0; i < hauteur; i++) {
                for (int j = 0; j < largeur; j++) {
                    if (grille[i][j] >= 4) {
                        changed = true;
                        int grains = grille[i][j];
                        int nbTombes = grains / 4;
                        grille[i][j] = grains % 4;
                        
                        if (i > 0) grille[i-1][j] += nbTombes;
                        if (i < hauteur-1) grille[i+1][j] += nbTombes;
                        if (j > 0) grille[i][j-1] += nbTombes;
                        if (j < largeur-1) grille[i][j+1] += nbTombes;
                    }
                }
            }
        }
        
        return grille;
    }
}
