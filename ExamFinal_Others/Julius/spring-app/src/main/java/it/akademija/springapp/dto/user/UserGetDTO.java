package it.akademija.springapp.dto.user;


import it.akademija.springapp.enums.UserType;

import java.time.LocalDate;

public class UserGetDTO {

    private String id;

    private String firstName;

    private String lastName;

    private LocalDate dob;

    private String phoneNumber;

    private UserType userType;

    private Integer inventoryCount;

    public UserGetDTO() {
    }

    public UserGetDTO(String id, String firstName, String lastName, LocalDate dob, String phoneNumber, UserType userType, Integer inventoryCount) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.userType = userType;
        this.inventoryCount = inventoryCount;
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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getInventoryCount() {
        return inventoryCount;
    }

    public void setInventoryCount(Integer inventoryCount) {
        this.inventoryCount = inventoryCount;
    }
}
