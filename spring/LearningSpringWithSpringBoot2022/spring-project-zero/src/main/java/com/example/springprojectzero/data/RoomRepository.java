package com.example.springprojectzero.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * Methods available in Interface CrudRepository
 * <S extends T> S save(S entity);
 *
 *     <S extends T> Iterable<S> saveAll(Iterable<S> entities);
 *
 *     Optional<T> findById(ID id);
 *
 *     boolean existsById(ID id);
 *
 *     Iterable<T> findAll();
 *
 *     Iterable<T> findAllById(Iterable<ID> ids);
 *
 *     long count();
 *
 *     void deleteById(ID id);
 *
 *     void delete(T entity);
 *
 *     void deleteAllById(Iterable<? extends ID> ids);
 *
 *     void deleteAll(Iterable<? extends T> entities);
 *
 *     void deleteAll();
 */
// This is a Java Bean
    /*
    There are different extends method from the database CRUD operations
    Earlier we have used the CrudRepository<> interface extended by our repository interfaces
    Now, I am using JpaRepository<> interface to do the same operaitons
     */
@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    String name="Room Repository Interface for Data<Room>"; // default is public, static, final
}
