package it.akademija.springapp.dto.user;

import java.util.List;

public class UserGetPageDTO {

    private List<UserGetDTO> userList;
    private long totalElements;
    private long totalPages;

    public UserGetPageDTO() {
    }

    public UserGetPageDTO(List<UserGetDTO> userList, long totalElements, long totalPages) {
        this.userList = userList;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
    }

    public List<UserGetDTO> getUserList() {
        return userList;
    }

    public void setUserList(List<UserGetDTO> userList) {
        this.userList = userList;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(long totalPages) {
        this.totalPages = totalPages;
    }
}
