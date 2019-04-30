public class EggDropping {
    static int [][] drops(int eggs, int floors){
        int[][] numDrops = new int[eggs+1][floors+1];

        //initialize matrix
        for(int i =0; i <= floors; i++){
            numDrops[0][i]=0;
            numDrops[1][i] = i;
        }
        for(int i = 0; i <= eggs; i++){
            numDrops[i][0]= 0;
        }

        for(int i =2; i <= eggs; i++){
            for(int j = 1; j <= floors; j++){
                int min = Integer.MAX_VALUE;
                for(int x = 1; x <= j; x++){
                    min = Math.min(min,
                            (1+ Math.max(numDrops[i][j-x], numDrops[i-1][x-1])));
                }
                numDrops[i][j] = min;
            }
        }

        return numDrops;
    }

    public static void main(String[] args){
        int eggs = Integer.parseInt(args[0]);
        int floors = Integer.parseInt(args[1]);

        int[][] dropsMatrix = drops(eggs, floors);

        System.out.println("Number of drops is: " + dropsMatrix[eggs][floors]);
    }
}
