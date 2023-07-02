public class Q12023a {

    public static int friend3(int[][] mat){
        return friend3(mat, 0,1,2,0);
    }

    public static int friend3(int[][] mat, int i, int j, int k, int sum){
        if(k>mat.length-1){
            j++;
            k=j+1;
        }
        if(j>mat.length-2){
            i++;
            j=i+1;
            k=i+2;
        }
        if(i> mat.length-3)
            return sum;
        if(mat[i][j] == 1 && mat[i][k] == 1 && mat[j][k] ==1){
            System.out.println(i + " " + j + " " + k);
            sum++;
        }
        return friend3(mat, i,j,k+1, sum);
    }

    public static void main(String[] args) {
        int rows = 10;
        int cols = 10;
        int[][] matrix = new int[rows][cols];
        matrix[0][0] = 0;
        matrix[0][1] = 1;
        matrix[0][2] = 1;
        matrix[0][3] = 0;
        matrix[0][4] = 0;
        matrix[0][5] = 1;
        matrix[0][6] = 1;
        matrix[0][7] = 0;
        matrix[0][8] = 0;
        matrix[0][9] = 0;
        matrix[1][0] = 1;
        matrix[1][1] = 0;
        matrix[1][2] = 1;
        matrix[1][3] = 1;
        matrix[1][4] = 0;
        matrix[1][5] = 0;
        matrix[1][6] = 0;
        matrix[1][7] = 0;
        matrix[1][8] = 0;
        matrix[1][9] = 1;
        matrix[2][0] = 1;
        matrix[2][1] = 1;
        matrix[2][2] = 0;
        matrix[2][3] = 0;
        matrix[2][4] = 0;
        matrix[2][5] = 1;
        matrix[2][6] = 1;
        matrix[2][7] = 0;
        matrix[2][8] = 0;
        matrix[2][9] = 1;
        matrix[3][0] = 0;
        matrix[3][1] = 1;
        matrix[3][2] = 0;
        matrix[3][3] = 0;
        matrix[3][4] = 0;
        matrix[3][5] = 0;
        matrix[3][6] = 1;
        matrix[3][7] = 1;
        matrix[3][8] = 0;
        matrix[3][9] = 0;
        matrix[4][0] = 0;
        matrix[4][1] = 0;
        matrix[4][2] = 0;
        matrix[4][3] = 0;
        matrix[4][4] = 0;
        matrix[4][5] = 0;
        matrix[4][6] = 0;
        matrix[4][7] = 0;
        matrix[4][8] = 0;
        matrix[4][9] = 1;
        matrix[5][0] = 1;
        matrix[5][1] = 0;
        matrix[5][2] = 1;
        matrix[5][3] = 0;
        matrix[5][4] = 0;
        matrix[5][5] = 0;
        matrix[5][6] = 0;
        matrix[5][7] = 1;
        matrix[5][8] = 1;
        matrix[5][9] = 0;
        matrix[6][0] = 1;
        matrix[6][1] = 0;
        matrix[6][2] = 1;
        matrix[6][3] = 1;
        matrix[6][4] = 0;
        matrix[6][5] = 0;
        matrix[6][6] = 0;
        matrix[6][7] = 1;
        matrix[6][8] = 1;
        matrix[6][9] = 0;
        matrix[7][0] = 0;
        matrix[7][1] = 0;
        matrix[7][2] = 0;
        matrix[7][3] = 1;
        matrix[7][4] = 0;
        matrix[7][5] = 1;
        matrix[7][6] = 1;
        matrix[7][7] = 0;
        matrix[7][8] = 0;
        matrix[7][9] = 1;
        matrix[8][0] = 0;
        matrix[8][1] = 0;
        matrix[8][2] = 0;
        matrix[8][3] = 0;
        matrix[8][4] = 0;
        matrix[8][5] = 1;
        matrix[8][6] = 1;
        matrix[8][7] = 0;
        matrix[8][8] = 0;
        matrix[8][9] = 0;
        matrix[9][0] = 0;
        matrix[9][1] = 1;
        matrix[9][2] = 1;
        matrix[9][3] = 0;
        matrix[9][4] = 1;
        matrix[9][5] = 0;
        matrix[9][6] = 0;
        matrix[9][7] = 1;
        matrix[9][8] = 0;
        matrix[9][9] = 0;


        printMat(matrix);

        int result = friend3(matrix);
        System.out.println("total friend3 is: " + result);
    }

    public static void printMat(int[][]matrix){
        for(int row=0; row < matrix.length; row++){
            for(int col=0; col<matrix[0].length; col++){
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println("");
        }
    }
}
