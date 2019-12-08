package lt.svs.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lt.svs.enums.CustomerType;

@Entity
@Table (name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column (name="name", unique=true, nullable=false)
    private String name;

    @Column (name="surname", unique=true, nullable=false)
    private String surname;

    @Column (nullable=false)
    private Date birthDate;

    @Column (nullable=false)
    private String phoneNumber;

    @Enumerated(value = EnumType.STRING)
    @Column (nullable=false)
    private CustomerType type;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "customer_inventor",
            joinColumns = @JoinColumn(name = "customer_name"), inverseJoinColumns =
    @JoinColumn(name = "inventor_title"))
    private Set<Inventor> inventorsList = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "customer_report",
            joinColumns = @JoinColumn(name = "customer_name"), inverseJoinColumns =
    @JoinColumn(name = "report_title"))
    private Set<Report> reportsList = new HashSet<>();

    public Customer() {
    }

    public Customer(
            //Long id,
            String name, String surname, Date birthDate, String phoneNumber, CustomerType type) {
        //this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.type = type;
    }

    public Customer(
            //Long id,
            String name, String surname, Date birthDate, String phoneNumber, CustomerType type, Set<Inventor> inventorsList, Set<Report> reportsList) {
        //this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.type = type;
        this.inventorsList = inventorsList;
        this.reportsList = reportsList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public CustomerType getType() {
        return type;
    }

    public void setType(CustomerType type) {
        this.type = type;
    }

    public Set<Inventor> getInventorsList() {
        return inventorsList;
    }

    public void setInventorsList(Set<Inventor> inventorsList) {
        this.inventorsList = inventorsList;
    }

    public Set<Report> getReportsList() {
        return reportsList;
    }

    public void setReportsList(Set<Report> reportsList) {
        this.reportsList = reportsList;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", type=" + type +
                ", inventorsList=" + inventorsList +
                ", reportsList=" + reportsList +
                '}';
    }
}
