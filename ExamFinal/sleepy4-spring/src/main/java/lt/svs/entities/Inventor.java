package lt.svs.entities;

import java.util.Date;
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
@Table(name = "Inventor")
public class Inventor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", unique = true, nullable = false)
    private String title;

    @Column
    private Double weight;

    @Column
    private Integer numberOfSector;

    @Column
    private Date placementDate;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH})
    @JoinTable(name = "customer_inventor",
            joinColumns = @JoinColumn(name = "inventor_title"), inverseJoinColumns =
    @JoinColumn(name = "customer_name"))
    private Set<Customer> customersList = new HashSet<>();

    public Inventor() {
    }

    public Inventor(
            //Long id,
            String title, Double weight, Integer numberOfSector, Date placementDate) {
        //this.id = id;
        this.title = title;
        this.weight = weight;
        this.numberOfSector = numberOfSector;
        this.placementDate = placementDate;
    }

    public Inventor(
            //Long id,
            String title, Double weight, Integer numberOfSector, Date placementDate, Set<Customer> customersList) {
        //this.id = id;
        this.title = title;
        this.weight = weight;
        this.numberOfSector = numberOfSector;
        this.placementDate = placementDate;
        this.customersList = customersList;
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

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getNumberOfSector() {
        return numberOfSector;
    }

    public void setNumberOfSector(Integer numberOfSector) {
        this.numberOfSector = numberOfSector;
    }

    public Date getPlacementDate() {
        return placementDate;
    }

    public void setPlacementDate(Date placementDate) {
        this.placementDate = placementDate;
    }

    public Set<Customer> getCustomersList() {
        return customersList;
    }

    public void setCustomersList(Set<Customer> customersList) {
        this.customersList = customersList;
    }

    @Override
    public String toString() {
        return "Inventor{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", weight=" + weight +
                ", numberOfSector=" + numberOfSector +
                ", placementDate=" + placementDate +
                ", customersList=" + customersList +
                '}';
    }
}
