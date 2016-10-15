package io.github.printf.educake.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/** @author Vitor "Pliavi" Silvério */

@Entity
@Table
public class Person implements Serializable {
  
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSON_SEQUENCE")
  @SequenceGenerator(name="PERSON_SEQUENCE", sequenceName = "PERSON_SEQUENCE", allocationSize = 1,initialValue = 1)
  @Column
  private int idPerson;

  @Column
  private String name;

  @Column
  private String surname;

  @Column
  @Temporal(TemporalType.DATE)
  private Date birthdate;
  
  @OneToMany(
      mappedBy = "person",
      targetEntity = Phone.class,
      fetch = FetchType.EAGER,
      cascade = CascadeType.ALL)
  private List<Phone> phones = new ArrayList<Phone>();

  public Person() {}

  public Person(String name, String surname, Date birthdate) {
    this.name = name;
    this.surname = surname;
    this.birthdate = birthdate;
  }

  public int getIdPerson() {
    return idPerson;
  }

  public void setIdPerson(int idPerson) {
    this.idPerson = idPerson;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public Date getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(Date birthdate) {
    this.birthdate = birthdate;
  }
  
  public void addPhone(Phone phone){
      phones.add(phone);
  }
  
  
}
