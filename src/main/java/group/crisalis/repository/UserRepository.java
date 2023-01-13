package group.crisalis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import group.crisalis.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
    Optional<User> findById(Integer id);
    
    public User findByUsername(String username);
    Optional<User> findByName(String name);
}
