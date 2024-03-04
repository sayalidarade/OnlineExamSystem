import java.util.ArrayList;
import java.util.Scanner;

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

class Question {
    private String questionText;
    private ArrayList<String> options;
    private int correctOption;

    public Question(String questionText, ArrayList<String> options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }

    public String getQuestionText() {
        return questionText;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public int getCorrectOption() {
        return correctOption;
    }
}

class Examination {
    private ArrayList<Question> questions;
    private ArrayList<Integer> userAnswers;

    public Examination(ArrayList<Question> questions) {
        this.questions = questions;
        this.userAnswers = new ArrayList<>();
    }

    public void conductExam() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < questions.size(); i++) {
            Question currentQuestion = questions.get(i);

            // Display the question
            System.out.println((i + 1) + ". " + currentQuestion.getQuestionText());
            ArrayList<String> options = currentQuestion.getOptions();
            for (int j = 0; j < options.size(); j++) {
                System.out.println("   " + (j + 1) + ". " + options.get(j));
            }

            // Get user's answer
            System.out.print("Your answer: ");
            int userAnswer = scanner.nextInt();
            userAnswers.add(userAnswer);
        }

        // Display the user's answers
        System.out.println("Your answers: " + userAnswers);
    }
}

public class OnlineExamSystem {
    private static ArrayList<User> users = new ArrayList<>();
    private static ArrayList<Examination> exams = new ArrayList<>();

    public static void main(String[] args) {
        // Example usage

        // Create users
        User user1 = new User("user1", "password1");
        User user2 = new User("user2", "password2");
        users.add(user1);
        users.add(user2);

        // Create questions
        ArrayList<String> options1 = new ArrayList<>();
        options1.add("Option A:canberra");
        options1.add("Option B:paris");
        options1.add("Option C:berlin");
        options1.add("Option D:mumbai");
        Question question1 = new Question("What is the capital of France?", options1, 2);
        

         ArrayList<String> options2 = new ArrayList<>();
        options2.add("Option A:washington D.C");
        options2.add("Option B:paris");
        options2.add("Option C:canberra");
        options2.add("Option D:Tokyo");
        Question question2 = new Question("What is the capital of Japan?", options2, 3);

         ArrayList<String> options3 = new ArrayList<>();
        options3.add("Option A:Washington D.C");
        options3.add("Option B:Mumbai");
        options3.add("Option C:Delhi");
        options3.add("Option D:paris");
        Question question3 = new Question("What is the capital of America?", options3, 4);

        ArrayList<String> options4 = new ArrayList<>();
        options4.add("Option A:blue whale");
        options4.add("Option B:dolphin");
        options4.add("Option C:bat");
        options4.add("Option D:panda");
        Question question4 = new Question("What is the largest mammal in the world?", options4, 1);

        // Create an exam
        ArrayList<Question> examQuestions = new ArrayList<>();
        examQuestions.add(question1);
        examQuestions.add(question2);
        examQuestions.add(question3);
        examQuestions.add(question4);
        Examination exam = new Examination(examQuestions);
        exams.add(exam);

        // Simulate user login
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String usernameInput = scanner.nextLine();
        System.out.print("Enter password: ");
        String passwordInput = scanner.nextLine();

        // Check if the user exists
        User loggedInUser = login(usernameInput, passwordInput);
        if (loggedInUser != null) {
            System.out.println("Login successful!");

            // Simulate exam
            exam.conductExam();
        } else {
            System.out.println("Invalid credentials. Login failed.");
        }
    }

    private static User login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}
