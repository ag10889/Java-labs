public class Lab7 {
    public interface CalcOp {
        int add(int a, int b);
        int subtract(int a, int b);
        int multiply(int a, int b);
        int divide(int a, int b);
    }

    public class Calculator implements CalcOp {
        public Calculator() {}

        public int add(int a, int b) {
            System.out.print("These two numbers added equal: ");
            System.out.println(a + b);
            return a + b;
        }

        public int subtract(int a, int b) {
            System.out.print("These two numbers subtracted from each other equal: ");
            System.out.println(a - b);
            return a - b;
        }

        public int multiply(int a, int b) {
            System.out.print("These two numbers multiply to equal: ");
            System.out.println(a * b);
            return a * b;
        }

        public int divide(int a, int b) {
            System.out.print("These two numbers divided equal: ");
            System.out.println(a / b);
            return a / b;
        }
    }

}
