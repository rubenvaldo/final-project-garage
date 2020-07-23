package ie.cct.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ie.cct.springboot.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
