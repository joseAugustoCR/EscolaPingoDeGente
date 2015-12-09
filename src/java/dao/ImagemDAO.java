/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apresentacao.Inicio;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author guto
 */
public class ImagemDAO {

    //private UploadedFile file;

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

    public void inserir(Integer album, UploadedFile file) {
        Connection conexao = abrir();

       
     
            try {

                PreparedStatement statement = conexao.prepareStatement("INSERT INTO Imagem (imagem, legenda, data, FK_Album) VALUES (?, null, null, ?)");
                // Set file data
                statement.setBinaryStream(1, file.getInputstream());
                statement.setInt(2, album);

                // Insert data to the database
                statement.executeUpdate();

                // Commit & close
                //conexao.commit();    // when autocommit=false
                conexao.close();

                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Imagem Salva!", file.getFileName() + " foi salva na galeria.");
                FacesContext.getCurrentInstance().addMessage(null, msg);

            } catch (Exception e) {
                e.printStackTrace();

                // Add error message
                FacesMessage errorMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Upload error", e.getMessage());
                FacesContext.getCurrentInstance().addMessage(null, errorMsg);
            }
        

    }
/*
    // Getter method
    public UploadedFile getFile() {
        return file;
    }

    // Setter method
    public void setFile(UploadedFile file) {
        this.file = file;
    }*/

    public void excluirFoto(Integer id) {

        Connection conexao = abrir();

        try {
            PreparedStatement ps = conexao.prepareStatement("DELETE FROM EscolaPingoDeGenteDB.Imagem WHERE id = ?");

            ps.setInt(1, id);

            ps.executeUpdate();

            ps.close();
            conexao.close();

            //System.out.println("opa");
        } catch (SQLException e) {
            //System.out.println("opa2");
            e.printStackTrace();
            // Add error message
            FacesMessage errorMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Excluir erro", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, errorMsg);
        }
    }
}
