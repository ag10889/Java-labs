import java.util.Scanner;
public class Lab6 {
    public interface FindFib {
        public int calculate_fib(int n);
    }
    public class FibIteration implements FindFib {
        public int calculate_fib(int n) {
            if (n == 0) return 0;
            if (n == 1) return 1;

            int prevPrev = 0, prev = 1, curr = 1;

            for (int i = 2; i <= n; i++) {
                curr = prevPrev + prev;
                prevPrev = prev;
                prev = curr;
            }

            return curr;
        }
        public FibIteration() {
        }
    }
    public class FibFormula implements FindFib {
        public int calculate_fib(int n) {
            double phi = (1 + Math.sqrt(5)) / 2;
            double psi = (1 - Math.sqrt(5)) / 2;
            double Fn = (Math.pow(phi, n) - Math.pow(psi, n)) / Math.sqrt(5);
            return (int)Fn;
        }

        public FibFormula() {
        }
    }
    public class Program {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Which Fibonacci number would you like to find?");
            int n = sc.nextInt();

            FindFib a = new FibIteration();
            FindFib b = new FibFormula();

            System.out.println("Using iteration: " + a.calculate_fib(n));
            System.out.println("Using formula: " + b.calculate_fib(n));
        }
    }
}
