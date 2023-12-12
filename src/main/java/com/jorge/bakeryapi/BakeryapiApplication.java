package com.jorge.bakeryapi;

import com.jorge.bakeryapi.model.Role;
import com.jorge.bakeryapi.model.User;
import com.jorge.bakeryapi.repository.RoleRepository;
import com.jorge.bakeryapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@RequiredArgsConstructor
public class BakeryapiApplication implements CommandLineRunner {
	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final PasswordEncoder passwordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(BakeryapiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setUsername("Jorge");

		String encodedPassword = passwordEncoder.encode("jorge123");
		user.setPassword(encodedPassword);

		Role role = roleRepository.save(Role.builder().name("ADMIN").build());

		user.getRoles().add(role);

		userRepository.save(user);
	}
}
