package edu.dao.tester;

import edu.connector.DBConnector;
import edu.models.tester.Question;
import edu.models.tester.QuestionType;
import edu.models.users.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Mike on 02.05.2017.
 */
public class QuestionDAO {

    private Connection connection;
    private PreparedStatement pStatement;
    private ResultSet resultSet;
    private String sql;

    public void createQuestion(Question question) throws SQLException {
        DBConnector connector = new DBConnector();
        connection = connector.getConnection();
        sql = "INSERT INTO questions (question_id, question_text, question_type, max_mark, quiz_id)" +
                " VALUES (?,?,?,?,?)";

        pStatement = connection.prepareStatement(sql);
        pStatement.setObject(1, question.getQuestionID());
        pStatement.setString(2, question.getText());
        pStatement.setObject(3, question.getType());
        pStatement.setDouble(3, question.getMaxMark());
        pStatement.setObject(3, question.getQuizID());
        pStatement.executeUpdate();

        pStatement.close();
        connection.close();
        connector.disconnect();
    }

    public void updateQuestion(Question question) throws SQLException {
        DBConnector connector = new DBConnector();
        connection = connector.getConnection();
        sql = "UPDATE questions SET question_text = ?, " +
                "question_type = ?," +
                "max_mark = ?," +
                "quiz_id = ?";

        pStatement = connection.prepareStatement(sql);
        pStatement.setString(1, question.getText());
        pStatement.setObject(2, question.getType());
        pStatement.setDouble(3, question.getMaxMark());
        pStatement.setObject(4, question.getQuizID());
        pStatement.executeUpdate();

        pStatement.close();
        connection.close();
        connector.disconnect();
    }

    public void deleteQuestion(UUID id) throws SQLException {
        DBConnector connector = new DBConnector();
        connection = connector.getConnection();
        sql = "DELETE FROM questions WHERE question_id = ?";

        pStatement = connection.prepareStatement(sql);
        pStatement.setObject(1, id);
        pStatement.executeUpdate();

        pStatement.close();
        connection.close();
        connector.disconnect();
    }

    public Question getQuestionById(UUID id) throws SQLException {

        DBConnector connector = new DBConnector();
        connection = connector.getConnection();
        sql = "SELECT * FROM questions WHERE question_id = ?";

        pStatement = connection.prepareStatement(sql);
        pStatement.setObject(1, id);
        resultSet = pStatement.executeQuery();

        Question question = new Question();
        while (resultSet.next()){
            question.setQuestionID(UUID.fromString(resultSet.getString("question_id")));
            question.setText(resultSet.getString("question_text"));
            question.setType(QuestionType.valueOf(resultSet.getString("question_type")));
        }

        resultSet.close();
        pStatement.close();
        connection.close();
        connector.disconnect();

        return question;
    }

    public List<Question> getAllQuestions() throws SQLException {
        DBConnector connector = new DBConnector();
        connection = connector.getConnection();
        sql = "SELECT * FROM questions";

        pStatement = connection.prepareStatement(sql);
        resultSet = pStatement.executeQuery();

        List<Question> questions = new ArrayList<>();
        while (resultSet.next()){
            Question question = new Question();
            question.setQuestionID(UUID.fromString(resultSet.getString("question_id")));
            question.setText(resultSet.getString("question_text"));
            question.setType(QuestionType.valueOf(resultSet.getString("question_type")));
            questions.add(question);
        }

        resultSet.close();
        pStatement.close();
        connection.close();
        connector.disconnect();

        return questions;
    }

}
