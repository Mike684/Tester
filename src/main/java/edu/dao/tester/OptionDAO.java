package edu.dao.tester;

import edu.connector.DBConnector;
import edu.models.tester.Option;
import edu.models.users.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * OptionDAO represents major functions to work with Option object and database.
 * Created by Mike on 02.05.2017.
 */
public class OptionDAO {

    private Connection connection;
    private PreparedStatement pStatement;
    private ResultSet resultSet;
    private String sql;

    /**
     * Create new option and put it to database.
     * @param option is an input Option object.
     * @throws SQLException
     */
    public void createOption(Option option) throws SQLException {
        DBConnector connector = new DBConnector();
        connection = connector.getConnection();
        sql = "INSERT INTO options (question_id, option, answer, option_id) " +
                "VALUES (?,?,?,?)";

        pStatement = connection.prepareStatement(sql);
        pStatement.setObject(1, option.getQuestionID());
        pStatement.setString(2, option.getOption());
        pStatement.setBoolean(3, option.getAnswer());
        pStatement.setObject(4, option.getOptionID());
        pStatement.executeUpdate();

        pStatement.close();
        connection.close();
        connector.disconnect();

    }

    /**
     * Update existing option and put it to database.
     * @param option is an input Option object.
     * @throws SQLException
     */
    public void updateOption(Option option) throws SQLException {
        DBConnector connector = new DBConnector();
        connection = connector.getConnection();
        sql = "UPDATE options SET question_id = ?, option = ?, answer = ?";

        pStatement = connection.prepareStatement(sql);
        pStatement.setObject(1, option.getQuestionID());
        pStatement.setString(2, option.getOption());
        pStatement.setBoolean(3, option.getAnswer());
        pStatement.executeUpdate();

        pStatement.close();
        connection.close();
        connector.disconnect();
    }

    /**
     * Delete existing option from database.
     * @param id is an option id.
     * @throws SQLException
     */
    public void deleteOption(UUID id) throws SQLException {
        DBConnector connector = new DBConnector();
        connection = connector.getConnection();
        sql = "DELETE FROM options WHERE option_id = ?";

        pStatement = connection.prepareStatement(sql);
        pStatement.setObject(1, id);
        pStatement.executeUpdate();

        pStatement.close();
        connection.close();
        connector.disconnect();
    }

    /**
     * Get option by id.
     * @param id is an option id.
     * @return Option object.
     * @throws SQLException
     */
    public Option getOptionById(UUID id) throws SQLException {

        DBConnector connector = new DBConnector();
        connection = connector.getConnection();
        sql = "SELECT * FROM options WHERE option_id = ?";

        pStatement = connection.prepareStatement(sql);
        pStatement.setObject(1, id);
        resultSet = pStatement.executeQuery();

        Option option = new Option();
        while (resultSet.next()){
            option.setOptionID(UUID.fromString(resultSet.getString("option_id")));
            option.setOption(resultSet.getString("option"));
            if (resultSet.getString("answer").equalsIgnoreCase("t"))
                option.setAnswer(true);
            else
                option.setAnswer(false);
                option.setUAnswer(Boolean.valueOf(resultSet.getString("answer")));
            option.setQuestionID(UUID.fromString(resultSet.getString("question_id")));
        }

        resultSet.close();
        pStatement.close();
        connection.close();
        connector.disconnect();

        return option;
    }

    /**
     * Get options by id.
     * @param id is an option id.
     * @return option list.
     * @throws SQLException
     */
    public List<Option> getOptionsById(UUID id) throws SQLException {
        DBConnector connector = new DBConnector();
        connection = connector.getConnection();
        sql = "SELECT * FROM options WHERE question_id = ?";

        pStatement = connection.prepareStatement(sql);
        pStatement.setObject(1, id);
        resultSet = pStatement.executeQuery();

        List<Option> options = new ArrayList<>();
        while (resultSet.next()){
            Option option = new Option();
            option.setOptionID(UUID.fromString(resultSet.getString("option_id")));
            option.setOption(resultSet.getString("option"));
            if (resultSet.getString("answer").equalsIgnoreCase("t"))
                option.setAnswer(true);
            else
                option.setAnswer(false);
            option.setUAnswer(Boolean.valueOf(resultSet.getString("answer")));
            option.setQuestionID(UUID.fromString(resultSet.getString("question_id")));
            options.add(option);
        }
        resultSet.close();
        pStatement.close();
        connection.close();
        connector.disconnect();

        return options;
    }

    /**
     * Get all options.
     * @return optionlist.
     * @throws SQLException
     */
    public List<Option> getAllOptions() throws SQLException {
        DBConnector connector = new DBConnector();
        connection = connector.getConnection();
        sql = "SELECT * FROM options";

        pStatement = connection.prepareStatement(sql);
        resultSet = pStatement.executeQuery();

        List<Option> options= new ArrayList<>();
        while (resultSet.next()){
            Option option = new Option();
            option.setOptionID(UUID.fromString(resultSet.getString("option_id")));
            option.setOption(resultSet.getString("option"));
            if (resultSet.getString("answer").equalsIgnoreCase("t"))
                option.setAnswer(true);
            else
                option.setAnswer(false);
            option.setUAnswer(Boolean.valueOf(resultSet.getString("answer")));
            option.setQuestionID(UUID.fromString(resultSet.getString("question_id")));
            options.add(option);
        }

        resultSet.close();
        pStatement.close();
        connection.close();
        connector.disconnect();

        return options;
    }

}
