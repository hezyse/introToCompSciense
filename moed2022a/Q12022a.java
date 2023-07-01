public class Q12022a {
    public static int lengthPath(char[][] mat, String pattern){

        return lengthPath(mat, pattern, 0, 0);
    }

    public static int lengthPath(char[][] mat, String pattern, int row, int col){
        if(pattern.indexOf(mat[row][col]) == -1){
            return 0;
        }

        int len1=0;
        int len2=0;
        if(col < mat[0].length) {
            len1 = 1 + lengthPath(mat, pattern, row, col + 1);
        }
        if(row < mat.length) {
            len2 = 1 + lengthPath(mat, pattern, row + 1, col);
        }

        return Math.max(len1, len2);
    }




    public static void main(String[] args) {
        int rows = 5;
        int cols = 6;
        char[][] matrix = new char[rows][cols];
        matrix[0][0] = 'a';
        matrix[0][1] = 'c';
        matrix[0][2] = 'b';
        matrix[0][3] = 'c';
        matrix[0][4] = '@';
        matrix[0][5] = 'a';
        matrix[1][0] = 'b';
        matrix[1][1] = 'x';
        matrix[1][2] = 'z';
        matrix[1][3] = 'c';
        matrix[1][4] = 's';
        matrix[1][5] = 'a';
        matrix[2][0] = '?';
        matrix[2][1] = 'c';
        matrix[2][2] = 'd';
        matrix[2][3] = '*';
        matrix[2][4] = 'c';
        matrix[2][5] = 'd';
        matrix[3][0] = 'b';
        matrix[3][1] = 'c';
        matrix[3][2] = 'a';
        matrix[3][3] = '8';
        matrix[3][4] = 'b';
        matrix[3][5] = 'b';
        matrix[4][0] = 'c';
        matrix[4][1] = '2';
        matrix[4][2] = 'x';
        matrix[4][3] = '+';
        matrix[4][4] = 'b';
        matrix[4][5] = 'c';

        printMat(matrix);

        int result = lengthPath(matrix, "abc");
        System.out.println("max is: " + result);
    }

    public static void printMat(char[][]matrix){
        for(int row=0; row < matrix.length; row++){
            for(int col=0; col<matrix[0].length; col++){
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println("");
        }
    }
}
