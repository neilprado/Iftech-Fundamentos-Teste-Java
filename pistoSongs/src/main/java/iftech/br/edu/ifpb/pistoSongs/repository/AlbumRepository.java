package iftech.br.edu.ifpb.pistoSongs.repository;

import iftech.br.edu.ifpb.pistoSongs.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlbumRepository extends JpaRepository<Album, Long> {
    Optional<Album> findByNome(String nome);
}
