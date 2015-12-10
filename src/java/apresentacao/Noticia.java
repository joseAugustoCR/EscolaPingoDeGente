/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import java.sql.Date;
import java.text.SimpleDateFormat;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author guto
 */
public class Noticia {

     private Integer id;
    private String titulo;
    private String texto;
    private String timestamp;
    private byte[] imagem;
    
     public Noticia() {
    }
    
    public Noticia(Integer id, String titulo, byte[] imagem, String texto, String timestamp) {
        this.id = id;
        this.titulo = titulo;
        this.texto = texto;
        this.timestamp = timestamp;
        this.imagem = imagem;
    }

   

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        String ano = timestamp.substring(0, 4);
        String mes = timestamp.substring(5, 7);
        String dia = timestamp.substring(8, 10);
        
        this.timestamp = dia+"/"+mes+"/"+ano;
    }
    
     public byte[] getImagem() {
        
        return imagem;
    }
 
    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    


}
