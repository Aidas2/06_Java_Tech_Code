package lt.akademijait.warehouse;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import lt.akademijait.warehouse.roles.service.RoleRepository;
import lt.akademijait.warehouse.security.exception.AppException;
import lt.akademijait.warehouse.users.models.Role;
import lt.akademijait.warehouse.users.models.RoleName;
import lt.akademijait.warehouse.users.models.User;
import lt.akademijait.warehouse.users.service.UserRepository;

@Slf4j
@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

	// private final Logger logger =
	// LoggerFactory.getLogger(CommandLineAppRunner.class);

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {

		// ONLY FOR FIRST RUN WITH EMPTY DATABASE
		// SETS TWO ROLES AND ONE USER
		if (!roleExists("ROLE_USER")) {
			roleRepository.save(new Role(RoleName.ROLE_USER));
			log.info("Inserted role ROLE_USER");
			roleRepository.save(new Role(RoleName.ROLE_ADMIN));
			log.info("Inserted role ROLE_ADMIN");
			User user = new User("jonas", "jonas", "jonas@gmail.com", "slaptas");
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			Role userRole = roleRepository.findByName(RoleName.valueOf("ROLE_USER"))
					.orElseThrow(() -> new AppException("User Role not set."));
			user.setRoles(Collections.singleton(userRole));
			userRepository.save(user);
			log.info("Created new user jonas with password slaptas");
		} else {
			log.info("Application start");
		}
	}

	private boolean roleExists(String roleName) {
		return roleRepository.existsByName(RoleName.valueOf(roleName));
	}

}
