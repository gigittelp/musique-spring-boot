package test.musique.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import test.musique.model.Artist;
import test.musique.service.ArtistService;





@RestController
@RequestMapping("/test.musique")
public class ArtistController {

    @Autowired
    ArtistService service;
    
    @GetMapping("/artists/hello")
    ResponseEntity<Artist> getArtistToto() {
        Artist helloMan = new Artist();
        helloMan.setName("Hello man");
        helloMan.setBio("J'aurais voulu être un artiste");
        helloMan.setFanNumber(100);
        return ResponseEntity.ok().body(helloMan);
    }
    
    @GetMapping("/artists")
    public ResponseEntity<List<Artist>> getAllArtist(@RequestParam(value="search", defaultValue="") String search) {
        List<Artist> listArtist;
        try {
            listArtist = service.findAll(search);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(listArtist);
    }
    
    @GetMapping("/artists/{id}")
    ResponseEntity<Artist> getArtistById(@PathVariable(value="id") long id) {
        Optional<Artist> artist = service.findById(id);
        if (artist.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(artist.get());
    }
    
    @PostMapping("/artists")
    ResponseEntity<Artist> addArtist(@RequestBody Artist artist){
        return ResponseEntity.ok().body(service.insert(artist));
    }
    
    @PutMapping("/artists/{id}")
    ResponseEntity<Artist> updateArtiste(@PathVariable(value="id") long id, @RequestBody Artist artist){
        Artist updatedArtiste = service.update(id, artist);
        if(updatedArtiste == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok().body(updatedArtiste);
    }
    
    @DeleteMapping("/artists/{id}")
    ResponseEntity<Artist> deleteArtist(@PathVariable(value="id") long id){
        Optional<Artist> artist = service.findById(id);
        if(artist.isEmpty())
            return ResponseEntity.notFound().build();
        service.delete(artist.get().getId());
        return ResponseEntity.accepted().build();
    }
}