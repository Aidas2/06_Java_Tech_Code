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

	public PagingData() {
		this.limit = 5; // <numatytasis filtras>
	}

// getters and setters
	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}
}