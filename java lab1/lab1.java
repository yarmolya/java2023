import java.util.Scanner;

public class lab1 {
    public static final int C = 2;

    public static double Solution(int a, int b, int n, int m) {
        double sum = 0.0;

        for (char i = (char) a; i <= n; i++) {
            for (char j = (char) b; j <= m; j++) {
                double numerator = i - 2 * j;
                double denominator = i + C;

                if (denominator != 0) {
                    sum += numerator / denominator;
                } else {
                    System.err.println("Division by zero");
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int num = 1334;
        int c2 = num % 2;
        int c3 = num % 3;
        int c5 = num % 5;
        int c7 = num % 7;
        int a = 0, b = 0, n = 0, m = 0;

        System.out.println("Number of a student: " + num);
        System.out.println("C2: " + c2);
        System.out.println("C3: " + c3);
        System.out.println("C5: " + c5);
        System.out.println("C7: " + c7);
        System.out.println("C: " + C);

        try (Scanner scan = new Scanner(System.in)) {
            while (true) {
                try {
                    System.out.print("Enter a: ");
                    a = scan.nextInt();
                    
                    System.out.print("Enter n: ");
                    n = scan.nextInt();
                    
                    if (a <= 0 || n <= 0 || a >= n) {
                        System.out.println("Values must be greater than zero and a < n!");
                        continue;
                    }
        
                    break; 
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Please enter a valid integer for a and n.");
                    scan.nextLine(); 
                }
            }
        
            while (true) {
                try {
                    System.out.print("Enter b: ");
                    b = scan.nextInt();
                    
                    System.out.print("Enter m: ");
                    m = scan.nextInt();
                    
                    if (b <= 0 || m <= 0 || b >= m) {
                        System.out.println("Values must be greater than zero and b < m!");
                        continue;
                    }
        
                    break; 
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Please enter a valid integer for b and m.");
                    scan.nextLine(); 
                }
            }
            
            double result = Solution(a, b, n, m);
            System.out.println("Result: " + result);
        }
        
    }
}
