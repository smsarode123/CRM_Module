package com.insurence.registrationservice.utility;

import java.util.Random;

public class Utility {
	
	private static final Random USERNAME_RANDOM=new Random(1000);
	private static final Random PASSWORD_RANDOM=new Random(1000);
	
	
	public static String genrateUsername(String employeeName)
	{
		return employeeName+USERNAME_RANDOM.nextInt(9999);
	}
	public static String genratePassword(String employeeName)
	{
		return employeeName+'@'+PASSWORD_RANDOM.nextInt(9999);
	}

}
