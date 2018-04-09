package pojo;

import java.math.BigDecimal;
import java.sql.Date;

public class Contract {

  private long contractId;
  private long typeId;
  private Date startDate;
  private Date finishDate;
  private long userId;
  private BigDecimal amount;

  public Contract(long contractId, long typeId, Date startDate, Date finishDate, long userId, BigDecimal amount) {
    this.contractId = contractId;
    this.typeId = typeId;
    this.startDate = startDate;
    this.finishDate = finishDate;
    this.userId = userId;
    this.amount = amount;
  }

  public long getContractId() {
    return contractId;
  }

  public void setContractId(long contractId) {
    this.contractId = contractId;
  }


  public long getTypeId() {
    return typeId;
  }

  public void setTypeId(long typeId) {
    this.typeId = typeId;
  }


  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }


  public Date getFinishDate() {
    return finishDate;
  }

  public void setFinishDate(Date finishDate) {
    this.finishDate = finishDate;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

}
