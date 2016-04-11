package dk.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 52947 on 07-04-2016.
 */

@NoRepositoryBean
interface BaseRepository<TEntity, EntityID extends Serializable> extends Repository<TEntity, EntityID> {

    void delete(TEntity deleted);

    List<TEntity> findAll();

    TEntity findOne(EntityID id);

    TEntity save(TEntity persisted);
}

