package repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.entities.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

	//@Query("SELECT a FROM Author a WHERE a.name LIKE CONCAT('%',:name,'%')")
	List<Author> findByName(String name);

	
}
