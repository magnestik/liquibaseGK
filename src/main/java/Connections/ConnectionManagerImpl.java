package Connections;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManagerImpl implements ConnectionManager {

    private Logger log = LogManager.getLogger(ConnectionManagerImpl.class);
    private static ConnectionManager connectionManager;

    public static ConnectionManager getInstance() {
        if (connectionManager == null) {
            connectionManager = new ConnectionManagerImpl();
        }
        return connectionManager;
    }

    public Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/liqui",
                    "postgres",
                    "qwerty123"
            );
        } catch (ClassNotFoundException e) {
            log.error("Драйвер не найден");
        } catch (SQLException e) {
            log.error("Ошибка подключения");
        }
        return connection;
    }
}
