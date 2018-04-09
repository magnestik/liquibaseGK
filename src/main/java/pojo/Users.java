package pojo;


import java.util.Date;

public class Users {

  private long userId;
  private String lastname;
  private String firstname;
  private String patronimyc;
  private Date birthday;


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }


  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }


  public String getPatronimyc() {
    return patronimyc;
  }

  public void setPatronimyc(String patronimyc) {
    this.patronimyc = patronimyc;
  }


  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

}
