package repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.entities.Announce;
import model.entities.AnnouncePK;

public interface AnnounceRepository extends JpaRepository<Announce, AnnouncePK>{

	@Query("SELECT a FROM Announce a WHERE a.book.isbn IN :isbns")
	public List<Announce> findByIsbns(@Param("isbns") Set<String> isbns);
}
