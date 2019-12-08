package lt.svs.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import lt.svs.enums.CustomerType;

import org.hibernate.validator.constraints.Length;

public class CreateCustomerDTO {

//    private Long id;

    @NotNull
    @Length(min = 1, max = 100)
    private String name;

    @NotNull
    @Length(min = 1, max = 100)
    private String surname;

    @NotNull
    @Length(min = 1, max = 20)
    private Date birthDate;

    @NotNull
    @Length(min = 1, max = 20)
    private String phoneNumber;

    @NotNull
    @Length(min = 1, max = 80)
    private CustomerType type;

//	private Set<Inventor> inventorsList = new HashSet<>();
//
//	private Set<Report> reportsList = new HashSet<>();

    public CreateCustomerDTO() {

    }

    public CreateCustomerDTO(
            //Long id,
            @NotNull @Length(min = 1, max = 100) String name, @NotNull @Length(min = 1, max = 100) String surname, @NotNull @Length(min = 1, max = 20) Date birthDate, @NotNull @Length(min = 1, max = 20) String phoneNumber, @NotNull @Length(min = 1, max = 80) CustomerType type) {
        //this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.type = type;
    }

//    public CreateCustomerDTO(Long id, @NotNull @Length(min = 1, max = 100) String name, @NotNull @Length(min = 1, max = 100) String surname, @NotNull @Length(min = 1, max = 20) Date birthDate, @NotNull @Length(min = 1, max = 20) String phoneNumber, @NotNull @Length(min = 1, max = 80) CustomerType type, Set<Inventor> inventorsList, Set<Report> reportsList) {
//        //this.id = id;
//        this.name = name;
//        this.surname = surname;
//        this.birthDate = birthDate;
//        this.phoneNumber = phoneNumber;
//        this.type = type;
//        this.inventorsList = inventorsList;
//        this.reportsList = reportsList;
//    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

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

//    public Set<Inventor> getInventorsList() {
//        return inventorsList;
//    }
//
//    public void setInventorsList(Set<Inventor> inventorsList) {
//        this.inventorsList = inventorsList;
//    }
//
//    public Set<Report> getReportsList() {
//        return reportsList;
//    }
//
//    public void setReportsList(Set<Report> reportsList) {
//        this.reportsList = reportsList;
//    }
}
