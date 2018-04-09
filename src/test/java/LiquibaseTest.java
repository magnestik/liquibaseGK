import liquibase.Contexts;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.FileSystemResourceAccessor;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.*;

public class LiquibaseTest {
    private static Connection connection;
    private static Liquibase liquibase;

    @BeforeClass
    public static void createTestData() throws SQLException,
            ClassNotFoundException, LiquibaseException {

        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection("jdbc:postgresql:liqui", "postgres", "qwerty123");

        Database database = DatabaseFactory.getInstance()
                .findCorrectDatabaseImplementation(new JdbcConnection(connection));

        liquibase = new Liquibase("src\\test\\resources\\liquibase\\changelog-liquibaseTest-1.xml",
                new FileSystemResourceAccessor(), database);
        liquibase.update((Contexts) null);
    }

    @AfterClass
    public static void removeTestData() throws LiquibaseException, SQLException {
        liquibase.rollback(1000, null);
        connection.close();
    }

    @Test
    public void testContract() throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("select count(*) as numberOfContract from contract");
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int numberOfContract = resultSet.getInt("numberOfContract");
            Assert.assertEquals(3, numberOfContract);
        } finally {
            resultSet.close();
            preparedStatement.close();
        }
    }

}
