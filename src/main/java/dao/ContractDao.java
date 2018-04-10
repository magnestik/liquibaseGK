package dao;

import pojo.Contract;

import java.util.List;

public interface ContractDao {

    List<Contract> getAll();

    void deleteAll();

    void insert(Contract contract);

    List<Contract> selectContract(Long contractId);

    void update(Contract contract);

    void deleteContract(Long contractId);

    List<Contract> getFioAndAddress();

    List<Contract> getFioWithMaxAmount();

    List<Contract> getActiveContractsGroupByTypes();
}
