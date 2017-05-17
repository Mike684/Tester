package edu.dao.tester;

import edu.connector.DBConnector;
import edu.models.tester.Essay;
import edu.models.users.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * EssayDAO represents major functions to work with Essay object and database.
 * Created by Mike on 03.05.2017.
 */
public class EssayDAO {

    private Connection connection;
    private PreparedStatement pStatement;
    private ResultSet resultSet;
    private String sql;

    /**
     * Create new essay and put it to database.
     * @param essay is an input Essay object.
     * @throws SQLException
     */
    public void createEssay(Essay essay) throws SQLException {
        DBConnector connector = new DBConnector();
        connection = connector.getConnection();
        sql = "INSERT INTO essay_table (question_id, essay, essay_id) VALUES (?,?,?)";

        pStatement = connection.prepareStatement(sql);
        pStatement.setObject(1, essay.getQuestionID());
        pStatement.setString(2, essay.getEssay());
        pStatement.setObject(3, essay.getEssayID());
        pStatement.executeUpdate();

        pStatement.close();
        connection.close();
        connector.disconnect();
    }

    /**
     * Update existing essay and put it to database.
     * @param essay is an input Essay object.
     * @throws SQLException
     */
    public void updateEssay(Essay essay) throws SQLException {
        DBConnector connector = new DBConnector();
        connection = connector.getConnection();
        sql = "UPDATE essay_table SET essay = ?, essay_id = ?";

        pStatement = connection.prepareStatement(sql);
        pStatement.setString(1, essay.getEssay());
        pStatement.setObject(2, essay.getEssayID());
        pStatement.executeUpdate();

        pStatement.close();
        connection.close();
        connector.disconnect();
    }

    /**
     * Delete existing essay from database.
     * @param id is a essay id.
     * @throws SQLException
     */
    public void deleteEssay(UUID id) throws SQLException {
        DBConnector connector = new DBConnector();
        connection = connector.getConnection();
        sql = "DELETE FROM essay_table WHERE essay_id = ?";

        pStatement = connection.prepareStatement(sql);
        pStatement.setObject(1, id);
        pStatement.executeUpdate();

        pStatement.close();
        connection.close();
        connector.disconnect();
    }

    /**
     * Get essay by id.
     * @param id is an essay id.
     * @return Essay object.
     * @throws SQLException
     */
    public Essay getEssayById(UUID id) throws SQLException {

        DBConnector connector = new DBConnector();
        connection = connector.getConnection();
        sql = "SELECT * FROM essay_table WHERE essay_id= ?";

        pStatement = connection.prepareStatement(sql);
        pStatement.setObject(1, id);
        resultSet = pStatement.executeQuery();

        Essay essay = new Essay();
        while (resultSet.next()){
            essay.setEssayID(UUID.fromString(resultSet.getString("essay_id")));
            essay.setEssay(resultSet.getString("essay"));
            essay.setQuestionID(UUID.fromString(resultSet.getString("question_id")));
        }

        resultSet.close();
        pStatement.close();
        connection.close();
        connector.disconnect();

        return essay;
    }

    /**
     * Get all essays.
     * @return essay list.
     * @throws SQLException
     */
    public List<Essay> getAllEssays() throws SQLException {
        DBConnector connector = new DBConnector();
        connection = connector.getConnection();
        sql = "SELECT * FROM essay_table";

        pStatement = connection.prepareStatement(sql);
        resultSet = pStatement.executeQuery();

        List<Essay> essayList = new ArrayList<>();
        while (resultSet.next()){
            Essay essay = new Essay();
            essay.setEssayID(UUID.fromString(resultSet.getString("essay_id")));
            essay.setEssay(resultSet.getString("essay"));
            essay.setQuestionID(UUID.fromString(resultSet.getString("password")));
            essayList.add(essay);
        }

        resultSet.close();
        pStatement.close();
        connection.close();
        connector.disconnect();

        return essayList;
    }

}
