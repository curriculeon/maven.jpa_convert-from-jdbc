package com.github.curriculeon.lib.connection;

import com.github.curriculeon.lib.utils.IOConsole;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by leon on 2/18/2020.
 */
public interface DatabaseConnectionInterface {
    String getDatabaseName();
    Connection getDatabaseConnection();
    Connection getDatabaseEngineConnection();
    String getName();
    IOConsole getConsole();
    
    default void drop() {
        try {
            String sqlStatement = "DROP DATABASE IF EXISTS " + getName().toLowerCase() + ";";
            getDatabaseEngineConnection()
                    .prepareStatement(sqlStatement)
                    .execute();
            String successMessage = String.format("Successfully executed statement \n\t`%s`", sqlStatement);
            getConsole().println(successMessage);
        } catch (SQLException e) {
            throw new Error(e);
        }
    }

    default void create() {
        String sqlStatement = "CREATE DATABASE IF NOT EXISTS " + getName().toLowerCase() + ";";
        try {
            getDatabaseEngineConnection()
                    .prepareStatement(sqlStatement)
                    .execute();
            String successMessage = String.format("Successfully executed statement \n\t`%s`", sqlStatement);
            getConsole().println(successMessage);
        } catch (SQLException e) {
            String errorMessage = String.format("Failed to connect to execute statement\n\t`%s`", sqlStatement);
            throw new Error(errorMessage, e);
        }
    }

    default void use() {
        try {
            String sqlStatement = "USE " + getName().toLowerCase() + ";";
            getDatabaseEngineConnection()
                    .prepareStatement(sqlStatement)
                    .execute();
            String successMessage = String.format("Successfully executed statement \n\t`%s`", sqlStatement);
            getConsole().println(successMessage);
        } catch (SQLException e) {
            throw new Error(e);
        }
    }

    default void executeStatement(String sqlStatement) {
        try {
            sqlStatement = sqlStatement.trim();
            createScrollableStatement().execute(sqlStatement);
            String successMessage = String.format("Successfully executed statement \n\t`%s`", sqlStatement);
            getConsole().println(successMessage);
        } catch (SQLException e) {
            String errorMessage = String.format("Failed to execute statement \n\t`%s`", sqlStatement);
            throw new Error(errorMessage, e);
        }
    }

    default ResultSet executeQuery(String sqlQuery) {
        try {
            sqlQuery = sqlQuery.trim();
            ResultSet result = createScrollableStatement().executeQuery(sqlQuery);
            String successMessage = String.format("Successfully executed query \n\t`%s`", sqlQuery);
            getConsole().println(successMessage);
            return result;
        } catch (SQLException e) {
            String errorMessage = String.format("Failed to execute query \n\t`%s`", sqlQuery);
            throw new Error(errorMessage, e);
        }
    }

    default Statement createScrollableStatement() {
        int resultSetType = ResultSet.TYPE_SCROLL_INSENSITIVE;
        int resultSetConcurrency = ResultSet.CONCUR_READ_ONLY;
        try {
            return getDatabaseConnection().createStatement(resultSetType, resultSetConcurrency);
        } catch (SQLException e) {
            throw new Error(e);
        }
    }
}
