package iut.sae.algo.simplicite.etu55;


/**
 * Cette classe fournit un algorithme simple pour simuler 
 * un effondrement de tas de sable.
 * 
 * L'algorithme met en oeuvre un parcours naïf et donc parcours de l'intégralité 
 * de la grille à chaque itération, privilégiant la clarté du code et une 
 * lecture directe des règles d'effondrement sans optimisations complexes.
 * */
public class TasDeSable {
    /**
     * Simule l'effondrement en chaîne d'un tas de sable contenu dans un bac, 
     * en parcourant l'intégralité du tableau de manière naïve jusqu'à 
     * sa stabilisation complète.
     */
    public static int[][] effondrer(int bac[][]) {
        
        int h = bac.length;
        int l = bac[0].length;
        boolean run = true;
        
        //Si changement effectuer on recommence
        while (run) {
            run = false;
            //Parcour du bac de haut en bas et de droite à gauche
            for(int i = 0;i<h;i++){
                for(int j = 0;j<l;j++){
                    //Effondrement Haut
                    if(i-1 >= 0 && bac[i][j]>bac[i-1][j]+1){
                        bac[i][j]--;
                        bac[i-1][j]++;
                        run = true;
                    }
                    //Effondrement Droite
                    if(j+1 < l && bac[i][j]>bac[i][j+1]+1){
                        bac[i][j]--;
                        bac[i][j+1]++;
                        run = true;
                    }
                    //Effondrement Bas
                    if(i+1 < h && bac[i][j]>bac[i+1][j]+1){
                        bac[i][j]--;
                        bac[i+1][j]++;
                        run = true;

                    }
                    //Effondrement Gauche
                    if(j-1 >= 0 && bac[i][j]>bac[i][j-1]+1){
                        bac[i][j]--;
                        bac[i][j-1]++;
                        run = true;
                    }             
                }
            }
        }
        return bac; 

    }

    
}
