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
public class Inicio {
    private Integer id;
    private String quemSomos;
    private String qualidade;
    private String estrutura;
    private String missao;

    public Inicio() {
    }

    public Inicio(Integer id, String quemSomos, String qualidade, String estrutura, String missao) {
        this.id = id;
        this.quemSomos = quemSomos;
        this.qualidade = qualidade;
        this.estrutura = estrutura;
        this.missao = missao;
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

    public String getQualidade() {
        return qualidade;
    }

    public void setQualidade(String qualidade) {
        this.qualidade = qualidade;
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
   
}
