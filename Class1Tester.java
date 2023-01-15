public class Class1Tester {
    public static void main(String[] args) {
        char[][] carArray = Class1.make_forward();
        for (int row = 0; row < carArray.length; row++) {
            for (int column = 0; column < carArray[row].length; column++) {
                /*if (carArray[row][column] == carArray[row][carArray[row].length-1]) {
                    System.out.println(carArray[row][column]); To grey out the code for the if statement if code if goood
                } else { */
                    System.out.print(carArray[row][column]);
                //}
            }
        }
        System.out.println(" ");
        System.out.print(Class1.make_mirror(carArray));
    }
}
