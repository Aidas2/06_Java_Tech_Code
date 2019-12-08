package lt.sventes.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Countries")
public class Country {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", unique = true, nullable = false)
    private String title;

    @Column
    private String imageOfFlag;

    @Column
    private String president;

    @Column
    private Double area;

    @Column
    private Long population;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH})
    @JoinTable(name = "holiday_country",
            joinColumns = @JoinColumn(name = "country_title"), inverseJoinColumns =
    @JoinColumn(name = "holiday_title"))
    private Set<Holiday> holidaysList = new HashSet<>();

    public Country() {
    }

    public Country(
            //Long id,
            String title,
            String imageOfFlag,
            String president,
            Double area,
            Long population) {
        //this.id = id;
        this.title = title;
        this.imageOfFlag = imageOfFlag;
        this.president = president;
        this.area = area;
        this.population = population;
    }

    public Country(
            //Long id,
            String title,
            String imageOfFlag,
            String president,
            Double area,
            Long population,
            Set<Holiday> holidaysList) {
        //this.id = id;
        this.title = title;
        this.imageOfFlag = imageOfFlag;
        this.president = president;
        this.area = area;
        this.population = population;
        this.holidaysList = holidaysList;
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

    public String getImageOfFlag() {
        return imageOfFlag;
    }

    public void setImageOfFlag(String imageOfFlag) {
        this.imageOfFlag = imageOfFlag;
    }

    public String getPresident() {
        return president;
    }

    public void setPresident(String president) {
        this.president = president;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public Set<Holiday> getHolidaysList() {
        return holidaysList;
    }

    public void setHolidaysList(Set<Holiday> holidaysList) {
        this.holidaysList = holidaysList;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", imageOfFlag='" + imageOfFlag + '\'' +
                ", president='" + president + '\'' +
                ", area=" + area +
                ", population=" + population +
                ", holidaysList=" + holidaysList +
                '}';
    }
}
