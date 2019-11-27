package iftech.br.edu.ifpb.pistoSongs.dto.response;

import iftech.br.edu.ifpb.pistoSongs.model.Musica;
import org.springframework.data.domain.Page;

public class MusicaResponse {
    private long id;
    private String nome;
    private int duracao;
    private long albumId;

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

    public long getDuracao() {
        return this.duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(long albumId) {
        this.albumId = albumId;
    }

    public static MusicaResponse from(Musica musica){
        MusicaResponse response = new MusicaResponse();

        response.setId(musica.getId());
        response.setAlbumId(musica.getAlbum().getId());
        response.setDuracao(musica.getDuracao());
        response.setNome(musica.getNome());

        return response;
    }

    public static Page<MusicaResponse> from(Page<Musica> musicas){
        Page<MusicaResponse> responses = musicas.map(musica -> {
            MusicaResponse response = new MusicaResponse();

            response.setId(musica.getId());
            response.setAlbumId(musica.getAlbum().getId());
            response.setDuracao(musica.getDuracao());
            response.setNome(musica.getNome());

            return response;
        });
        return responses;
    }
}
