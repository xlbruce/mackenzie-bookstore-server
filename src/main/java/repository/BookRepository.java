package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.entities.Book;

public interface BookRepository extends JpaRepository<Book, String>{
	
	@Query("SELECT b FROM Book b WHERE b.name LIKE CONCAT('%',:name,'%')")
	List<Book> findByName(@Param("name") String name);

}
