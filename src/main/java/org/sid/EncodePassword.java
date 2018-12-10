package org.sid;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncodePassword {
	
	public static void main(String[] args) {
		
		String password="123";
		BCryptPasswordEncoder pass=new BCryptPasswordEncoder();
		String hash=pass.encode(password);
		
		System.out.println(hash);
		
		
		
	}

}
