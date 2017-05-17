package edu.dao.users;

import edu.connector.DBConnector;
import edu.models.users.UAnswer;
import edu.models.users.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * UAnswerDAO represents major functions to work with UAnswer object and database.
 * Created by Mike on 02.05.2017.
 */
public class UAnswerDAO {

    private Connection connection;
    private PreparedStatement pStatement;
    private ResultSet resultSet;
    private String sql;

    /**
     *  Create new user answer and put it to database.
     * @param uAnswer
     * @throws SQLException
     */
    public void createUAnswer(UAnswer uAnswer) throws SQLException {
        DBConnector connector = new DBConnector();
        connection = connector.getConnection();
        sql = "INSERT INTO users_answers (user_id, question_id, answer, mark, answer_id) " +
                "VALUES (?,?,?,?,?)";

        pStatement = connection.prepareStatement(sql);
        pStatement.setObject(1, uAnswer.getUserID());
        pStatement.setObject(2, uAnswer.getQuestionID());
        pStatement.setString(3, uAnswer.getAnswer());
        pStatement.setDouble(4, uAnswer.getMark());
        pStatement.setObject(5, uAnswer.getAnswerID());
        pStatement.executeUpdate();

        pStatement.close();
        connection.close();
        connector.disconnect();
    }

    /**
     * Update existing user answer and put it to database.
     * @param uAnswer is an input UAnswer object.
     * @throws SQLException
     */
    public void updateUAnswer(UAnswer uAnswer) throws SQLException {
        DBConnector connector = new DBConnector();
        connection = connector.getConnection();
        sql = "UPDATE users_answers SET user_id = ?, question_id = ?, answer = ?, mark = ?";

        pStatement = connection.prepareStatement(sql);
        pStatement.setObject(1, uAnswer.getUserID());
        pStatement.setObject(2, uAnswer.getQuestionID());
        pStatement.setString(3, uAnswer.getAnswer());
        pStatement.setDouble(4, uAnswer.getMark());
        pStatement.executeUpdate();

        pStatement.close();
        connection.close();
        connector.disconnect();
    }

    /**
     * Delete existing user answer from database.
     * @param id is an user answer id.
     * @throws SQLException
     */
    public void deleteUAnswer(UUID id) throws SQLException {
        DBConnector connector = new DBConnector();
        connection = connector.getConnection();
        sql = "DELETE FROM users_answers WHERE answer_id = ?";

        pStatement = connection.prepareStatement(sql);
        pStatement.setObject(1, id);
        pStatement.executeUpdate();

        pStatement.close();
        connection.close();
        connector.disconnect();
    }

    /**
     * Get user answer by id.
     * @param id is an user answer id.
     * @return UAnswer object.
     * @throws SQLException
     */
    public UAnswer getUAnswerById(UUID id) throws SQLException {

        DBConnector connector = new DBConnector();
        connection = connector.getConnection();
        sql = "SELECT * FROM users_answers WHERE answer_id = ?";

        pStatement = connection.prepareStatement(sql);
        pStatement.setObject(1, id);
        resultSet = pStatement.executeQuery();

        UAnswer uAnswer = new UAnswer();
        while (resultSet.next()){
            uAnswer.setAnswerID(UUID.fromString(resultSet.getString("answer_id")));
            uAnswer.setUserID(UUID.fromString(resultSet.getString("user_id")));
            uAnswer.setQuestionID(UUID.fromString(resultSet.getString("question_id")));
            uAnswer.setAnswer(resultSet.getString("answer"));
            uAnswer.setMark(Double.valueOf(resultSet.getString("mark")));
        }

        resultSet.close();
        pStatement.close();
        connection.close();
        connector.disconnect();

        return uAnswer;
    }

    /**
     * Get all user answers.
     * @return user answer list.
     * @throws SQLException
     */
    public List<UAnswer> getAllUAnswers() throws SQLException {
        DBConnector connector = new DBConnector();
        connection = connector.getConnection();
        sql = "SELECT * FROM users_answers";

        pStatement = connection.prepareStatement(sql);
        resultSet = pStatement.executeQuery();

        List<UAnswer> answers= new ArrayList<>();
        while (resultSet.next()){
            UAnswer uAnswer = new UAnswer();
            uAnswer.setAnswerID(UUID.fromString(resultSet.getString("answer_id")));
            uAnswer.setUserID(UUID.fromString(resultSet.getString("user_id")));
            uAnswer.setQuestionID(UUID.fromString(resultSet.getString("question_id")));
            uAnswer.setAnswer(resultSet.getString("answer"));
            uAnswer.setMark(Double.valueOf(resultSet.getString("mark")));
            answers.add(uAnswer);
        }

        resultSet.close();
        pStatement.close();
        connection.close();
        connector.disconnect();

        return answers;
    }

}
