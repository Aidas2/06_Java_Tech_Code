package lt.svs.entities;

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

import lt.svs.enums.SectorNumber;

@Entity
@Table (name = "Reports")
public class Report {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@Column(name = "title", unique = true, nullable = false)
	private String title;

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(name = "customer_report",
			joinColumns = @JoinColumn(name = "report_title"), inverseJoinColumns =
	@JoinColumn(name = "customer_name"))
	private Set<Customer> customersList = new HashSet<>();

	public Report() {
	}

	public Report(Long id, String title) {
		this.id = id;
		this.title = title;
	}

	public Report(Long id, String title, Set<Customer> customersList) {
		this.id = id;
		this.title = title;
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

	public Set<Customer> getCustomersList() {
		return customersList;
	}

	public void setCustomersList(Set<Customer> customersList) {
		this.customersList = customersList;
	}

	@Override
	public String toString() {
		return "Report{" +
				"id=" + id +
				", title='" + title + '\'' +
				", customersList=" + customersList +
				'}';
	}
}
