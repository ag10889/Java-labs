import java.util.Scanner;
public class Lab4 {
    public class Account {
        private final int accountNum;
        private double accountBal;

        public Account() {
            accountBal = 0;
            accountNum = 0;
        }

        public Account(int accountNum, double accountBal) {
            this.accountNum = accountNum;
            this.accountBal = accountBal;
        }

        public double withdraw(double A) {
            return accountBal - A;
        }

        public double deposit(double A) {
            return accountBal + A;
        }

        public double getAccountBalance() {
            return accountBal;
        }

        public void setAccountBalance(double accountBal) {
            this.accountBal = accountBal;
        }

        public int getAccountNumber() {
            return accountNum;
        }
    }
    public class Checking extends Account {
        public Checking() {
            accountBal = 0;
        }

        public Checking(double A) {
            accountBal = A;
        }

        public double withdraw(double A) {
            if (accountBal - A < 0) {
                System.out.println("Charging an overdraft fee of $20 due to $0 in balance");
                return accountBal - 20;
            } else {
                return accountBal - A;
            }
        }
    }
    public class Savings extends Account {
        public Savings() {
            accountBal = 0;
        }

        public Savings(double A) {
            accountBal = A;
        }

        public double withdrawl(double A) {
            if (accountBal - A < 500.00) {
                System.out.println("Charging $10 due to an overdraft with $500 or less in the bank");
                return (accountBal -= A -= 10.00);
            } else {
                return (accountBal -= A);
            }
        }

        public double deposit(int A) {
            int count = 1;
            if (count < 6) {
                accountBal += A;
                System.out.println("This is deposit " + count + " to this account");
                count++;
                return accountBal;
            } else {
                System.out.println("Charging a $10 depost fee");
                accountBal -= 10;
                accountBal += A;
                return accountBal;
            }
        }

        public double interest() {
            double interest = accountBal * 0.015;
            accountBal += interest;
            System.out.println("Your account earned " + interest + " over the year");
            return accountBal;
        }
    }

    public class Program {

        public static void main(String[] args) {
            Checking checking = new Checking();
            Savings saving = new Savings();
            int choice;
            Scanner input = new Scanner(System.in);

            do {
                System.out.println("1. Withdraw from checking");
                System.out.println("2. Withdraw from savings");
                System.out.println("3. Deposit to checking");
                System.out.println("4. Deposit to savings");
                System.out.println("5. Check balance of checking");
                System.out.println("6. Check balance of savings");
                System.out.println("7. Apply earned interest");
                System.out.println("8. Quit");

                choice = input.nextInt();

                if (choice == 1) {
                    System.out.println("Enter how much you would like to withdraw");
                    double amount = input.nextDouble();
                    checking.withdrawl(amount);

                } else if (choice == 2) {
                    System.out.println("Enter how much you would like to withdraw");
                    double amount = input.nextDouble();
                    saving.withdrawl(amount);
                } else if (choice == 3) {
                    System.out.println("Enter how much you would like to deposit");
                    double amount = input.nextDouble();
                    checking.deposit(amount);
                } else if (choice == 4) {
                    System.out.println("Enter how much you would like to deposit");
                    double amount = input.nextDouble();
                    saving.deposit(amount);
                } else if (choice == 5) {
                    System.out.println(checking.getAccountBal());
                } else if (choice == 6) {
                    System.out.println(saving.getAccountBal());
                } else if (choice == 7) {
                    System.out.println(saving.interest());
                } else if (choice > 8) {
                    System.out.println("Enter valid operation");
                }
            } while (choice != 8);

            input.close();
        }
    }
}
