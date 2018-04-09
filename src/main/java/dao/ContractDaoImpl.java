package dao;

import Connections.ConnectionManager;
import Connections.ConnectionManagerImpl;
import pojo.Contract;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContractDaoImpl implements ContractDao {
    private static ConnectionManager connectionManager = ConnectionManagerImpl.getInstance();

    public void insert(Contract contract) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement preparedStatement =
                connection.prepareStatement("insert into contract values (default,?,?,?,?,?)");
        preparedStatement.setLong(1,contract.getTypeId());
        preparedStatement.setDate(2,contract.getStartDate());
        preparedStatement.setDate(3,contract.getFinishDate());
        preparedStatement.setLong(4,contract.getUserId());
        preparedStatement.setBigDecimal(5,contract.getAmount());
        preparedStatement.executeUpdate();
    }
}
