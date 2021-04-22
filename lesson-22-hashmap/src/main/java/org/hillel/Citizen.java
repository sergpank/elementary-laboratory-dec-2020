package org.hillel;

import java.util.Date;

public class Citizen {
  private String firstName;
  private String lastName;
  private Date dateOfBirth;
  private int age;
  private String sex;
  private long INN;

  public Citizen(String firstName, String lastName, Date dateOfBirth, int age, String sex, long INN) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.dateOfBirth = dateOfBirth;
    this.age = age;
    this.sex = sex;
    this.INN = INN;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public long getINN() {
    return INN;
  }

  public void setINN(long INN) {
    this.INN = INN;
  }

//  @Override
//  public boolean equals(Object o) {
//    if (this == o) return true;
//    if (o == null || getClass() != o.getClass()) return false;
//
//    Citizen citizen = (Citizen) o;
//
//    if (age != citizen.age) return false;
//    if (INN != citizen.INN) return false;
//
//    if (firstName != null ? !firstName.equals(citizen.firstName) : citizen.firstName != null) return false;
//
//    if (lastName != null ? !lastName.equals(citizen.lastName) : citizen.lastName != null) return false;
//    if (dateOfBirth != null ? !dateOfBirth.equals(citizen.dateOfBirth) : citizen.dateOfBirth != null) return false;
//    return sex != null ? sex.equals(citizen.sex) : citizen.sex == null;
//  }

  @Override
  public int hashCode() {
    int result = firstName != null ? firstName.hashCode() : 0;
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
    result = 31 * result + age;
    result = 31 * result + (sex != null ? sex.hashCode() : 0);
    result = 31 * result + (int) (INN ^ (INN >>> 32));
    return result;
  }

  @Override
  public String toString() {
    return "Citizen{" +
      "firstName='" + firstName + '\'' +
      ", lastName='" + lastName + '\'' +
      ", dateOfBirth=" + dateOfBirth +
      ", age=" + age +
      ", sex='" + sex + '\'' +
      ", INN=" + INN +
      '}';
  }
}
