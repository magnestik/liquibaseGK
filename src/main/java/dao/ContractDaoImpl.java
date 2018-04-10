package dao;

import mapper.ContractMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import pojo.Contract;

import javax.sql.DataSource;
import java.util.List;

public class ContractDaoImpl implements ContractDao {
    private DataSource dataSource;

    @Override
    public List<Contract> getAll() {
        String sql = "select * from contract";
        JdbcTemplate selectContract = new JdbcTemplate(dataSource);
        return selectContract.query(sql, new ContractMapper());
    }

    @Override
    public void deleteAll() {
        String sql = "delete from contract";
        JdbcTemplate deleteContract = new JdbcTemplate(dataSource);
        deleteContract.update(sql);
    }

    @Override
    public void insert(Contract contract) {
        String sql = "insert into contract values (default,?,?,?,?,?)";
        JdbcTemplate insertContract = new JdbcTemplate(dataSource);
        insertContract.update(sql,
                contract.getTypeId(),
                contract.getStartDate(),
                contract.getFinishDate(),
                contract.getUserId(),
                contract.getAmount());
    }

    @Override
    public List<Contract> selectContract(Long contractId) {
        String sql = "select * from contract where contract_id = ?";
        JdbcTemplate selectContract = new JdbcTemplate(dataSource);
        return selectContract.query(sql, new Long[]{contractId},new ContractMapper());
    }

    @Override
    public void update(Contract contract) {
        String sql = "update contract set type_id=?, start_date=?, finish_date=?, user_id=?, amount=? where contract_id = ?";
        JdbcTemplate updateContract = new JdbcTemplate(dataSource);
        updateContract.update(sql,
                contract.getTypeId(),
                contract.getStartDate(),
                contract.getFinishDate(),
                contract.getUserId(),
                contract.getAmount(),
                contract.getContractId());
    }

    @Override
    public void deleteContract(Long contractId) {
        String sql = "delete from contract where contract_id = ?";
        JdbcTemplate deleteContract = new JdbcTemplate(dataSource);
        deleteContract.update(sql,contractId);
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
