package org.example.repository;

import org.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Override
    List<User> findAll();

    @Override
    User save(User entity);

    @Override
    void deleteById(Long id);

    User getUserById(Long id);


    boolean existsUserByEmail(String email);

    boolean existsUserByPhone(String phone);

}
