package it.akademija.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.akademija.model.User;

@Service
public class UserService {
	@Autowired
	@Qualifier("repoUserDao")
	private UserDao userDao;

	@Transactional(readOnly = true)
	public List<User> getUsers() {
		return userDao.getUsers();
	}

	@Transactional
	public void createUser(User user) {
		userDao.createUser(user);
	}
	
	@Transactional
	public void deleteUser(String username) {
		userDao.deleteUser(username);
	}

}
