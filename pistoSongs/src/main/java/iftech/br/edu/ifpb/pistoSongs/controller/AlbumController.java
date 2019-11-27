package iftech.br.edu.ifpb.pistoSongs.controller;

import iftech.br.edu.ifpb.pistoSongs.dto.request.AlbumRequest;
import iftech.br.edu.ifpb.pistoSongs.dto.response.AlbumResponse;
import iftech.br.edu.ifpb.pistoSongs.model.Album;
import iftech.br.edu.ifpb.pistoSongs.services.AlbumService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/albuns")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class AlbumController {
    private AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @PostMapping
    public ResponseEntity<AlbumResponse> inserirAlbum(@RequestBody AlbumRequest request){
        Album album = this.albumService.inserirAlbum(request);
        return ResponseEntity.ok(AlbumResponse.from(album));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlbumResponse> buscarAlbum(@Valid @PathVariable("id") Long id){
        Album album = this.albumService.buscarAlbum(id);
        return ResponseEntity.ok(AlbumResponse.from(album));
    }

    @GetMapping
    public ResponseEntity<Page<AlbumResponse>> listarAlbuns(Pageable pageable){
        Page<Album> albuns = this.albumService.listarAlbuns(pageable);
        return ResponseEntity.ok(AlbumResponse.from(albuns));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlbumResponse> atualizarAlbuns(@Valid @PathVariable("id") Long id,
                                                         @Valid @RequestBody AlbumRequest request){
        Album album = this.albumService.atualizarAlbum(id, request);
        return ResponseEntity.ok(AlbumResponse.from(album));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerAlbum(@Valid @PathVariable("id") Long id){
        this.albumService.removerAlbum(id);
        return ResponseEntity.ok().build();
    }
}
