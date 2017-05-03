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
 * Created by Mike on 02.05.2017.
 */
public class OptionDAO {

    private Connection connection;
    private PreparedStatement pStatement;
    private ResultSet resultSet;
    private String sql;

    public void createOption(Option option) throws SQLException {
        DBConnector connector = new DBConnector();
        connection = connector.getConnection();
        sql = "INSERT INTO options (question_id, option, answer, option_id, user_answer) " +
                "VALUES (?,?,?,?,?)";

        pStatement = connection.prepareStatement(sql);
        pStatement.setObject(1, option.getQuestionID());
        pStatement.setString(2, option.getOption());
        pStatement.setBoolean(3, option.getAnswer());
        pStatement.setObject(4, option.getOptionID());
        pStatement.setBoolean(5, option.getUAnswer());
        pStatement.executeUpdate();

        pStatement.close();
        connection.close();
        connector.disconnect();
    }

    public void updateOption(Option option) throws SQLException {
        DBConnector connector = new DBConnector();
        connection = connector.getConnection();
        sql = "UPDATE options SET question_id = ?, option = ?, answer = ?, user_answer = ?";

        pStatement = connection.prepareStatement(sql);
        pStatement.setObject(1, option.getQuestionID());
        pStatement.setString(2, option.getOption());
        pStatement.setBoolean(3, option.getAnswer());
        pStatement.setBoolean(3, option.getUAnswer());
        pStatement.executeUpdate();

        pStatement.close();
        connection.close();
        connector.disconnect();
    }

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
            option.setAnswer(Boolean.valueOf(resultSet.getString("answer")));
            option.setUAnswer(Boolean.valueOf(resultSet.getString("user_answer")));
            option.setQuestionID(UUID.fromString(resultSet.getString("question_id")));
        }

        resultSet.close();
        pStatement.close();
        connection.close();
        connector.disconnect();

        return option;
    }

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
            option.setAnswer(Boolean.valueOf(resultSet.getString("answer")));
            option.setUAnswer(Boolean.valueOf(resultSet.getString("user_answer")));
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
