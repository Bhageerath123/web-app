package com.niit.webapp;

public class loginDAO {

public boolean iSValidUser(String userid,String password)

{
	if(userid.contentEquals(password))
	{
		return true;
		}
	else
		{
		
		return false;
		}
		}

}
