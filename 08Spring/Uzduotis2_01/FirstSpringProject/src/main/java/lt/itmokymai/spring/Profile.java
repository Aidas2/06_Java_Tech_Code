package lt.itmokymai.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Profile {
	@Autowired
	@Qualifier("student1")
	private Student student;
	private Student student2;

	public Profile() {
		System.out.println("Inside Profile constructor.");
	}

	public void printAge() {
		System.out.println("Age : " + student.getAge());
	}

	public Profile(@Qualifier("student2") Student student2) {
		this.student2 = student2;
	}
}
