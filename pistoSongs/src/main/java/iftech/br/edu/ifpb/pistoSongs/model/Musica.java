package iftech.br.edu.ifpb.pistoSongs.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_musica")
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private int duracao;

    @ManyToOne
    @JoinColumn(name = "album_id", nullable = false, foreignKey = @ForeignKey(name = "fk_musica_album_id"))
    private Album album;

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

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
