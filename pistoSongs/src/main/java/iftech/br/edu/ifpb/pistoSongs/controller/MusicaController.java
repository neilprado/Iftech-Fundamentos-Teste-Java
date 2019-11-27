package iftech.br.edu.ifpb.pistoSongs.controller;

import iftech.br.edu.ifpb.pistoSongs.dto.request.MusicaRequest;
import iftech.br.edu.ifpb.pistoSongs.dto.response.MusicaResponse;
import iftech.br.edu.ifpb.pistoSongs.model.Musica;
import iftech.br.edu.ifpb.pistoSongs.services.AlbumService;
import iftech.br.edu.ifpb.pistoSongs.services.MusicaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/api/musicas")
public class MusicaController {
    private AlbumService albumService;
    private MusicaService musicaService;

    public MusicaController(AlbumService albumService, MusicaService musicaService) {
        this.albumService = albumService;
        this.musicaService = musicaService;
    }

    @PostMapping
    public ResponseEntity<MusicaResponse> cadastrarMusica(@Valid @RequestBody MusicaRequest request){
        Musica musica = this.musicaService.cadastrarMusica(request);
        return ResponseEntity.ok(MusicaResponse.from(musica));
    }

    @GetMapping
    public ResponseEntity<Page<MusicaResponse>> listarMusicas(Pageable pageable){
        Page<Musica> musicas = this.musicaService.listarMusicas(pageable);
        return ResponseEntity.ok(MusicaResponse.from(musicas));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MusicaResponse> buscarMusica(@Valid @PathVariable("id") long id){
        Musica musica = this.musicaService.buscarMusica(id);
        return ResponseEntity.ok(MusicaResponse.from(musica));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MusicaResponse> atualizarMusica(@Valid @PathVariable("id")long id,
                                                          @Valid @RequestBody MusicaRequest request){
        Musica musica = this.musicaService.atualizarMusica(id, request);
        return ResponseEntity.ok(MusicaResponse.from(musica));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerMusica(@Valid @PathVariable("id") Long id){
        this.musicaService.removerMusica(id);
        return ResponseEntity.ok().build();
    }
}
