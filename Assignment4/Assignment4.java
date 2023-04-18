import java.util.Scanner;
public class Assignment4
{
    public interface ISpeak {
        String greeting();
        String getInformation();
        String sayGoodbye();
    }
    public class Room {
        static int nextRoomNum = 1;
        int roomNum;
        Character personInRoom;

        public Room() {
            roomNum = nextRoomNum++;
            if (roomNum == 1) {
                personInRoom = new CharacterOne();
            } else if (roomNum == 2) {
                personInRoom = new CharacterTwo();
            } else {
                personInRoom = new CharacterThree();
            }
            System.out.println("Welcome to room number " + roomNum);
            System.out.println("In here we have a fascinating character from popular movies...");
            System.out.println("Movie character, please tell us a little about yourself...");
            System.out.println();
            System.out.println(" " + personInRoom.getDescription());
            System.out.println(" " + personInRoom.greeting());
            System.out.println();
        }

        public void askForSecret() {
            System.out.println("Okay, movie character, tell me a secret");
            System.out.println();
            System.out.println(" " + personInRoom.getInformation());
            System.out.println();
        }

        public void sayGoodbye() {
            System.out.println("Thank you " + personInRoom.getCharacterName());
            System.out.println();
        }

        public void guessWho(String nameGuess) {
            if (personInRoom.guessWho(nameGuess)) {
                System.out.println("Congratulations you guessed " + nameGuess + " correctly.");
                System.out.println(" " + personInRoom.getCharacterName() + " says " + personInRoom.sayGoodbye());
            } else {
                System.out.println("I'm sorry it's not " + nameGuess + " it was " + personInRoom.getCharacterName());
                System.out.println(" " + personInRoom.getCharacterName() + " says " + personInRoom.sayGoodbye());
            }
        }
    }
    public abstract class Character implements ISpeak {
        private String description;
        private String whoami;

        public Character(String d, String w) {
            description = d;
            whoami = w;
        }

        public String getDescription() {
            return description;
        }

        public boolean guessWho(String guess) {
            String lowerGuess = guess.toLowerCase();
            String rightAns = whoami.toLowerCase();
            return lowerGuess.equals(rightAns);
        }

        public String getCharacterName() {
            return whoami;
        }

        public abstract String greeting();
        public abstract String getInformation();
        public abstract String sayGoodbye();
    }
    public class CharacterOne extends Character {
        public CharacterOne() {
            super("I am a famous detective and my name rhymes with Jeroi Rolmes.", "Sherlock Holmes");
        }

        @Override
        public String greeting() {
            return "Hello, I am " + getCharacterName();
        }

        @Override
        public String getInformation() {
            return "I have a brilliant mind and have solved many complex cases.";
        }

        @Override
        public String sayGoodbye() {
            return "Goodbye, I must go solve another case now.";
        }
    }

    public class CharacterTwo extends Character {

        public CharacterTwo() {
            super("I am a powerful Jedi and my name rhymes with Muke Kywalker.", "Luke Skywalker");
        }

        @Override
        public String greeting() {
            return "May the force be with you, I am " + getCharacterName();
        }

        @Override
        public String getInformation() {
            return "I am a skilled warrior and have fought against the evil empire.";
        }

        @Override
        public String sayGoodbye() {
            return "May the force be with you always.";
        }
    }
    public class CharacterThree extends Character {

        public CharacterThree() {
            super("I am a pirate and my name rhymes with Jack Spaniel.", "Jack Sparrow");
        }

        @Override
        public String greeting() {
            return "Ahoy matey, I am " + getCharacterName();
        }

        @Override
        public String getInformation() {
            return "I am the captain of the Black Pearl and have searched for treasure all over the world.";
        }

        @Override
        public String sayGoodbye() {
            return "Farewell, until we meet again.";
        }
    }

    public class Driver {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            for (int i = 0; i < 3; i++) {
                Room newRoom = new Room();
                System.out.println("If you know who it is guess, if you don't type hint");
                String theGuess = input.nextLine();
                if (theGuess.equals("hint")) {
                    newRoom.askForSecret();
                    System.out.println("OK, so who is it?");
                    String finalGuess = input.nextLine();
                    newRoom.guessWho(finalGuess);
                } else {
                    newRoom.guessWho(theGuess);
                }
            }
            input.close();
        }
    }

}
