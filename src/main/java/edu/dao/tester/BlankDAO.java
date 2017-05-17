package edu.dao.tester;

import edu.connector.DBConnector;
import edu.models.tester.Blank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * BlankDAO represents major functions to work with Blank object and database.
 * Created by Mike on 02.05.2017.
 */
public class BlankDAO {

    private Connection connection;
    private PreparedStatement pStatement;
    private ResultSet resultSet;
    private String sql;

    /**
     * Create new blank and put it to database.
     * @param blank is an input Blank object.
     * @throws SQLException
     */
    public void createBlank(Blank blank) throws SQLException {
        DBConnector connector = new DBConnector();
        connection = connector.getConnection();
        sql = "INSERT INTO blank_answers (question_id, answer, blank_id) " +
                "VALUES (?,?,?)";

        pStatement = connection.prepareStatement(sql);
        pStatement.setObject(1, blank.getQuestionID());
        pStatement.setString(2, blank.getAnswer());
        pStatement.setObject(3, blank.getBlankID());
        pStatement.executeUpdate();

        pStatement.close();
        connection.close();
        connector.disconnect();
    }

    /**
     * Update existing blank and put it to database.
     * @param blank is an input Blank object.
     * @throws SQLException
     */
    public void updateBlank(Blank blank) throws SQLException {
        DBConnector connector = new DBConnector();
        connection = connector.getConnection();
        sql = "UPDATE blank_answers SET question_id = ?, answer= ?";

        pStatement = connection.prepareStatement(sql);
        pStatement.setObject(1, blank.getQuestionID());
        pStatement.setString(2, blank.getAnswer());
        pStatement.executeUpdate();

        pStatement.close();
        connection.close();
        connector.disconnect();
    }

    /**
     * Delete existing blank from database.
     * @param id is a blank id.
     * @throws SQLException
     */
    public void deleteBlank(UUID id) throws SQLException {
        DBConnector connector = new DBConnector();
        connection = connector.getConnection();
        sql = "DELETE FROM blank_answers WHERE blank_id = ?";

        pStatement = connection.prepareStatement(sql);
        pStatement.setObject(1, id);
        pStatement.executeUpdate();

        pStatement.close();
        connection.close();
        connector.disconnect();
    }

    /**
     * Get blank by id.
     * @param id is a blank id.
     * @return Blank object.
     * @throws SQLException
     */
    public Blank getBlankById(UUID id) throws SQLException {

        DBConnector connector = new DBConnector();
        connection = connector.getConnection();
        sql = "SELECT * FROM blank_answers WHERE blank_id = ?";

        pStatement = connection.prepareStatement(sql);
        pStatement.setObject(1, id);
        resultSet = pStatement.executeQuery();

        Blank blank = new Blank();
        while (resultSet.next()){
            blank.setBlankID(UUID.fromString(resultSet.getString("blank_id")));
            blank.setQuestionID(UUID.fromString(resultSet.getString("question_id")));
            blank.setAnswer(resultSet.getString("answer"));
        }

        resultSet.close();
        pStatement.close();
        connection.close();
        connector.disconnect();

        return blank;
    }

    /**
     * Get all blanks.
     * @return blank list.
     * @throws SQLException
     */
    public List<Blank> getAllBlanks() throws SQLException {
        DBConnector connector = new DBConnector();
        connection = connector.getConnection();
        sql = "SELECT * FROM blank_answers";

        pStatement = connection.prepareStatement(sql);
        resultSet = pStatement.executeQuery();

        List<Blank> blanks = new ArrayList<>();
        while (resultSet.next()){
            Blank blank = new Blank();
            blank.setBlankID(UUID.fromString(resultSet.getString("blank_id")));
            blank.setQuestionID(UUID.fromString(resultSet.getString("question_id")));
            blank.setAnswer(resultSet.getString("answer"));
            blanks.add(blank);
        }

        resultSet.close();
        pStatement.close();
        connection.close();
        connector.disconnect();

        return blanks;
    }

    public List<Blank> getBlanksById(UUID id) throws SQLException {

        DBConnector connector = new DBConnector();
        connection = connector.getConnection();
        sql = "SELECT * FROM blank_answers WHERE question_id = ?";

        pStatement = connection.prepareStatement(sql);
        pStatement.setObject(1, id);
        resultSet = pStatement.executeQuery();

        List<Blank> blanks = new ArrayList<>();
        while (resultSet.next()){
            Blank blank = new Blank();
            blank.setBlankID(UUID.fromString(resultSet.getString("blank_id")));
            blank.setQuestionID(UUID.fromString(resultSet.getString("question_id")));
            blank.setAnswer(resultSet.getString("answer"));
            blanks.add(blank);
        }

        resultSet.close();
        pStatement.close();
        connection.close();
        connector.disconnect();

        return blanks;

    }
}
