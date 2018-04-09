package dao;

import pojo.Contract;

import java.sql.SQLException;

public interface ContractDao {
    void insert(Contract contract) throws SQLException, ClassNotFoundException;
}
