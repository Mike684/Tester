package edu.creator;


import edu.models.tester.*;
import edu.services.JSONService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * QuizMaker is a class for creating default quiz set and saving this set to JSON.
 * Created by Mike on 02.05.2017.
 */
public class QuizMaker {

    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        quiz.setTheme("SomeTheme");

        //Question 1
        Question question1 = new Question();
        question1.setQuizID(quiz.getQuizID());
        question1.setText("Multiple choice: What is the first month of the year?");
        question1.setType(QuestionType.TEST);
        question1.setQuizID(quiz.getQuizID());
        question1.addOption(new Option("January", true, null, question1.getQuestionID()));
        question1.addOption(new Option("February", false, null, question1.getQuestionID()));
        question1.addOption(new Option("March", false, null, question1.getQuestionID()));
        quiz.addQuestion(question1);

        //Question 2
        Question question2 = new Question();
        question2.setQuizID(quiz.getQuizID());
        question2.setText("Multiple choice: What is an apple product?");
        question2.setType(QuestionType.TEST);
        question2.addOption(new Option("ipod", true, null, question2.getQuestionID()));
        question2.addOption(new Option("zune", false, null, question2.getQuestionID()));
        question2.addOption(new Option("lenovo", false, null, question2.getQuestionID()));
        quiz.addQuestion(question2);

        //Question 3
        Question question3 = new Question();
        question3.setQuizID(quiz.getQuizID());
        question3.setText("Multiple choice: What is Barack Obama known for?");
        question3.setType(QuestionType.TEST);
        question3.addOption(new Option("Really likes the show Narcos", false, null, question3.getQuestionID()));
        question3.addOption(new Option("He is the president, dude", true, null, question3.getQuestionID()));
        question3.addOption(new Option("Doesn’t actually like mac and cheese", false, null, question3.getQuestionID()));
        quiz.addQuestion(question3);

        //Question 4
        Question question4 = new Question();
        question4.setQuizID(quiz.getQuizID());
        question4.setText("Multiple answer (more than one possible): What days are not work days?");
        question4.setType(QuestionType.MTEST);
        question4.addOption(new Option("Monday", false, null, question4.getQuestionID()));
        question4.addOption(new Option("Tuesday", false, null, question4.getQuestionID()));
        question4.addOption(new Option("Wednesday", false, null, question4.getQuestionID()));
        question4.addOption(new Option("Thursday", false, null, question4.getQuestionID()));
        question4.addOption(new Option("Friday", false, null, question4.getQuestionID()));
        question4.addOption(new Option("Saturday", true, null, question4.getQuestionID()));
        question4.addOption(new Option("Sunday", true, null, question4.getQuestionID()));
        quiz.addQuestion(question4);

        //Question 5
        Question question5 = new Question();
        question5.setQuizID(quiz.getQuizID());
        question5.setText("Multiple answer (more than one possible): What words begin with the letter \"a\"?");
        question5.setType(QuestionType.MTEST);
        question5.addOption(new Option("apple", true, null, question5.getQuestionID()));
        question5.addOption(new Option("chair", false, null, question5.getQuestionID()));
        question5.addOption(new Option("astronomy", true, null, question5.getQuestionID()));
        question5.addOption(new Option("desk", false, null, question5.getQuestionID()));
        quiz.addQuestion(question5);

        //Question 6
        Question question6 = new Question();
        question6.setQuizID(quiz.getQuizID());
        question6.setText("Multiple answer (more than one possible): What are common household chores?");
        question6.setType(QuestionType.MTEST);
        question6.addOption(new Option("sweeping", true, null, question6.getQuestionID()));
        question6.addOption(new Option("laundry", true, null, question6.getQuestionID()));
        question6.addOption(new Option("skydiving", false, null, question6.getQuestionID()));
        question6.addOption(new Option("basket weaving", false, null, question6.getQuestionID()));
        quiz.addQuestion(question6);

        //Question 7
        Question question7 = new Question();
        question7.setQuizID(quiz.getQuizID());
        question7.setText("Multiple choice: What is the answer, bro?");
        question7.setType(QuestionType.MTEST);
        question7.addOption(new Option("The answer", true, null,  question7.getQuestionID()));
        question7.addOption(new Option("Not the answer", false, null, question7.getQuestionID()));
        question7.addOption(new Option("Also not the answer", false, null, question7.getQuestionID()));
        quiz.addQuestion(question7);

        //Question 8
        Question question8 = new Question();
        question8.setQuizID(quiz.getQuizID());
        question8.setText("Fill in the blank: The quick red ___ jumped over the lazy brown ___. Hint: fox dog");
        question8.setType(QuestionType.BLANK);
        question8.addBlank(new Blank("fox", null, question8.getQuestionID()));
        question8.addBlank(new Blank("dog", null, question8.getQuestionID()));
        quiz.addQuestion(question8);

        //Question 9
        Question question9 = new Question();
        question9.setQuizID(quiz.getQuizID());
        question9.setText("Fill in the blank: This is a fill in the _____ question.");
        question9.setType(QuestionType.BLANK);
        question9.addBlank(new Blank("blank", null, question9.getQuestionID()));
        quiz.addQuestion(question9);

        //Question 10
        Question question10 = new Question();
        question10.setQuizID(quiz.getQuizID());
        question10.setText("Fill in the blank: This assignment is for a _________ course.");
        question10.setType(QuestionType.BLANK);
        question10.addBlank(new Blank("programming", null, question10.getQuestionID()));
        quiz.addQuestion(question10);

        List<Quiz> quizList = new ArrayList<>();
        quizList.add(quiz);

        try {
            new JSONService().toJSONFile(quiz);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
