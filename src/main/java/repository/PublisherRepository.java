package repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.entities.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Integer>{

	//@Query("SELECT p FROM Publisher p  WHERE p.name LIKE CONCAT('%',:name,'%')")
	List<Publisher> findByName(String name);
}
