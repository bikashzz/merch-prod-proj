package org.jsp.userbootapi.service;
import java.util.List;
import java.util.Optional;
import org.jsp.userbootapi.dao.UserDao;
import org.jsp.userbootapi.dto.ResponseStructure;
import org.jsp.userbootapi.dto.User;
import org.jsp.userbootapi.exception.IdNotFoundException;
import org.jsp.userbootapi.exception.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService 
{
	@Autowired
	private UserDao userDao;
	
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user)
	{
		ResponseStructure<User> structure=new ResponseStructure<>();
		structure.setMessage("User saved succesfully");
		structure.setData(userDao.saveUser(user));
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.CREATED);
	}
	
	
	public ResponseEntity<ResponseStructure<User>> updateUser( User user)
	{
		ResponseStructure<User> structure=new ResponseStructure<>();
		structure.setMessage("User update succesfully");
		structure.setData(userDao.saveUser(user));
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
        return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.ACCEPTED);
	}
	
	
	
	public ResponseEntity<ResponseStructure<User>> findUserById(int id)
	{
		Optional<User> dBUser=userDao.findById(id);
		ResponseStructure<User> structure=new ResponseStructure<>();
		if(dBUser.isPresent())
		{
			structure.setMessage("User Found");
			structure.setData(dBUser.get());
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
			
		}
		throw new IdNotFoundException();	
	}
	
	
	public ResponseEntity<ResponseStructure<List<User>>> findAllUsers()
	{
		ResponseStructure<List<User>> structure=new ResponseStructure<>();
		structure.setMessage("List of All Users");
		structure.setData(userDao.findAll());
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<User>>>(structure, HttpStatus.OK);
	}
	
	
	public ResponseEntity<ResponseStructure<String>> deleteUser(int id)
	{
		ResponseStructure<String> structure=new ResponseStructure<>();
		Optional<User> dBUser=userDao.findById(id);
		if(dBUser.isPresent())
		{
			userDao.delete(id);
			structure.setMessage("User Deleted");
			structure.setData("User Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);	
		}
		structure.setMessage("User Not Deleted");
		structure.setData("User Not Found");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());	
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<ResponseStructure<User>> verifyUser(long phone, String password)
	{
		ResponseStructure<User> structure=new ResponseStructure<>();
		Optional<User> dBUser=userDao.verifyUser(phone,password);
		if(dBUser.isPresent())
		{	
			structure.setMessage("User found and verified");
			structure.setData(dBUser.get());
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);	
		}
		throw new InvalidCredentialsException();
	}
	 
	public ResponseEntity<ResponseStructure<User>> verifyUser(String email,String password)
	{
		ResponseStructure<User> structure=new ResponseStructure<>();
		 Optional<User> dBUser=userDao.verifyUser(email, password);
		if(dBUser.isPresent())
		{
			structure.setMessage("User found and verified");
			structure.setData(dBUser.get());
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
			
		}
		structure.setMessage("Invalid email or password");
		structure.setData(dBUser.get());
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<ResponseStructure<User>> verifyUser(int id, String password)
	{
		ResponseStructure<User> structure= new ResponseStructure<>();
		Optional<User> dBUser=userDao.verifyUser(id, password);
		if(dBUser.isPresent())
		{
			structure.setMessage("User Found and successfully verified");
			structure.setData(dBUser.get());
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
		}
	throw new InvalidCredentialsException();
	}
	
	
	public ResponseEntity<ResponseStructure<List<User>>> findbyname(String name)
	{
		ResponseStructure<List<User>> structure =new ResponseStructure<>();
		Optional<List<User>>dBUser=userDao.findbyname(name);
		if(dBUser.isPresent())
		{
			structure.setMessage("User found ");
			structure.setData(dBUser.get());
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<User>>>(structure,HttpStatus.OK);
			
		}
		structure.setMessage("Invalid email or password");
		structure.setData(dBUser.get());
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<List<User>>>(structure,HttpStatus.NOT_FOUND);
		
	}
	
	public ResponseEntity<ResponseStructure<User>> verifyUser(int age)
	{
		ResponseStructure<User> structure=new ResponseStructure<>();
		Optional<User>dBUser=userDao.verifyUser(age);
		if(dBUser.isPresent())
		{
			structure.setMessage("User found and verified");
			structure.setData(dBUser.get());
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
		}
	throw new InvalidCredentialsException();
	}
}
	
	

