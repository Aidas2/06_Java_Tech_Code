package it.akademija.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public final class CreateUserCommand {
	@NotNull
	@Length(min = 1, max = 30)
	private String username;
	@NotNull
	@Length(min = 1, max = 100)
	private String firstName;
	@NotNull
	@Length(min = 1, max = 100)
	private String lastName;
	@NotNull
	@Length(min = 1, max = 200)
	@Email
	private String email;
	@NotNull
	private int age;

// toliau - get ir set metodai
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
