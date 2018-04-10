package mapper;

import org.springframework.jdbc.core.RowMapper;
import pojo.Contract;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContractMapper implements RowMapper<Contract> {
    public Contract mapRow(ResultSet resultSet, int i) throws SQLException {
        Contract contract = new Contract();
        contract.setContractId(resultSet.getLong("contract_id"));
        contract.setTypeId(resultSet.getLong("type_id"));
        contract.setStartDate(resultSet.getDate("start_date"));
        contract.setFinishDate(resultSet.getDate("finish_date"));
        contract.setUserId(resultSet.getLong("user_id"));
        contract.setAmount(resultSet.getInt("amount"));
        return contract;
    }
}
