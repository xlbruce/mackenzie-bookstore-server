package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.entities.Announce;
import model.entities.AnnouncePK;

public interface AnnounceRepository extends JpaRepository<Announce, AnnouncePK>{

}
