import java.util.Scanner;


public class Lab2Task {
    public static int ROW = 2;
    public static int COL = 2;


    public static void main(String[] args){

        int originalMatrixA[][] = new int[ROW][COL];
        int originalMatrixB[][] = new int[ROW][COL];
        int outputMatrix[][] = new int[ROW][COL];


        getMatrix('A', originalMatrixA);
        getMatrix('B', originalMatrixB);

        System.out.println("\nThe original matrix A is:\n");
        print(originalMatrixA);

        System.out.println("\nThe original matrix B is:\n");
        print(originalMatrixB);

        matrixMultiply(originalMatrixA, originalMatrixB, outputMatrix);
        System.out.println("\nthe multiplied output matrix is:\n");
        print(outputMatrix);
    }
    public static void getMatrix(char s , int original[][]){
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<ROW; i++) {
            for(int j=0; j<COL;  j++) {
                System.out.println("Matrix "+s+"["+i+"]["+j+"]");
                original[i][j] = sc.nextInt();
            }
        }
    }

    public static void matrixMultiply(final int originalMatrixA[][], final int originalMatrixB[][], int outputMatrix[][]) {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                outputMatrix[i][j] = 0;
                for (int k = 0; k < ROW; k++) {
                    outputMatrix[i][j] = outputMatrix[i][j] + originalMatrixA[i][k] * originalMatrixB[k][j];
                }
            }

        }
    }

    public static void print(int original[][]){
        for (int i = 0; i < ROW; i++) {
            for(int j = 0; j < COL; j++)
                System.out.println(original[i][j]+ "\n");
        }
        System.out.println("\n");
    }

}
