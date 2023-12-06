import java.util.Scanner;

public class MatrixOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введіть кількість рядків матриці А: ");
            int rowsA = scanner.nextInt();
            System.out.print("Введіть кількість стовпців матриці А: ");
            int colsA = scanner.nextInt();

            System.out.print("Введіть кількість рядків матриці В: ");
            int rowsB = scanner.nextInt();
            System.out.print("Введіть кількість стовпців матриці В: ");
            int colsB = scanner.nextInt();

            if (colsA != rowsB) {
                System.out.println("Помилка: Кількість стовпців матриці A повинна бути рівною кількості рядків матриці В.");
                return;
            }

            char[][] matrixA = new char[rowsA][colsA];
            char[][] matrixB = new char[rowsB][colsB];

            System.out.println("Введіть матрицю А:");
            for (int i = 0; i < rowsA; i++) {
                for (int j = 0; j < colsA; j++) {
                    matrixA[i][j] = scanner.next().charAt(0);
                }
            }

            System.out.println("Введіть матрицю В:");
            for (int i = 0; i < rowsB; i++) {
                for (int j = 0; j < colsB; j++) {
                    matrixB[i][j] = scanner.next().charAt(0);
                }
            }

            char[][] matrixC = multiplyMatrices(matrixA, matrixB);

            System.out.println("Результат множення матриці А на матрицю В:");
            printMatrix(matrixC);

            int[] maxColumnSum = calculateMaxColumnSum(matrixC);
            System.out.println("Сума найбільших елементів у кожному стовпці матриці C:");
            for (int i = 0; i < maxColumnSum.length; i++) {
                System.out.println("Стовпець " + i + ": " + maxColumnSum[i]);
            }
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static char[][] multiplyMatrices(char[][] matrixA, char[][] matrixB) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int colsB = matrixB[0].length;

        char[][] result = new char[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += (matrixA[i][k] * matrixB[k][j]);
                }
            }
        }

        return result;
    }

    public static int[] calculateMaxColumnSum(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] maxColumnSum = new int[cols];

        for (int j = 0; j < cols; j++) {
            char max = Character.MIN_VALUE;
            for (int i = 0; i < rows; i++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
            maxColumnSum[j] = max;
        }

        return maxColumnSum;
    }

    public static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print((int)matrix[i][j] + " ");
            }
            System.out.print(' ');

            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

       

    }
}