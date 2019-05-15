package pl.kamol84.giveawaystuff.entity;

import lombok.Data;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.kamol84.giveawaystuff.repository.RoleRepository;
import pl.kamol84.giveawaystuff.repository.UserRepository;

import java.lang.reflect.Array;
import java.util.Arrays;

@Component
@Data
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = false;

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public InitialDataLoader(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        if (alreadySetup)
            return;

        createRoleIfNotFound("ROLE_ADMIN");
        createRoleIfNotFound("ROLE_USER");

        Role adminRole = roleRepository.findByName("ROLE_ADMIN");
        Role userRole = roleRepository.findByName("ROLE_USER");
        User userAdmin = new User();
        userAdmin.setEmail("Test@test.com");
        userAdmin.setPassword(passwordEncoder.encode("test"));
        userAdmin.setRoles(Arrays.asList(adminRole));
        userRepository.save(userAdmin);

        User user = new User();
        user.setEmail("kamil@gmail.com");
        user.setPassword(passwordEncoder.encode("test"));
        user.setRoles(Arrays.asList(userRole));
        userRepository.save(user);


        alreadySetup = true;
    }

    @Transactional
    Role createRoleIfNotFound(String name) {

        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role(name);
            roleRepository.save(role);
        }
        return role;
    }
}
