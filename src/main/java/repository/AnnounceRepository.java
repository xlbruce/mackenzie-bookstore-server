package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.entities.Announce;

public interface AnnounceRepository extends JpaRepository<Announce, Integer>{

}
