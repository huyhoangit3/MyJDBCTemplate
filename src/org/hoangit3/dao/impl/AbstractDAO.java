package org.hoangit3.dao.impl;

import org.hoangit3.dao.GenericDAO;
import org.hoangit3.mapper.RowMapper;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class AbstractDAO<T> implements GenericDAO<T> {
    private static Properties properties;
    private final String DRIVER_NAME;
    private final String USER_NAME;
    private final String PASSWORD;
    private final String DB_URL;

    public AbstractDAO() {
        try {
            FileReader fileReader = new FileReader("src/db.properties");
            properties = new Properties();
            properties.load(fileReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        DRIVER_NAME = properties.getProperty("driver_name");
        USER_NAME = properties.getProperty("user_name");
        PASSWORD = properties.getProperty("password");
        DB_URL = properties.getProperty("db_url");
    }

    public Connection getConnection() {
        Connection connection;
        try {
            Class.forName(DRIVER_NAME);
            connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
        return connection;
    }

    @Override
    public void update(String sqlQuery, Object... params) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            assert connection != null;
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sqlQuery);
            setParameters(preparedStatement, params);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException throwables) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public int save(String sqlQuery, Object... params) {
        int retunedId = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            assert connection != null;
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sqlQuery, PreparedStatement.RETURN_GENERATED_KEYS);
            setParameters(preparedStatement, params);
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                retunedId = resultSet.getInt(1);
            }
            connection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if (preparedStatement != null)
                    preparedStatement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return retunedId;
    }

    @Override
    public List<T> query(String sqlQuery, RowMapper<T> rowMapper, Object... params) {
        List<T> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            assert connection != null;
            preparedStatement = connection.prepareStatement(sqlQuery);
            setParameters(preparedStatement, params);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                T object = rowMapper.mapRow(resultSet);
                list.add(object);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if (preparedStatement != null)
                    preparedStatement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return list;
    }

    private void setParameters(PreparedStatement statement, Object... parameters) {
        try {
            for (int i = 0; i < parameters.length; i++) {
                // preparedStatement param start from 1.
                int index = i + 1;
                Object param = parameters[i];
                if (param instanceof Integer) {
                    statement.setInt(index, (Integer) param);
                } else if (param instanceof Double) {
                    statement.setDouble(index, (Double) param);
                } else if (param instanceof Float) {
                    statement.setFloat(index, (Float) param);
                } else if (param instanceof String) {
                    statement.setString(index, (String) param);
                } else if (param instanceof Timestamp) {
                    statement.setTimestamp(index, (Timestamp) param);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
