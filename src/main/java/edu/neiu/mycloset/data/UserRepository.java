package edu.neiu.mycloset.data;

import edu.neiu.mycloset.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);



}
