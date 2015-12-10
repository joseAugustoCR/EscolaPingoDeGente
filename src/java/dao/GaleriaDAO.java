/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apresentacao.Imagem;
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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author guto
 */
public class GaleriaDAO {

    private UploadedFile file;

    public Connection abrir() {
        Connection c = null;
        try {
            Class.forName(BD.JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Nao encontrou o driver chamado " + BD.JDBC_DRIVER + " na memoria");
        }
        try {
            c = DriverManager.getConnection(BD.URL_CONEXAO, BD.USUARIO, BD.SENHA);
            c.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return c;
    }
    
    

    public Collection<Imagem> buscarTodos() {
        Connection conexao = abrir();
        Collection<Imagem> imagens = new ArrayList<Imagem>();
        try {
            Statement s = conexao.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM Imagem ORDER BY data DESC");
            Imagem img = null;

            while (rs.next()) {
                img = new Imagem(rs.getInt("id"), rs.getBytes("imagem"), rs.getString("data"), rs.getString("FK_Album"));
                imagens.add(img);
            }

            rs.close();
            s.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return imagens;
    }
    
    
    
    public Collection<Imagem> buscarPorAlbum(Integer FK_Album) {
        Connection conexao = abrir();
        Collection<Imagem> imagens = new ArrayList<Imagem>();
        try {
            
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM Imagem WHERE FK_Album = ? ORDER BY data DESC");
            ps.setInt(1, FK_Album);
            ResultSet rs = ps.executeQuery();
            
            Imagem img = null;

            while (rs.next()) {
                img = new Imagem(rs.getInt("id"), rs.getBytes("imagem"), rs.getString("data"), rs.getString("FK_Album"));
                imagens.add(img);
            }

            rs.close();
            ps.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return imagens;
    }
    
    
/*
    public byte[] buscar(Integer id) {
        Connection conexao = abrir();
        byte[] imageBytes = null;
        try {
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM Imagem WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                imageBytes = rs.getBytes("imagem");

            }

            rs.close();
            ps.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return imageBytes;
    }*/
    
     public Imagem buscar(Integer id) {
        Connection conexao = abrir();
        Imagem img = null;
        try {
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM Imagem WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                img = new Imagem(id, rs.getBytes("imagem"), rs.getString("data"), rs.getString("FK_Album"));
                

            }

            rs.close();
            ps.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return img;
    }
    

    public Collection<Integer> buscarIds() {
        Connection conexao = abrir();
        Collection<Integer> ids = new ArrayList<Integer>();
        try {
            Statement s = conexao.createStatement();
            ResultSet rs = s.executeQuery("SELECT id FROM Imagem ORDER BY data DESC");

            while (rs.next()) {

                Integer temp = rs.getInt("id");
                ids.add(temp);
            }

            rs.close();
            s.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ids;
    }
    
    /*
    public Collection<String> buscarLegendas() {
        Connection conexao = abrir();
        Collection<String> ids = new ArrayList<String>();
        try {
            Statement s = conexao.createStatement();
            ResultSet rs = s.executeQuery("SELECT legenda FROM Imagem ORDER BY data DESC");

            while (rs.next()) {

                String temp = rs.getString("legenda");
                ids.add(temp);
            }

            rs.close();
            s.close();
            conexao.close();            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ids;
    }*/

    

}
