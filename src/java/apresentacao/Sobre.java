/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

/**
 *
 * @author bernardo
 */
public class Sobre {
    private Integer id;
    private String quemSomos;
    private String historia;
    private String estrutura;
    private String missao;
    private String visao;
    private String valores;

    public Sobre() {
    }

    public Sobre(Integer id, String quemSomos, String historia, 
                String estrutura, String missao, String visao, String valores) {
        this.id = id;
        this.quemSomos = quemSomos;
        this.historia = historia;
        this.estrutura = estrutura;
        this.missao = missao;
        this.visao = visao;
        this.valores = valores;
    }
    


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuemSomos() {
        return quemSomos;
    }

    public void setQuemSomos(String quemSomos) {
        this.quemSomos = quemSomos;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public String getEstrutura() {
        return estrutura;
    }

    public void setEstrutura(String estrutura) {
        this.estrutura = estrutura;
    }

    public String getMissao() {
        return missao;
    }

    public void setMissao(String missao) {
        this.missao = missao;
    }
    
    public String getVisao() {
        return visao;
    }
    
    public void setVisao(String visao) {
        this.visao = visao;
    }
    
    public String getValores() {
        return valores;
    }
    
    public void setValores(String valores) {
        this.valores = valores;
    }
    
}
