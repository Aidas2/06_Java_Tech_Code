package lt.sventes.entities;

import java.time.LocalDate;
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

import lt.sventes.enums.HolidayType;

@Entity
@Table (name = "Holidays")
public class Holiday {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // what is better ?
    @Column(name="id")
    private Long id;

    @Column (name="title", unique=true, nullable=false)
    private String title;

    @Column
    private String description;

    @Enumerated(value = EnumType.STRING)
    private HolidayType type;

    @Column
    private String imageOfHoliday;

    @Column
    private boolean isFlagRaised;

    @Column
    private Date hireDate;

    @Column
    private int distance;

    @Column
    private double price;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "holiday_country",
            joinColumns = @JoinColumn(name = "holiday_title"), inverseJoinColumns =
    @JoinColumn(name = "country_title"))
    private Set<Country> countriesList = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "holiday_year",
            joinColumns = @JoinColumn(name = "holiday_title"), inverseJoinColumns =
    @JoinColumn(name = "year_title"))
    private Set<Year> yearsList = new HashSet<>();

    public Holiday() {
    }

    public Holiday(
            //Long id,
            String title,
            String description,
            HolidayType type,
            String imageOfHoliday,
            boolean isFlagRaised, Date hireDate, int distance, double price) {
        //this.id = id;
        this.title = title;
        this.description = description;
        this.type = type;
        this.imageOfHoliday = imageOfHoliday;
        this.isFlagRaised = isFlagRaised;
        this.hireDate = hireDate;
        this.distance = distance;
        this.price = price;
    }

    public Holiday(
            //Long id,
            String title,
            String description,
            HolidayType type,
            String imageOfHoliday,
            boolean isFlagRaised,
            Date hireDate,
            int distance,
            double price,
            Set<Country> countriesList, Set<Year> yearsList) {
        //this.id = id;
        this.title = title;
        this.description = description;
        this.type = type;
        this.imageOfHoliday = imageOfHoliday;
        this.isFlagRaised = isFlagRaised;
        this.hireDate = hireDate;
        this.distance = distance;
        this.price = price;
        this.countriesList = countriesList;
        this.yearsList = yearsList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public HolidayType getType() {
        return type;
    }

    public void setType(HolidayType type) {
        this.type = type;
    }

    public String getImageOfHoliday() {
        return imageOfHoliday;
    }

    public void setImageOfHoliday(String imageOfHoliday) {
        this.imageOfHoliday = imageOfHoliday;
    }

    public boolean isFlagRaised() {
        return isFlagRaised;
    }

    public void setFlagRaised(boolean flagRaised) {
        isFlagRaised = flagRaised;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<Country> getCountriesList() {
        return countriesList;
    }

    public void setCountriesList(Set<Country> countriesList) {
        this.countriesList = countriesList;
    }

    public Set<Year> getYearsList() {
        return yearsList;
    }

    public void setYearsList(Set<Year> yearsList) {
        this.yearsList = yearsList;
    }

    @Override
    public String toString() {
        return "Holiday{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", imageOfHoliday='" + imageOfHoliday + '\'' +
                ", isFlagRaised=" + isFlagRaised +
                ", hireDate=" + hireDate +
                ", distance=" + distance +
                ", price=" + price +
                ", countriesList=" + countriesList +
                ", yearsList=" + yearsList +
                '}';
    }
}
