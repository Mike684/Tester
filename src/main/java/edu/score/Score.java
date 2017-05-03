package edu.score;

import edu.models.tester.*;

/**
 * Created by Mike on 02.05.2017.
 */
public class Score {

    public Double getQuizScore(Quiz quiz){
        Double quizScore;
        for (Question question : quiz.getQuestions()){
//            if (question.get)
        }
        return null;
    }

//    public Double getQuestionScore(Question question){
//        Double score = null;
//        Integer correct = 0;
//
//        if (question.getType() == QuestionType.TEST || question.getType() == QuestionType.TEST){
//            for (Option option : question.getOptions()){
//                if (option.getAnswer())
//                    correct++;
//                if (option.getAnswer() == option.getUAnswer())
//                    score += 1.0;
//            }
//        }
//
//        if (question.getType() == QuestionType.BLANK){
//            for (Blank blank : question.getBlanks()){
//                correct = question.getBlanks().size();
//                if (blank.getAnswer().equals(blank.getUAnswer()))
//                    score += 1.0;
//            }
//        }
//
//        if (question.getType() == QuestionType.ESSAY){
//            correct = 1;
//            score += 10.0;
//        }
//
//        else
//            System.out.println("Error!");
//
//        score = question.getMaxMark() * score / correct;
//        return score;
//    }
}
