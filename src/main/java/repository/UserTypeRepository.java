package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.entities.UserType;

public interface UserTypeRepository extends JpaRepository<UserType, Integer> {

}
