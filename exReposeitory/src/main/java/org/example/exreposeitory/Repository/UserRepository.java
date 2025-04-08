package org.example.exreposeitory.Repository;

import org.example.exreposeitory.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("SELECT s FROM User s where  s.id = ?1")
    User geveTheId(Integer id);

    User findUserByUserNameAndPassword(String userName , String password);

    User findUserByEmail (String email);

    List<User> findUserByRole(String role);

    @Query("select a from User a where a.age>=?1")
    List<User> userAge(Integer age );

}
