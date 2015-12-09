/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

/**
 *
 * @author guto
 */
public class Album {
    private Integer id;
    private String titulo;
    private String descricao;

    public Album() {
    }
    
    
    public Album(Integer id, String titulo, String descricao) {
        this.id = id;
        this.titulo = titulo;
        this.descricao=descricao;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
