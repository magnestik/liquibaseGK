package dao;

import pojo.Contract;

import java.util.List;

public interface ContractDao {

    List<Contract> getFioAndAddress();

    List<Contract> getFioWithMaxAmount();

    List<Contract> getActiveContractsGroupByTypes();
}
