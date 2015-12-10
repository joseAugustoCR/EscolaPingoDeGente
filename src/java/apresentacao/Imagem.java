/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import org.primefaces.model.UploadedFile;

/**
 *
 * @author guto
 */
public class Imagem {
    private Integer id;
    private byte[] imagem;

    private String data;
    private String album;

    public Imagem(Integer id, byte[] imagem, String data, String album) {
        this.id = id;
        this.imagem = imagem;
 
        String ano = data.substring(0, 4);
        String mes = data.substring(5, 7);
        String dia = data.substring(8, 10);
        
        this.data = dia+"/"+mes+"/"+ano;
        this.album = album;
    }

    public Imagem() {
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }



    public String getData() {
        return data;
    }

    public void setData(String data) {
        String ano = data.substring(0, 4);
        String mes = data.substring(5, 7);
        String dia = data.substring(8, 10);
        
        this.data = dia+"/"+mes+"/"+ano;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }
    
    
    

}
