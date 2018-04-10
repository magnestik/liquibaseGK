package dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import pojo.Contract;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ContractDaoImplReportTest {

    @InjectMocks
    private ContractDao contractDao = new ContractDaoImpl();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getFioAndAddress() {
        List<Contract> contracts = contractDao.getFioAndAddress();
        assertEquals(1, contracts);
    }

    @Test
    public void getFioWithMaxAmount() {
    }

    @Test
    public void getActiveContractsGroupByTypes() {
    }
}