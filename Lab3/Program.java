public class Program {
    public class Question {
        private String questionText;
        private String answer;
        private int difficulty;

        public Question(String text, String answer, int diff) {
            questionText = text;
            this.answer = answer;
            difficulty = diff;
        }

        public String getQuestion() {
            return questionText;
        }

        public String getAnswer() {
            return answer;
        }

        public int getDifficulty() {
            return difficulty;
        }

        public void changeQuestion() {
            Scanner input = new Scanner(System.in);
            questionText = input.nextLine();
        }

        public void changeAnswer() {
            Scanner input = new Scanner(System.in);
            answer = input.nextLine();
        }

        public void changeDifficulty() {
            Scanner input = new Scanner(System.in);
            int a = input.nextInt();
            if (a > 3) {
                System.out.println("That's too hard");
            } else {
                difficulty = a;
            }
        }
    }
import java.util.ArrayList;
        import java.util.List;
        import java.util.Scanner;

    public class QuizClass {

        private List<Question> questionBank = new ArrayList<>();

        public void addQuestion(String questionText, String answer, int diff) {
            Question q = new Question(questionText, answer, diff);
            questionBank.add(q);
        }

        public void removeQuestion() {
            int num = 1;
            for (int i = 0; i < questionBank.size(); i++) {
                System.out.println(num++ + " " + questionBank.get(i).getQuestion());
            }
            System.out.println("Which question would you like to remove?");
            Scanner scanner = new Scanner(System.in);
            String remove = scanner.nextLine();
            for (int i = questionBank.size() - 1; i >= 0; i--) {
                if (questionBank.get(i).getQuestion().equals(remove)) {
                    questionBank.remove(i);
                }
            }
        }

        public void modifyQuestion() {
            int num = 1;
            for (int i = 0; i < questionBank.size(); i++) {
                System.out.println(num++ + " " + questionBank.get(i).getQuestion());
            }
            System.out.println("Which question would you like to change?");
            Scanner scanner = new Scanner(System.in);
            String change = scanner.nextLine();
            System.out.println("Enter the new question");
            String changeQuestion = scanner.nextLine();
            System.out.println("Enter the new answer");
            String changeAnswer = scanner.nextLine();
            System.out.println("Enter the new difficulty");
            int changeDiff = Integer.parseInt(scanner.nextLine());
            for (int i = questionBank.size() - 1; i >= 0; i--) {
                if (questionBank.get(i).getQuestion().equals(change)) {
                    questionBank.set(i, new Question(changeQuestion, changeAnswer, changeDiff));
                }
            }
        }

        public void giveQuiz() {
            int correct = 0;
            int score = questionBank.size();
            String answer;
            for (int i = 0; i < questionBank.size(); i++) {
                System.out.println(questionBank.get(i).getQuestion());
                Scanner scanner = new Scanner(System.in);
                answer = scanner.nextLine();
                score++;
                if (answer.equals(questionBank.get(i).getAnswer())) {
                    correct++;
                    System.out.println("You got it right!");
                } else {
                    System.out.println("You got it wrong :(");
                }
            }
            System.out.println("You got " + correct + " right");
        }

        private static class Question {
            private String questionText;
            private String answer;
            private int difficulty;

            public Question(String text, String answer, int diff) {
                questionText = text;
                this.answer = answer;
                difficulty = diff;
            }

            public String getQuestion() {
                return questionText;
            }

            public String getAnswer() {
                return answer;
            }

            public int getDifficulty() {
                return difficulty;
            }

            public void changeQuestion() {
                Scanner scanner = new Scanner(System.in);
                questionText = scanner.nextLine();
            }

            public void changeAnswer() {
                Scanner scanner = new Scanner(System.in);
                answer = scanner.nextLine();
            }

            public void changeDifficulty() {
                Scanner scanner = new Scanner(System.in);
                int a = Integer.parseInt(scanner.nextLine());
                if (a > 3) {
                    System.out.println("Thats too hard");
                } else {
                    difficulty = a;
                }
            }
        }
    }

    public class Main {
        public static void main(String[] args) {
            QuizClass newQuiz = new QuizClass();

            int choice;
            do {
                Scanner input = new Scanner(System.in);
                System.out.println("1. Add a question to the quiz");
                System.out.println("2. Remove a question from the quiz");
                System.out.println("3. Modify a question in the quiz");
                System.out.println("4. Take the quiz");
                System.out.println("5. Quit");
                choice = input.nextInt();

                if (choice == 1) {
                    System.out.println("What is the question text?");
                    String questionText = input.nextLine();
                    System.out.println("What is the question answer?");
                    String questionAnswer = input.nextLine();
                    System.out.println("What is the question difficulty?");
                    int questionDiff = input.nextInt();
                    newQuiz.add_question(questionText, questionAnswer, questionDiff);
                } else if (choice == 2) {
                    newQuiz.remove_question();
                } else if (choice == 3) {
                    newQuiz.modify_question();
                } else if (choice == 4) {
                    newQuiz.give_quiz();
                }
            } while (choice < 5);
        }
    }
}
