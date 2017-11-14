package DvumernieMassive;
//задача 2
import java.util.Random;
import java.util.Scanner;

public class dvumernie {

    public static void showMatrix(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Random ran = new Random();
        Scanner sc = new Scanner(System.in);
        int matrix[][];
        int n, m;
        System.out.println("введите размеры матрицы");
        n = sc.nextInt();
        m = sc.nextInt();
        matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = ran.nextInt(30);
            }
        }
        showMatrix(matrix);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                matrix[i][j] = 0;
            }
        }
        System.out.println();
        System.out.println("переделанная матрица: ");
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}