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
public class Contato {
    private Integer id;
    private String endereco;
    private String fone1;
    private String fone2;
    private String fone3;

    public Contato() {
    }

    public Contato(Integer id, String endereco, String fone1, String fone2, String fone3) {
        this.id = id;
        this.endereco = endereco;
        this.fone1 = fone1;
        this.fone2 = fone2;
        this.fone3 = fone3;
    }
    


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getFone1() {
        return fone1;
    }

    public void setFone1(String fone1) {
        this.fone1 = fone1;
    }

    public String getFone2() {
        return fone2;
    }

    public void setFone2(String fone2) {
        this.fone2 = fone2;
    }
    
    public String getFone3() {
        return fone3;
    }

    public void setFone3(String fone3) {
        this.fone3 = fone3;
    }
}
