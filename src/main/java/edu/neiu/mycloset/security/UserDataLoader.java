package edu.neiu.mycloset.security;

import edu.neiu.mycloset.data.UserRepository;
import edu.neiu.mycloset.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class UserDataLoader implements CommandLineRunner {

    private UserRepository userRepo;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserDataLoader(UserRepository userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;

    }

    @Override
    public void run(String... args) throws Exception {
//        User user = new User("tlamb2@neiu.edu", "tlamb2", passwordEncoder.encode("password"),
//                "Tyrin", "Lamb");
//        user.setRoles(Set.of(User.Role.ROLE_ADMIN));
//        user.setEnabled(true);
//        userRepo.save(user);
//
//        User user1 = new User("db@gmail.com", "Db123", passwordEncoder.encode("password"),
//                "Tyris", "Jones");
//        user1.setRoles(Set.of(User.Role.ROLE_ADMIN));
//        user1.setEnabled(true);
//        userRepo.save(user1);

    }
}
