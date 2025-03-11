package com.github.curriculeon.lib.connection;

import com.github.curriculeon.lib.utils.ConnectionBuilder;
import com.github.curriculeon.lib.utils.IOConsole;

import java.sql.*;

/**
 * Created by leon on 2/18/2020.
 */
public enum DatabaseConnection implements DatabaseConnectionInterface {
    PRODUCTION_DATABASE(new ConnectionBuilder()
            .setUser("root")
            .setPassword("")
            .setPort(3306)
            .setDatabaseVendor("mariadb")
            .setHost("127.0.0.1")),

    TESTING_DATABASE(new ConnectionBuilder()
            .setUser("root")
            .setPassword("")
            .setPort(3306)
            .setDatabaseVendor("mariadb")
            .setHost("127.0.0.1"));

    private final IOConsole console;
    private volatile ConnectionBuilder connectionBuilder;

    DatabaseConnection(ConnectionBuilder connectionBuilder) {
        this.connectionBuilder = connectionBuilder;
        this.console = new IOConsole(IOConsole.AnsiColor.CYAN);
    }

    @Override
    public String getDatabaseName() {
        return name().toLowerCase();
    }

    @Override
    public Connection getDatabaseConnection() {
        return connectionBuilder
                .setDatabaseName(name().toLowerCase())
                .build();
    }

    @Override
    public Connection getDatabaseEngineConnection() {
        return connectionBuilder.build();
    }

    @Override
    public String getName() {
        return name();
    }

    @Override
    public IOConsole getConsole() {
        return this.console;
    }
}
