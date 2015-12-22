/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apresentacao.Logo;
import apresentacao.Noticia;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author guto
 */
public class LogoDAO {

    public Connection abrir() {
        Connection c = null;
        try {
            Class.forName(BD.JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Nao encontrou o driver chamado " + BD.JDBC_DRIVER + " na memoria");
        }
        try {
            c = DriverManager.getConnection(BD.URL_CONEXAO, BD.USUARIO, BD.SENHA);
            // c.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    public void alterar(UploadedFile imagem) throws IOException {
        Connection conexao = abrir();
        try {

            PreparedStatement ps = conexao.prepareStatement(
                    "UPDATE Logo SET imagem=? WHERE id=1");

            ps.setBinaryStream(1, imagem.getInputstream());

            ps.execute();
            ps.close();
            conexao.close();

            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo!", " Novo logo salvo!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (SQLException e) {
            e.printStackTrace();
            FacesMessage errorMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Upload error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, errorMsg);
        }
    }
    
    public Logo buscar() {
        Connection conexao = abrir();

        Logo logo = new Logo();
        try {
            PreparedStatement ps = conexao.prepareStatement(
                    "SELECT * FROM Logo WHERE id = 1");
           
            ResultSet rs = ps.executeQuery();
            if (rs != null && rs.next()) {
                logo.setImagem(rs.getBytes("imagem"));           
            }
            rs.close();
            ps.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return logo;
    }
    
    
}
