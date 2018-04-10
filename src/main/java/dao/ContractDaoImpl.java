package dao;

import mapper.ContractMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import pojo.Contract;

import javax.sql.DataSource;
import java.util.List;

public class ContractDaoImpl implements ContractDao {
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Contract> getAll() {
        String sql = "select * from contract";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate.query(sql, new ContractMapper());
    }

    @Override
    public void deleteAll() {
        String sql = "delete from contract";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql);
    }

    @Override
    public void insert(Contract contract) {
        String sql = "insert into contract values (default,?,?,?,?,?)";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql,
                contract.getTypeId(),
                contract.getStartDate(),
                contract.getFinishDate(),
                contract.getUserId(),
                contract.getAmount());
    }

    @Override
    public List<Contract> selectContract(Long contractId) {
        String sql = "select * from contract where contract_id = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate.query(sql, new Long[]{contractId},new ContractMapper());
    }

    @Override
    public void update(Contract contract) {
        String sql = "update contract set type_id=?, start_date=?, finish_date=?, user_id=?, amount=? where contract_id = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql,
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
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql,contractId);
    }

    @Override
    public List<Contract> getFioAndAddress() {
        String sql =
                "select u.lastname, u.firstname, u.patronimyc, tfv.value from active_contract " +
                "  join type_field_values tfv on active_contract.contract_id = tfv.contract_id " +
                "  join users u on active_contract.user_id = u.user_id " +
                "where active_contract.type_id = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate.query(sql, new ContractMapper(), 20);
    }

    @Override
    public List<Contract> getFioWithMaxAmount() {
        String sql =
                "select u.lastname, u.firstname, u.patronimyc " +
                "from contract c " +
                "   join users u on u.user_id = c.user_id ORDER BY c.amount DESC " +
                "LIMIT 1";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate.query(sql, new ContractMapper());
    }

    @Override
    public List<Contract> getActiveContractsGroupByTypes() {
        String sql = "select ct.name, count(ac.type_id) " +
                        "from active_contract ac " +
                        "  join contract_types ct on ac.type_id = ct.contract_type_id " +
                        "group by ct.contract_type_id";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate.query(sql, new ContractMapper());
    }
}
