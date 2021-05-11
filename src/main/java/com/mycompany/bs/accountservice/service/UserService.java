package com.mycompany.bs.accountservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import com.mycompany.bs.accountservice.dto.UserDto;

@Service
public class UserService {
	
	private final List<UserDto> users = new ArrayList<>();
	
	public List<UserDto> getAllUsers() {
		return users;
	}
	
	public UserDto getUser(String username) {
		return users
				.stream()
				.filter(u -> username.equals(u.getUsername()))
				.findAny()
				.orElseThrow(() -> new NoSuchElementException("The user doesn't exists."));
	}
	
	@PostConstruct
	public void setUp() {
		IntStream
			.range(1, 10)
			.forEach(i -> users.add(new UserDto(i, "user"+i, "FirstName"+i, "LastName"+i)));
	}

}
