package lt.sventes.entities;

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

import lt.sventes.enums.Zodiac;

@Entity
@Table (name = "Years")
public class Year {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@Column (name="title", unique=true, nullable=false)
	private Integer year;

	@Column
	private Integer month;

	@Column
	private Integer day;

	@Enumerated(EnumType.STRING)
	@Column
	private Zodiac zodiac;

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(name = "holiday_year",
			joinColumns = @JoinColumn(name = "year_title"), inverseJoinColumns =
	@JoinColumn(name = "holiday_title"))
	private Set<Holiday> holidaysList = new HashSet<>();

	public Year() {
	}

	public Year(
			//Long id,
			Integer year, Integer month, Integer day, Zodiac zodiac) {
		//this.id = id;
		this.year = year;
		this.month = month;
		this.day = day;
		this.zodiac = zodiac;
	}

	public Year(
			//Long id,
			Integer year,
			Integer month,
			Integer day,
			Zodiac zodiac,
			Set<Holiday> holidaysList) {
		//this.id = id;
		this.year = year;
		this.month = month;
		this.day = day;
		this.zodiac = zodiac;
		this.holidaysList = holidaysList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}


	public Zodiac getZodiac() {
		return zodiac;
	}

	public void setZodiac(Zodiac zodiac) {
		this.zodiac = zodiac;
	}

	public Set<Holiday> getHolidaysList() {
		return holidaysList;
	}

	public void setHolidaysList(Set<Holiday> holidaysList) {
		this.holidaysList = holidaysList;
	}

	@Override
	public String toString() {
		return "Year{" +
				"id=" + id +
				", year=" + year +
				", month=" + month +
				", day=" + day +
				", zodiac=" + zodiac +
				", holidaysList=" + holidaysList +
				'}';
	}
}
