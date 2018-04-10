package dao;

import pojo.Contract;

public interface ContractDao {

    void getAll();

    void insert(Contract contract);

    void select(Long contractId);

    void update(Contract contract);

    void delete(Long contractId);
}
