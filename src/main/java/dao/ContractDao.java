package dao;

import entity.Contract;

import java.util.List;

/**
 * Дао договора
 *
 * @author vagabov
 */
public interface ContractDao {

    /**
     * @return ФИО пользователей и адреса участков аренды по действующим в данный момент договорам
     */
    List<Contract> getFioAndAddress();

    /**
     * @return ФИО пользователей с максимальной суммой по договорам
     */
    List<Contract> getFioWithMaxAmount();

    /**
     * @return Количество действующих договоров по каждому из существующих типов
     */
    List<Contract> getActiveContractsGroupByTypes();
}
