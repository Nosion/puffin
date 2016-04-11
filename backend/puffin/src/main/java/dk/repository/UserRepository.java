package dk.repository;

import dk.model.User;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 52947 on 07-04-2016.
 */
public interface UserRepository extends BaseRepository<User, String> {

}
