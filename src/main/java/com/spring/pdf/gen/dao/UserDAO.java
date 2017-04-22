package com.spring.pdf.gen.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.pdf.gen.model.User;
@Repository
public class UserDAO {

	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		User user1 = new User(118, "Basanta", 24, "9438380592",
				"techbasanta757@gmail.com", "Marathali,SGR Dental College");
		User user2 = new User(111, "Santosh", 26, "8867992920",
				"santosh.babul@gmail.com", "Marathali,Lally Lane");
		User user3 = new User(191, "Ashik", 24, "8867009988",
				"ashik.nrhm@gmail.com", "Odisha,Phulabani");
		User user4 = new User(177, "Amit", 25, "9900887766",
				"amit.nalco@gmail.com", "Odisha,Dhenkanal");
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
		Collections.sort(users);
		return users;
	}
}
