package dk.repository;

import dk.model.User;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 52947 on 07-04-2016.
 */
@RepositoryRestResource(collectionResourceRel = "user", path = "user")
public interface UserRepository extends BaseRepository<User, String> {

    List<User> findByUserName(@Param("username") String username);

}
