import liquibase.Contexts;
import liquibase.LabelExpression;
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

    @BeforeClass
    public static void createTestData() throws SQLException,
            ClassNotFoundException, LiquibaseException {

        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection("jdbc:postgresql:liqui-test", "postgres", "qwerty123");

        Database database = DatabaseFactory.getInstance()
                .findCorrectDatabaseImplementation(new JdbcConnection(connection));

        Liquibase liquibase = new Liquibase("src\\test\\resources\\liquibase\\changelog-liquiTest-master.xml",
                new FileSystemResourceAccessor(), database);
        liquibase.update(new Contexts(), new LabelExpression());
    }

    @AfterClass
    public static void removeTestData() throws LiquibaseException, SQLException {
        connection.close();
    }

    @Test
    public void testContract() throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement("select count(*) as numberOfContract from contract");) {
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int numberOfContract = resultSet.getInt("numberOfContract");
            Assert.assertEquals(3, numberOfContract);
        }
    }

}
