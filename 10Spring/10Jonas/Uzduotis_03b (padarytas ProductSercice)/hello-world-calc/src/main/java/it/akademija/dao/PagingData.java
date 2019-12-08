package it.akademija.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import it.akademija.model.UserController;

import org.springframework.context.annotation.ScopedProxyMode;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PagingData {
	private int limit;
	@Autowired
	@Qualifier("restController")
	UserController userController;

	@Autowired
	@Qualifier("repoUserDao")
	private UserDao userDao;
	
	public PagingData() {
		this.limit = 5; // <numatytasis filtras>
	}
// getters and setters
}
