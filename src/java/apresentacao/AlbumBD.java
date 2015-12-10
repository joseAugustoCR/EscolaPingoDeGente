/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import dao.AlbumDAO;
import java.util.Collection;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author guto
 */
@ManagedBean(name = "albumBD")
@SessionScoped
public class AlbumBD {

    private Album album;
    private AlbumDAO dao;
    private Boolean novoAlbum;
    private Integer idExcluir;

    /**
     * Creates a new instance of AlbumBD
     */
    public AlbumBD() {
        album = new Album();
        dao = new AlbumDAO();
        novoAlbum = false;
        idExcluir = 0;

    }

    public Collection<Album> getAlbuns() {
        return dao.buscarTodos();

    }

    public void mostraNovoAlbum() {
        novoAlbum = true;
    }

    public void escondeNovoAlbum() {
        novoAlbum = false;
    }

    public Boolean getNovoAlbum() {
        return novoAlbum;
    }

    public void setIdExcluir(Integer id) {
        idExcluir = id;
    }

    public Integer getIdExcluir() {
        return idExcluir;
    }

    public void setTitulo(String titulo) {
        album.setTitulo(titulo);
    }

    public String getTitulo() {
        return album.getTitulo();
    }

    public void setDescricao(String descricao) {
        album.setDescricao(descricao);
    }

    public String getDescricao() {
        return album.getDescricao();
    }

    public void insere() {
        dao.inserir(album);
        novoAlbum = false;
        album = new Album();
    }

    public void excluir() {

        dao.excluir(idExcluir);

    }

}
