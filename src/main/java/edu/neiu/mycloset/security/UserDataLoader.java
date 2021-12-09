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
//        User user = new User("tylamb98@neiu.edu", "tylamb98", passwordEncoder.encode("password"),
//                "Ty", "Jackson");
//        user.setRoles(Set.of(User.Role.ROLE_USER));
//        user.setEnabled(true);
//        userRepo.save(user);

    }
}
