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
    public static void removeTestData() throws SQLException {
        connection.close();
    }

    @Test
    public void testContract() {
        try(Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select count(*) as numberOfContract from contract")){
            int numberOfContract = 0;
            while (resultSet.next()){
                numberOfContract = resultSet.getInt("numberOfContract");
            }
            Assert.assertEquals(3, numberOfContract);
        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
    }

}
