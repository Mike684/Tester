package edu.creator;


import edu.models.tester.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mike on 02.05.2017.
 */
public class QuizMaker {

    private Quiz quiz;

    public Quiz createQuiz() {

        quiz = new Quiz();
        quiz.setTheme("SomeTheme");

        //Question 1
        Question question1 = new Question();
        question1.setText("Multiple choice: What is the first month of the year?");
        question1.setType(QuestionType.TEST);
        question1.setQuizID(quiz.getQuizID());
        question1.addOption(new Option("January", true, null, question1.getQuestionID()));
        question1.addOption(new Option("February", false, null, question1.getQuestionID()));
        question1.addOption(new Option("March", false, null, question1.getQuestionID()));
        quiz.addQuestion(question1);

//        //Question 2
//        Question question2 = new Question(quiz);
//        question2.setText("Multiple choice: What is an apple product?");
//        question2.setType("Test");
//        question2.addOption(new Option("ipod", true, question2));
//        question2.addOption(new Option("zune", false, question2));
//        question2.addOption(new Option("lenovo", false, question2));
//        quiz.addQuestion(question2);
//
//        //Question 3
//        Question question3 = new Question(quiz);
//        question3.setText("Multiple choice: What is Barack Obama known for?");
//        question3.setType("Test");
//        question3.addOption(new Option("Really likes the show Narcos", false, question3));
//        question3.addOption(new Option("He is the president, dude", true, question3));
//        question3.addOption(new Option("Doesn’t actually like mac and cheese", false, question3));
//        quiz.addQuestion(question3);
//
//        //Question 4
//        Question question4 = new Question(quiz);
//        question4.setText("Multiple answer (more than one possible): What days are not work days?");
//        question4.setType("MTest");
//        question4.addOption(new Option("Monday", false, question4));
//        question4.addOption(new Option("Tuesday", false, question4));
//        question4.addOption(new Option("Wednesday", false, question4));
//        question4.addOption(new Option("Thursday", false, question4));
//        question4.addOption(new Option("Friday", false, question4));
//        question4.addOption(new Option("Saturday", true, question4));
//        question4.addOption(new Option("Sunday", true, question4));
//        quiz.addQuestion(question4);
//
//        //Question 5
//        Question question5 = new Question(quiz);
//        question5.setText("Multiple answer (more than one possible): What words begin with the letter \"a\"?");
//        question5.setType("MTest");
//        question5.addOption(new Option("apple", true, question5));
//        question5.addOption(new Option("chair", false, question5));
//        question5.addOption(new Option("astronomy", true, question5));
//        question5.addOption(new Option("desk", false, question5));
//        quiz.addQuestion(question5);
//
//        //Question 6
//        Question question6 = new Question(quiz);
//        question6.setText("Multiple answer (more than one possible): What are common household chores?");
//        question6.setType("MTest");
//        question6.addOption(new Option("sweeping", true, question6));
//        question6.addOption(new Option("laundry", true, question6));
//        question6.addOption(new Option("skydiving", false, question6));
//        question6.addOption(new Option("basket weaving", false, question6));
//        quiz.addQuestion(question6);
//
//        //Question 7
//        Question question7 = new Question(quiz);
//        question7.setText("Multiple choice: What's the answer, bro?");
//        question7.setType("Test");
//        question7.addOption(new Option("The answer", true, question7));
//        question7.addOption(new Option("Not the answer", false, question7));
//        question7.addOption(new Option("Also not the answer", false, question7));
//        quiz.addQuestion(question7);
//
//        //Question 8
//        Question question8 = new Question(quiz);
//        question8.setText("Fill in the blank: The quick red ___ jumped over the lazy brown ___. Hint: fox dog");
//        question8.setType("Blank");
//        question8.addBlank(new Blank("fox", question8));
//        question8.addBlank(new Blank("dog", question8));
//        quiz.addQuestion(question8);
//
//        //Question 9
//        Question question9 = new Question(quiz);
//        question9.setText("Fill in the blank: This is a fill in the _____ question.");
//        question9.setType("Blank");
//        question9.addBlank(new Blank("blank", question9));
//        quiz.addQuestion(question9);
//
//        //Question 10
//        Question question10 = new Question(quiz);
//        question10.setText("Fill in the blank: This assignment is for a _________ course.");
//        question10.setType("Blank");
//        question10.addBlank(new Blank("programming", question10));
//        quiz.addQuestion(question10);

        return quiz;
    }
}
