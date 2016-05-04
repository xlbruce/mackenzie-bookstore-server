package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
