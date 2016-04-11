package dk.repository;

import dk.model.User;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by 52947 on 08-04-2016.
 */

@Transactional
public interface UserDao extends CrudRepository<User, Integer> {

    /**
     * This method will find an User instance in the database by its username.
     * Note that this method is not implemented and its working code will be
     * automagically generated from its signature by Spring Data JPA.
     */
    User findByUsername(String username);

}

