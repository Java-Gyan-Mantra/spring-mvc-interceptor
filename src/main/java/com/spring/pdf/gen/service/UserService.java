package com.spring.pdf.gen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.pdf.gen.dao.UserDAO;
import com.spring.pdf.gen.model.User;

@Service
public class UserService {
	@Autowired(required = true)
	private UserDAO dao;

	public List<User> getUsers() {
		return dao.getUsers();
	}
}
