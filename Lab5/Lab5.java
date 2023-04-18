public class Lab5 {
    package Lab5;

    public class Book extends Item {
        private int ISBN_number;
        private String author;

        public Book() {}

        public Book(int A, String b, String c) {
            ISBN_number = A;
            author = b;
            title = c;
        }

        @Override
        public String getListing() {
            return title + author + ISBN_number;
        }
    }
    public abstract class Item {
        protected String title;

        public Item() {
            title = " ";
        }

        public Item(String title) {
            this.title = title;
        }

        public abstract String getListing();

        @Override
        public String toString() {
            return title;
        }
    }
package Lab5;

    public class Periodical extends Item {
        private int issueNum;

        public Periodical() {

        }

        public Periodical(int issueNum, String title) {
            this.issueNum = issueNum;
            this.title = title;
        }

        @Override
        public String getListing() {
            return issueNum + title;
        }
    }
import java.util.Scanner;

    public class Driver {
        public static void main(String[] args) {
            Item[] array = new Item[5];
            Scanner scanner = new Scanner(System.in);

            for (int i = 0; i < 5; i++) {
                System.out.println("Please enter B for book or P for periodical");
                String choice = scanner.nextLine();

                if (choice.equals("B")) {
                    System.out.println("Please enter the title, author and ISBN number");
                    String title = scanner.nextLine();
                    String author = scanner.nextLine();
                    int ISBN_num = Integer.parseInt(scanner.nextLine());
                    array[i] = new Book(ISBN_num, author, title);
                } else if (choice.equals("P")) {
                    System.out.println("Please enter the Issue Number and title");
                    int issueNum = Integer.parseInt(scanner.nextLine());
                    String title = scanner.nextLine();
                    array[i] = new Periodical(issueNum, title);
                }
            }

            for (int i = 0; i < 5; i++) {
                System.out.println(array[i].getListing());
            }
        }
    }

}
