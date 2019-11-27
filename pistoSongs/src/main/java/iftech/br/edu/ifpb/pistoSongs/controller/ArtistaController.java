package iftech.br.edu.ifpb.pistoSongs.controller;

import iftech.br.edu.ifpb.pistoSongs.dto.request.ArtistaRequest;
import iftech.br.edu.ifpb.pistoSongs.dto.response.ArtistaResponse;
import iftech.br.edu.ifpb.pistoSongs.model.Artista;
import iftech.br.edu.ifpb.pistoSongs.services.ArtistaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/api/artistas")
public class ArtistaController {
    private ArtistaService artistaService;

    public ArtistaController(ArtistaService artistaService) {
        this.artistaService = artistaService;
    }

    @PostMapping
    public ResponseEntity<ArtistaResponse> cadastrarArtista(@Valid @RequestBody ArtistaRequest request){
        Artista artista = this.artistaService.inserirArtista(request);
        return ResponseEntity.ok(ArtistaResponse.from(artista));
    }

    @GetMapping
    public ResponseEntity<Page<ArtistaResponse>> listarArtistas(Pageable pageable){
        Page<Artista> artistas = this.artistaService.listarArtistas(pageable);
        return ResponseEntity.ok(ArtistaResponse.from(artistas));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArtistaResponse> buscarArtista(@Valid @PathVariable("id") long id){
        Artista artista = this.artistaService.buscarArtista(id);
        return ResponseEntity.ok(ArtistaResponse.from(artista));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArtistaResponse> atualizarArtista(@Valid @PathVariable("id")long id,
                                                            @Valid @RequestBody ArtistaRequest request){
        Artista artista = this.artistaService.atualizarArtista(id, request);
        return ResponseEntity.ok(ArtistaResponse.from(artista));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerArtista(@Valid @PathVariable("id") long id){
        this.artistaService.removerArtista(id);
        return ResponseEntity.ok().build();
    }
}
