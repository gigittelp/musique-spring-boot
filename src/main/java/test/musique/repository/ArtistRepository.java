package test.musique.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import test.musique.model.Artist;


public interface ArtistRepository extends JpaRepository<Artist, Long>{
	// ecriture de la signature avec nommage contraint et JPA-hibernate qui genère le code
    public List<Artist> findByNameContaining(String name) ;
}