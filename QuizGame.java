
// Here's a basic Java implementation for the described functionality:

// ```java
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class QuizGame 
{
    public static void main(String[] args) {
        ArrayList<QuizQuestion> questions = new ArrayList<>();
        ArrayList<String> options1 = new ArrayList<>();
        options1.add("A. Poundecherry");
        options1.add("B. Bangelore");
        options1.add("C. Delhi");
        options1.add("D. Mumbai");
        questions.add(new QuizQuestion("What is the capital of India?", options1, 2)); // Correct answer is C

        ArrayList<String> options2 = new ArrayList<>();
        options2.add("A. 3");
        options2.add("B. 2");
        options2.add("C. 7");
        options2.add("D. 4");
        questions.add(new QuizQuestion("What is 2+2?", options2, 3)); // Correct answer is D

        QuizGame quiz = new QuizGame(questions);
        quiz.start();
    }
    private ArrayList<QuizQuestion> questions;
    private int currentQuestionIndex;
    private int score;
    private Timer timer;

    public QuizGame(ArrayList<QuizQuestion> questions) 
    {
        this.questions = questions;
        currentQuestionIndex = 0;
        score = 0;
        timer = new Timer();
    }

    public void start() {
        displayQuestion();
    }

    private void displayQuestion() {
        if (currentQuestionIndex < questions.size()) {
            QuizQuestion currentQuestion = questions.get(currentQuestionIndex);
            System.out.println("Question: " + currentQuestion.getQuestion());
            ArrayList<String> options = currentQuestion.getOptions();
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }
            System.out.print("Enter your answer (1-" + options.size() + "): ");
            Scanner scanner = new Scanner(System.in);
            int selectedOption = scanner.nextInt();
            checkAnswer(selectedOption - 1, currentQuestion);
        } else {
            endQuiz();
        }
    }

    private void checkAnswer(int selectedOptionIndex, QuizQuestion currentQuestion) {
        if (selectedOptionIndex == currentQuestion.getCorrectOptionIndex()) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Incorrect. Correct answer is option " + (currentQuestion.getCorrectOptionIndex() + 1));
        }
        currentQuestionIndex++;
        displayQuestion();
    }

    private void endQuiz() {
        timer.cancel();
        System.out.println("Quiz ended!");
        System.out.println("Your final score: " + score + " out of " + questions.size());
    }

  
}
class QuizQuestion {
    private String question;
    private ArrayList<String> options;
    private int correctOptionIndex;

    public QuizQuestion(String question, ArrayList<String> options, int correctOptionIndex) {
        this.question = question;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    public String getQuestion() {
        return question;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public int getCorrectOptionIndex() {
        return correctOptionIndex;
    }
}

// This code implements a basic quiz system in Java. It allows for multiple-choice questions, presents one question at a time, tracks the user's score, and displays the final score at the end. You can customize the questions, options, and correct answers as needed.