package entity;

import java.sql.Date;

/**
 * Договор
 *
 * @author vagabov
 */
public class Contract {

    /**
     * Идентификатор
     */
    private long contractId;

    /**
     * ИД типа
     */
    private long typeId;

    /**
     * Дата начала
     */
    private Date startDate;

    /**
     * Дата окончания
     */
    private Date finishDate;

    /**
     * ИД пользователя
     */
    private long userId;

    /**
     * Сумма
     */
    private Integer amount;

    /**
     * ФИО пользователя
     */
    private String userFio;

    /**
     * Адрес участка аренды
     */
    private String address;

    /**
     * Наименование компании предоставляющей услугу пользователю
     */
    private String companyName;

    /**
     * @return {@link #contractId}
     */
    public long getContractId() {
        return contractId;
    }

    /**
     * @param contractId
     */
    public void setContractId(long contractId) {
        this.contractId = contractId;
    }

    /**
     * @return {@link #typeId}
     */
    public long getTypeId() {
        return typeId;
    }

    /**
     * @param typeId
     */
    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    /**
     * @return {@link #startDate}
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return {@link #finishDate}
     */
    public Date getFinishDate() {
        return finishDate;
    }

    /**
     * @param finishDate
     */
    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    /**
     * @return {@link #userId}
     */
    public long getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }

    /**
     * @return {@link #amount}
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * @param amount
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /**
     * @return {@link #userFio}
     */
    public String getUserFio() {
        return userFio;
    }

    /**
     * @param userFio
     */
    public void setUserFio(String userFio) {
        this.userFio = userFio;
    }

    /**
     * @return {@link #address}
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return {@link #companyName}
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
