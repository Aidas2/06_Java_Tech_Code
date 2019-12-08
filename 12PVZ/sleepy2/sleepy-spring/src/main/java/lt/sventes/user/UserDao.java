package lt.sventes.user;

import java.util.List;

import lt.sventes.user.User;

public interface UserDao {
	List<User> getUsers();

	void createUser(User user);

	void deleteUser(String username);
}
