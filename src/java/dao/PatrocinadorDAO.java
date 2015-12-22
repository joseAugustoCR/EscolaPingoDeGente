/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apresentacao.Imagem;
import apresentacao.Patrocinador;
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
public class PatrocinadorDAO {
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

    public void inserir(UploadedFile file) {
        Connection conexao = abrir();

            try {

                PreparedStatement statement = conexao.prepareStatement("INSERT INTO Patrocinadores (imagem) VALUES (?)");
                // Set file data
                statement.setBinaryStream(1, file.getInputstream());
                

                // Insert data to the database
                statement.executeUpdate();

                // Commit & close
                //conexao.commit();    // when autocommit=false
                conexao.close();

                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Patrocinador Salvo!", file.getFileName() + " foi salvo nos patrocinadores.");
                FacesContext.getCurrentInstance().addMessage(null, msg);

            } catch (Exception e) {
                e.printStackTrace();

                // Add error message
                FacesMessage errorMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Upload error", e.getMessage());
                FacesContext.getCurrentInstance().addMessage(null, errorMsg);
            }
        

    }


    public void excluir(Integer id) {

        Connection conexao = abrir();

        try {
            PreparedStatement ps = conexao.prepareStatement("DELETE FROM EscolaPingoDeGenteDB.Patrocinadores WHERE id = ?");

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
    
    public Collection<Patrocinador> buscarTodos() {
        Connection conexao = abrir();
        Collection<Patrocinador> patrocinadores = new ArrayList<Patrocinador>();
        try {
            Statement s = conexao.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM Patrocinadores");
            Patrocinador pt = null;

            while (rs.next()) {
                pt = new Patrocinador(rs.getInt("id"), rs.getBytes("imagem"));
                patrocinadores.add(pt);
            }

            rs.close();
            s.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patrocinadores;
    }
    
    public Patrocinador buscar(Integer id) {
        Connection conexao = abrir();
        Patrocinador p = null;
        try {
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM Patrocinadores WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                p = new Patrocinador(id, rs.getBytes("imagem"));
            }

            rs.close();
            ps.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }
}
