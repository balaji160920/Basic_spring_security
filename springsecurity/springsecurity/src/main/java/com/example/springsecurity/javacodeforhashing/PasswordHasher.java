package com.example.springsecurity.javacodeforhashing;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHasher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
		String pt="admin1234";
		String hashedPassword=encoder.encode(pt);
		System.out.println(hashedPassword);
	}

}
