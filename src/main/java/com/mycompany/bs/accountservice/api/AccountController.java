package com.mycompany.bs.accountservice.api;

import static org.springframework.http.HttpStatus.OK;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.mycompany.bs.accountservice.dto.UserDto;
import com.mycompany.bs.accountservice.service.UserService;

@Controller("/api")
public class AccountController {
	
	@Resource
	private UserService userService;
	
	@GetMapping("/users/{username}")
	public ResponseEntity<UserDto> getUser(@PathVariable("username") String username) {
		return new ResponseEntity<>(userService.getUser(username), OK);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<UserDto>> getAllUsers(@PathVariable("username") String username) {
		return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
	}

}
