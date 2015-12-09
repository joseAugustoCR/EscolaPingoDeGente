/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apresentacao.Album;
import apresentacao.Imagem;
import apresentacao.Noticia;
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

/**
 *
 * @author guto
 */
public class AlbumDAO {

    public Connection abrir() {
        Connection c = null;
        try {
            Class.forName(BD.JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Nao encontrou o driver chamado " + BD.JDBC_DRIVER + " na memoria");
        }
        try {
            c = DriverManager.getConnection(BD.URL_CONEXAO, BD.USUARIO, BD.SENHA);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    public Collection<Album> buscarTodos() {
        Connection conexao = abrir();
        Collection<Album> albuns = new ArrayList<Album>();
        try {
            Statement s = conexao.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM Album");
            Album album = null;

            while (rs.next()) {
                album = new Album(rs.getInt("PK_Album"), rs.getString("titulo"), "");
                albuns.add(album);
            }

            rs.close();
            s.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return albuns;
    }

    public void inserir(Album c) {
        Connection conexao = abrir();
        try {
            PreparedStatement ps = conexao.prepareStatement(
                    "INSERT INTO Album (titulo, descricao) VALUES (?, ?)");
            ps.setString(1, c.getTitulo());
            ps.setString(2, c.getDescricao());

            ps.execute();
            ps.close();
            conexao.close();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Álbum salvo!", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (SQLException e) {
            e.printStackTrace();
            FacesMessage errorMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao salvar álbum", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, errorMsg);
        }
    }

    public void excluir(Integer id) {
        if (id == 0) {
            FacesMessage errorMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao apagar álbum", "Selecione um álbum para excluir");
            FacesContext.getCurrentInstance().addMessage(null, errorMsg);
        } else {
            Connection conexao = abrir();
            try {
                PreparedStatement ps = conexao.prepareStatement(
                        "DELETE FROM Album WHERE PK_Album = ?");
                ps.setInt(1, id);
                ps.execute();
                ps.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
