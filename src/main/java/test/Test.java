package test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {
	public static void main(String[] args) {
		BCryptPasswordEncoder pass = new BCryptPasswordEncoder();
		String password = "admin";
//		pass.encode(password);
		
		System.out.println(pass.encode(password));
	}
}
