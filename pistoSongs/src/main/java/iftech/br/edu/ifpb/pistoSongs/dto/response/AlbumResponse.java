package iftech.br.edu.ifpb.pistoSongs.dto.response;

import iftech.br.edu.ifpb.pistoSongs.model.Album;
import org.springframework.data.domain.Page;

public class AlbumResponse {
    private long id;
    private String nome;
    private int faixas;
    private int anoGravacao;
    private String genero;
    private long artistaId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getFaixas() {
        return faixas;
    }

    public void setFaixas(int faixas) {
        this.faixas = faixas;
    }

    public int getAnoGravacao() {
        return anoGravacao;
    }

    public void setAnoGravacao(int anoGravacao) {
        this.anoGravacao = anoGravacao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public long getArtistaId() {
        return artistaId;
    }

    public void setArtistaId(long artistaId) {
        this.artistaId = artistaId;
    }

    public static AlbumResponse from(Album album){
        AlbumResponse albumResponse = new AlbumResponse();

        albumResponse.setAnoGravacao(album.getAnoGravacao());
        albumResponse.setArtistaId(album.getArtista().getId());
        albumResponse.setFaixas(album.getFaixas());
        albumResponse.setGenero(album.getGenero());
        albumResponse.setId(album.getId());
        albumResponse.setNome(album.getNome());
        return albumResponse;
    }

    public static Page<AlbumResponse> from(Page<Album> albums){
        Page<AlbumResponse> responses = albums.map(album -> {
            AlbumResponse albumResponse = new AlbumResponse();

            albumResponse.setAnoGravacao(album.getAnoGravacao());
            albumResponse.setArtistaId(album.getArtista().getId());
            albumResponse.setFaixas(album.getFaixas());
            albumResponse.setGenero(album.getGenero());
            albumResponse.setId(album.getId());
            albumResponse.setNome(album.getNome());
            return albumResponse;
        });

        return responses;
    }

//    public static List<AlbumResponse> from(List<Album> albums){
//        List<AlbumResponse> albumResponses  = albums.forEach(album -> {
//            AlbumResponse albumResponse = new AlbumResponse();
//            albumResponse.setNome(album.getNome());
//            return albumResponse;
//            });
//        return albumResponses;
//    }
}
