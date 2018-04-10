package dao;

import Connections.ConnectionManager;
import Connections.ConnectionManagerImpl;
import pojo.Contract;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContractDaoImpl implements ContractDao {
    private static ConnectionManager connectionManager = ConnectionManagerImpl.getInstance();

    public void getAll() {

    }

    public void insert(Contract contract) {
        String sql1 = "insert into contract values (default,?,?,?,?,?)";
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql1)
        ) {
            preparedStatement.setLong(1, contract.getTypeId());
            preparedStatement.setDate(2, contract.getStartDate());
            preparedStatement.setDate(3, contract.getFinishDate());
            preparedStatement.setLong(4, contract.getUserId());
            preparedStatement.setBigDecimal(5, contract.getAmount());
            preparedStatement.executeUpdate();
        }
    }

    public void select(Long contractId) {
        Connection connection = connectionManager.getConnection();
        PreparedStatement preparedStatement =
                connection.prepareStatement("select * from contract where contract_id = ?");
        preparedStatement.setLong(1,contractId);
        preparedStatement.executeQuery();
        preparedStatement.close();
        connection.close();
    }

    public void update(Contract contract) {
        String sql = "update contract set type_id=?, start_date=?, finish_date=?, user_id=?, amount=? where contract_id = ?";
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setLong(1,contract.getTypeId());
            preparedStatement.setDate(2,contract.getStartDate());
            preparedStatement.setDate(3,contract.getFinishDate());
            preparedStatement.setLong(4,contract.getUserId());
            preparedStatement.setBigDecimal(5,contract.getAmount());
            preparedStatement.setLong(6, contract.getContractId());
            preparedStatement.executeUpdate();
        }

    }

    public void delete(Long contractId) {
        Connection connection = connectionManager.getConnection();
        PreparedStatement preparedStatement =
                connection.prepareStatement("delete from contract where contract_id = ?");
        preparedStatement.setLong(1,contractId);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    }
}
