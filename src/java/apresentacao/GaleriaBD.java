/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import dao.AlbumDAO;
import dao.GaleriaDAO;
import dao.ImagemDAO;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.faces.event.ValueChangeEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author guto
 */
@Named(value = "galeriaBD")
@ApplicationScoped
public class GaleriaBD implements Serializable {

    private GaleriaDAO dao;
    private ImagemDAO imgDao;
    private Imagem img;
    private Album album;
    private AlbumDAO albumDao;
    private Integer albumId;
    private Integer albumId_excluirFotos;
    private Collection<Imagem> imagens = new ArrayList<Imagem>();
    private Collection<Imagem> imagensParaExcluir = new ArrayList<Imagem>();
    private Collection<Integer> ids = new ArrayList<Integer>();
    private Collection<Integer> idsParaExcluir = new ArrayList<Integer>();

    public GaleriaBD() {
        this.dao = new GaleriaDAO();
        this.imgDao = new ImagemDAO();
        this.img = new Imagem();
        this.album = new Album();
        this.albumDao = new AlbumDAO();
        albumId = 0;
        albumId_excluirFotos = 0;
        imagens = dao.buscarTodos();
        imagensParaExcluir = dao.buscarTodos();
        for (Imagem temp : imagens) {
            ids.add(temp.getId());
        }
        for (Imagem temp : imagensParaExcluir) {
            idsParaExcluir.add(temp.getId());
        }
    }

    /**
     * Creates a new instance of ImagensBD
     */
    public StreamedContent getImagem() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();

        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            // So, we're rendering the view. Return a stub StreamedContent so that it will generate right URL.
            return new DefaultStreamedContent();
        } else {
            // So, browser is requesting the image. Return a real StreamedContent with the image bytes.
            String id = context.getExternalContext().getRequestParameterMap().get("imagemId");

            img = dao.buscar(Integer.valueOf(id));
            return new DefaultStreamedContent(new ByteArrayInputStream(img.getImagem()));
        }
    }



    public String getData() {
        return img.getData();
    }

    public Collection<Integer> getIds() {
        return ids;
    }

    public void setIds() {
        ids = new ArrayList<Integer>();
        for (Imagem temp : imagens) {
            ids.add(temp.getId());
        }
    }

    public void setIdsParaExcluir() {

        idsParaExcluir = new ArrayList<Integer>();
        for (Imagem temp : imagensParaExcluir) {
            idsParaExcluir.add(temp.getId());
        }
    }

    public Collection<Integer> getIdsParaExcluir() {
        return idsParaExcluir;
    }

    public Integer getId() {
        return img.getId();
    }

    public Collection<Integer> getTodosIds() {
        return dao.buscarIds();
    }

    public Collection<Imagem> getImagens() {
        return imagens;
    }

    public Collection<Imagem> getImagensParaExcluir() {
        return imagensParaExcluir;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
        setAlbum();
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum() {
        this.album = albumDao.buscar(albumId);
    }

    public Integer getAlbumId_excluirFotos() {
        return albumId_excluirFotos;
    }

    public void setAlbumId_excluirFotos(Integer albumId_excluirFotos) {
        this.albumId_excluirFotos = albumId_excluirFotos;
    }

    /* public Collection<Imagem> getImagensPorAlbum() {
        if (albumId == 0) {
            return dao.buscarTodos();
        }
        return dao.buscarPorAlbum(albumId);
    }*/
    public void stateChangeListener() {
        if (albumId != null) {
            if (albumId == 0) {
                imagens = dao.buscarTodos();
            } else {
                imagens = dao.buscarPorAlbum(albumId);
            }
            setIds();
        }

    }

    public void stateChangeListenerExcluir() {
        if (albumId_excluirFotos != null) {
            if (albumId_excluirFotos == 0) {
                imagensParaExcluir = dao.buscarTodos();
            } else {
                imagensParaExcluir = dao.buscarPorAlbum(albumId_excluirFotos);
            }
            setIdsParaExcluir();
        }

    }

    public void excluir() {
        Map<String, String> params = javax.faces.context.FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer id = Integer.valueOf(params.get("imagemId"));
        imgDao.excluirFoto(id);
        stateChangeListenerExcluir();
    }

}
