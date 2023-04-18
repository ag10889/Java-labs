import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class assignment2 {
    public class Lot {

        private static int lotNumber = 1000;
        private String description;
        private int currentBid;
        private int bidIncrement;
        private boolean sold;

        public Lot() {
            lotNumber++;
            description = "Unknown Item";
            currentBid = 0;
            bidIncrement = 0;
            sold = false;
        }

        public Lot(String A, int B, int C) {
            lotNumber++;
            description = A;
            currentBid = B;
            bidIncrement = C;
            sold = false;
        }

        public void markSold() {
            sold = true;
        }

        public boolean getSold() {
            return sold;
        }

        public int getBidIn() {
            return bidIncrement;
        }

        public String getDes() {
            return description;
        }

        public void setBid(int A) {
            currentBid = A;
        }

        public int nextBid() {
            return currentBid + bidIncrement;
        }

        @Override
        public String toString() {
            if (getSold()) {
                return "Lot " + lotNumber + ". " + getDes() + " was sold for " + currentBid;
            } else {
                return "Lot " + lotNumber + ". " + getDes() + " current bid " + currentBid + " minimum bid " + nextBid();
            }
        }
    }


    public class LotTester {
        public static Lot getNextLot(List<Lot> A) {
            Lot tempLot = A.get(0);
            if (A.get(0).getDes().equals("Unknown Item")) {
                return A.get(0);
            } else {
                A.remove(0);
                return tempLot;
            }
        }

        public static void addItem(List<Lot> A) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter description of item:");
            String newDes = sc.nextLine();
            System.out.println("Enter current bid:");
            int newBid = Integer.parseInt(sc.nextLine());
            System.out.println("Enter bid increment:");
            int newInc = Integer.parseInt(sc.nextLine());
            Lot B = new Lot(newDes, newBid, newInc);
            A.add(B);
        }

        public static void bid(Lot A) {
            System.out.println("How much would you like to bid? The current minimum bid is " + A.nextBid());
            Scanner sc = new Scanner(System.in);
            int bid = Integer.parseInt(sc.nextLine());
            if (bid < A.nextBid()) {
                System.out.println("That bid is too small, you need to up it to " + A.nextBid());
            } else {
                A.setBid(bid);
            }
        }

        public static void markSold(Lot A) {
            A.markSold();
            System.out.println(A);
        }

        public static void mainMenu(List<Lot> A) {
            Lot currentLot = null;
            Scanner sc = new Scanner(System.in);
            int choice;
            do {
                System.out.println("1. Add Lot to Auction");
                System.out.println("2. Start bidding on next Lot");
                System.out.println("3. Bid of current Lot");
                System.out.println("4. Mark current Lot sold");
                System.out.println("5. Quit");
                choice = Integer.parseInt(sc.nextLine());

                if (choice == 1) {
                    System.out.println("Enter information about the item you would like to sell:");
                    addItem(A);
                    currentLot = A.get(0);
                } else if (choice == 2) {
                    if (currentLot == null) {
                        System.out.println("There is nothing to bid on, add an item first");
                    } else {
                        if (currentLot.getSold() != true) {
                            System.out.println("You must sell the previous Lot before proceeding");
                        } else {
                            currentLot = getNextLot(A);
                        }
                    }
                } else if (choice == 3) {
                    if (currentLot == null) {
                        System.out.println("You must bring up a lot to bid");
                    } else if (currentLot.getDes().equals("Unknown Item")) {
                        System.out.println("You must bring up an lot to bid on");
                    } else if (currentLot.getSold() == true) {
                        System.out.println("You must bring up a lot to bid on");
                    } else {
                        System.out.println("How much would you like to bid?");
                        int I = Integer.parseInt(sc.nextLine());
                        currentLot.setBid(I);
                    }
                } else if (choice == 4) {
                    if (currentLot == null) {
                        System.out.println("You must bring up a lot for sale");
                    } else if (currentLot.getDes().equals("Unknown Item")) {
                        System.out.println("You must bring up a lot for sale");
                    } else {
                        markSold(currentLot);
                    }
                }
            } while (choice < 5);
        }
    }
}
