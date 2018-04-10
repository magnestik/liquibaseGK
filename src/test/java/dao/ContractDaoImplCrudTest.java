package dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import pojo.Contract;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@RunWith(SpringRunner.class)
public class ContractDaoImplCrudTest {

    @Autowired
    private ContractDaoImpl contractDao;

    @Test
    public void testCrudOperations(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        //insert
        try {
            Date start = (Date) format.parse("2016-03-05");
            Date finish = (Date) format.parse("2019-05-22");
            Contract contract = new Contract(10, start, finish, 10,63000);
            contractDao.insert(contract);
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}