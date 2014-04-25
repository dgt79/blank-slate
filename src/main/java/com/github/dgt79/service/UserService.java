package com.github.dgt79.service;

import com.github.dgt79.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class UserService {
	public Stream<User> getUsers() {
		List<User> users = new ArrayList<>();
		users.add(new User("ursul_polar", "ursul_polar@gmail.com"));
		users.add(new User("lolec", "lolec@gmail.com"));
		users.add(new User("bolec", "bolec@gmail.com"));

		return users.stream();
	}
}
