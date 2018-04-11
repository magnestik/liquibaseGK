package dao;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ContractDaoImplReportTest {

    private ContractDao contractDao = new ContractDaoImpl();

    @Test
    public void getFioAndAddress() {
        assertEquals(1, contractDao.getFioAndAddress().size());
    }

    @Test
    public void getFioWithMaxAmount() {
        assertEquals(1, contractDao.getFioWithMaxAmount().size());
    }

    @Test
    public void getActiveContractsGroupByTypes() {
        assertEquals(2, contractDao.getActiveContractsGroupByTypes().size());
    }
}