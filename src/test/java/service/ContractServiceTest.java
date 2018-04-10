package service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ContractServiceTest {

    @InjectMocks
    private ContractService contractService = new ContractService();

    @Test
    public void averageAmount() {
        Integer average = contractService.averageAmount(5000, 6000);
        Assert.assertEquals(new Integer(5500), average);
    }

    @Test
    public void averageAmountOverflow() {
        Integer average = contractService.averageAmount(Integer.MAX_VALUE, 6000);
        Assert.assertEquals(new Integer(5500), average);
    }
}