package edu.dao.tester;

import edu.connector.DBConnector;
import edu.models.tester.Quiz;
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
public class QuizDAO {

    private Connection connection;
    private PreparedStatement pStatement;
    private ResultSet resultSet;
    private String sql;

    public void createQuiz(Quiz quiz) throws SQLException {
        DBConnector connector = new DBConnector();
        connection = connector.getConnection();
        sql = "INSERT INTO quiz (quiz_id, theme) VALUES (?,?)";

        pStatement = connection.prepareStatement(sql);
        pStatement.setObject(1, quiz.getQuizID());
        pStatement.setString(2, quiz.getTheme());
        pStatement.executeUpdate();

        pStatement.close();
        connection.close();
        connector.disconnect();
    }

    public void updateUser(Quiz quiz) throws SQLException {
        DBConnector connector = new DBConnector();
        connection = connector.getConnection();
        sql = "UPDATE quiz SET theme = ?";

        pStatement = connection.prepareStatement(sql);
        pStatement.setString(1, quiz.getTheme());
        pStatement.executeUpdate();

        pStatement.close();
        connection.close();
        connector.disconnect();
    }

    public void deleteUser(UUID id) throws SQLException {
        DBConnector connector = new DBConnector();
        connection = connector.getConnection();
        sql = "DELETE FROM quiz WHERE quiz_id = ?";

        pStatement = connection.prepareStatement(sql);
        pStatement.setObject(1, id);
        pStatement.executeUpdate();

        pStatement.close();
        connection.close();
        connector.disconnect();
    }

    public Quiz getUserById(UUID id) throws SQLException {

        DBConnector connector = new DBConnector();
        connection = connector.getConnection();
        sql = "SELECT * FROM quiz WHERE quiz_id = ?";

        pStatement = connection.prepareStatement(sql);
        pStatement.setObject(1, id);
        resultSet = pStatement.executeQuery();

        Quiz quiz = new Quiz();
        while (resultSet.next()){
            quiz.setQuizID(UUID.fromString(resultSet.getString("quiz_id")));
            quiz.setTheme(resultSet.getString("theme"));
        }

        resultSet.close();
        pStatement.close();
        connection.close();
        connector.disconnect();

        return quiz;
    }

    public List<Quiz> getAllQuizzes() throws SQLException {
        DBConnector connector = new DBConnector();
        connection = connector.getConnection();
        sql = "SELECT * FROM quiz";

        pStatement = connection.prepareStatement(sql);
        resultSet = pStatement.executeQuery();

        List<Quiz> quizList = new ArrayList<>();
        while (resultSet.next()){
            Quiz quiz = new Quiz();
            quiz.setQuizID(UUID.fromString(resultSet.getString("quiz_id")));
            quiz.setTheme(resultSet.getString("theme"));
            quizList.add(quiz);
        }

        resultSet.close();
        pStatement.close();
        connection.close();
        connector.disconnect();

        return quizList;
    }

}
