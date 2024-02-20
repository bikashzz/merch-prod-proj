package org.jsp.userbootapi.exception;

public class InvalidCredentialsException  extends RuntimeException{
@Override
	public String getMessage() {
		
		return "Invalid phone or email or id and password" ;
	}

}
