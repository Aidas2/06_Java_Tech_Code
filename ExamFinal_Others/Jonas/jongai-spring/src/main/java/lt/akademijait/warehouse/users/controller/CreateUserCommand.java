package lt.akademijait.warehouse.users.controller;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class CreateUserCommand {
	@NotNull
	@Length(min = 1, max = 40)
	private String name;
	@NotNull
	@Length(min = 1, max = 15)
	private String username;
	@NotNull
	@Length(min = 1, max = 40)
	private String email;
	@NotNull
	@Length(min=1, max=100)
	private String password;
	@NotNull
	private String role;
	
	//Constructor
	public CreateUserCommand() {

	}
	
	//getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	

}