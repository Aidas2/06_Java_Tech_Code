package lt.akademijait.warehouse.users.controller;

public class UserGetCommand {

    private String username;
	// private String firstname;
	// private String lastname;
    private String email;
	// private boolean isAdmin;
	// private boolean isLocked;

    public UserGetCommand() {

    }

	// Originalus konstruktorius iš mūsų dokumentų aplikacijos
    public UserGetCommand(String username, String firstname, String lastname, String email, boolean isAdmin, boolean isLocked) {
        this.username = username;
        this.email = email;
    }

	// Mano pakoreguotas konstruktorius iš mūsų dokumentų aplikacijos
	public UserGetCommand(String username, String email) {
		this.username = username;
		this.email = email;
	}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

	/*
	 * public String getFirstname() { return firstname; }
	 */

	/*
	 * public void setFirstname(String firstname) { this.firstname = firstname; }
	 */

	/*
	 * public String getLastname() { return lastname; }
	 */

	/*
	 * public void setLastname(String lastname) { this.lastname = lastname; }
	 */

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	/*
	 * public boolean isAdmin() { return isAdmin; }
	 */

	/*
	 * public void setAdmin(boolean admin) { isAdmin = admin; }
	 */

	/*
	 * public boolean isLocked() { return isLocked; }
	 */

	/*
	 * public void setLocked(boolean locked) { isLocked = locked; }
	 */
}
