package org.jsp.userbootapi.exception;

public class IdNotFoundException extends RuntimeException
{
	@Override
	public String getMessage()
	{
		return "Invalid id ";
		
	}
}
