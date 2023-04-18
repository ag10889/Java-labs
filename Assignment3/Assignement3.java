public class Assignement3 {
    public abstract class Customer {
        private char letter;
        private int number;
        private static int intA = 0;
        private static int intB = 0;
        private static int intC = 0;
        private static int intD = 0;

        public Customer() {
            letter = 'x';
            number = 0;
            // Used for error shooting
        }

        public Customer(char x) {
            if (x == 'A') {
                letter = x;
                intA++;
            } else if (x == 'B') {
                letter = x;
                intB++;
            } else if (x == 'C') {
                letter = x;
                intC++;
            } else if (x == 'D') {
                letter = x;
                intD++;
            } else {
                letter = 'X';
                System.out.println("Letter can only be A, B, C or D");
            }
        }

        protected String getTicketNumber() {
            return String.valueOf(letter) + number;
        }
        public abstract String getCustomerInfo();
    }
    public Move(String name, String state) {
        super('C');
        this.name = name;
        this.state = state;
    }

    public String getCustomerInfo() {
        return "Moved from " + state + ". " + "Ticket Number " + getTicketNumber() + ". Name: " + name;
    }
public class NewTest extends Customer {
    private String cusName;
    private String DOB;

    public NewTest(String name, String birth) {
        super('A');
        cusName = name;
        DOB = birth;
    }
    public String getCustomerInfo() {
        return "New Drivers' license. Ticket Number " + getTicketNumber() + ". Name: " + cusName + " " + "DOB " + DOB;
    }
}
public class Renew extends Customer {
    private String name;

    public Renew(String name) {
        super('B');
        this.name = name;
    }

    public String getCustomerInfo() {
        return "Renewal license. Ticket number " + getCustomerInfo() + " " + "Name: " + name;
    }
}
    public class Suspended extends Customer {
        private String name;
        private String violation;

        public Suspended(String name, String violation) {
            super('D');
            this.name = name;
            this.violation = violation;
        }

        @Override
        public String getCustomerInfo() {
            return "Violation " + violation + ". Ticket Number: " + getTicketNumber() + ". Name: " + name;
        }
    }

}

