package dao;

import connections.ConnectionManager;
import connections.ConnectionManagerImpl;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import pojo.Contract;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class ContractDaoImpl implements ContractDao {

    private static final String SELECT_FIO_AND_ADDRESS =
            "select u.lastname, u.firstname, u.patronimyc, tfv.value as address " +
            "from active_contract " +
            "  join type_field_values tfv on active_contract.contract_id = tfv.contract_id " +
            "  join users u on active_contract.user_id = u.user_id " +
            "where active_contract.type_id = 20";

    private static final String SELECT_FIO_WITH_MAX_AMOUNT =
            "select u.lastname, u.firstname, u.patronimyc, c.amount " +
            "from contract c " +
            "   join users u on u.user_id = c.user_id ORDER BY c.amount DESC " +
            "LIMIT 1";

    private static final String SELECT_ACTIVE_CONTRACTS_GROUP_BY_TYPES =
            "select ct.name, count(ac.type_id) as type " +
            "from active_contract ac" +
            "  join contract_types ct on ac.type_id = ct.contract_type_id " +
            "group by ct.contract_type_id";

    private static ConnectionManager connectionManager = ConnectionManagerImpl.getInstance();
    private static Logger log = Logger.getLogger(ContractDaoImpl.class);

    @Override
    public List<Contract> getFioAndAddress() {
        List<Contract> contracts = new ArrayList<>();
        try(Connection connection = connectionManager.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_FIO_AND_ADDRESS)){
            while (resultSet.next()){
                Contract contract = new Contract();
                String userFio = resultSet.getString("lastname") + " " +
                        resultSet.getString("firstname") + " " +
                        resultSet.getString("patronimyc");
                contract.setUserFio(userFio);
                contract.setAddress(resultSet.getString("address"));
                contracts.add(contract);
            }
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return contracts;
    }

    @Override
    public List<Contract> getFioWithMaxAmount() {
        List<Contract> contracts = new ArrayList<>();
        try(Connection connection = connectionManager.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_FIO_WITH_MAX_AMOUNT)){
            while (resultSet.next()){
                Contract contract = new Contract();
                String userFio = resultSet.getString("lastname") + " " +
                        resultSet.getString("firstname") + " " +
                        resultSet.getString("patronimyc");
                contract.setUserFio(userFio);
                contract.setAmount(resultSet.getInt("amount"));
                contracts.add(contract);
            }
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return contracts;
    }

    @Override
    public List<Contract> getActiveContractsGroupByTypes() {
        List<Contract> contracts = new ArrayList<>();
        try(Connection connection = connectionManager.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ACTIVE_CONTRACTS_GROUP_BY_TYPES)){
            while (resultSet.next()){
                Contract contract = new Contract();
                contract.setCompanyName(resultSet.getString("name"));
                contract.setAmount(resultSet.getInt("type"));
                contracts.add(contract);
            }
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return contracts;
    }
}
