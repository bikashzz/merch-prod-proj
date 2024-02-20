package org.jsp.userbootapi.controller;

import java.util.List;
import org.jsp.userbootapi.dto.ResponseStructure;
import org.jsp.userbootapi.dto.User;
import org.jsp.userbootapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController 
{
	@Autowired
	private UserService service; 
	
	@PostMapping(value="/users")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user)
	{
		return service.saveUser(user);
		}
	
	@PutMapping(value="/users")
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User user)
	{
        return service.saveUser(user);
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<ResponseStructure<User>> findUserById(@PathVariable int id)
	{
		return service.findUserById(id);	
	}
	
	@GetMapping("/users")
	public ResponseEntity<ResponseStructure<List<User>>> findAllUsers()
	{
		return service.findAllUsers();
		
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteUser(@PathVariable int id)
	{
		return service.deleteUser(id);
	}	
	
	@PostMapping("/users/verify-by-phone")
	public ResponseEntity<ResponseStructure<User>> verifyUser(@RequestParam long phone, @RequestParam String password)
	{
		return service.verifyUser(phone, password) ;
		
	}
	
	@PostMapping("/users/verify-by-email")
	public ResponseEntity<ResponseStructure<User>> verifyUser(@RequestParam String email, @RequestParam String password)
	{
		return service.verifyUser(email, password);
		
	}
	
	@PostMapping("/users/verify-by-id")
	public ResponseEntity<ResponseStructure<User>> verifyUser(@RequestParam int id, @RequestParam String password)
	{
		return service.verifyUser(id, password);
		
	}
	
	@PostMapping("/users/verify-by-name")
	public ResponseEntity<ResponseStructure<List<User>>> findbyname(@RequestParam String name)
	{
		return service.findbyname(name);
		
	}
	
	@PostMapping("/users/verify-by-age")
	public ResponseEntity<ResponseStructure<User>> verifyUser(@RequestParam int age)
	{
		return service.verifyUser(age);
		
	}
}
