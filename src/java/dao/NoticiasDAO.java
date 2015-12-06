/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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
public class NoticiasDAO {
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

	public void inserir(Noticia c) {
		Connection conexao = abrir();
		try {
			PreparedStatement ps = conexao.prepareStatement(
					"INSERT INTO Noticias (titulo, texto, imagem, timestamp) VALUES (?, ?, ?, null)");
			ps.setString(1, c.getTitulo());
			ps.setString(2, c.getTexto());
			ps.setString(3, null);  //colocar imagem
			ps.execute();
			ps.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void editar(Noticia c) {
		Connection conexao = abrir();
		try {
			PreparedStatement ps = conexao.prepareStatement(
					"UPDATE Noticias SET titulo = ?, texto = ?, imagem = ?, timestamp = null WHERE id = ?");
			ps.setString(1, c.getTitulo());
			ps.setString(2, c.getTexto());
			ps.setString(3, null); //colocar
                        ps.setInt(4, c.getId());
			ps.execute();
			ps.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void excluir(Integer id) {
		Connection conexao = abrir();
		try {
			PreparedStatement ps = conexao.prepareStatement(
					"DELETE FROM Noticias WHERE id = ?");
			ps.setInt(1, id);
			ps.execute();
			ps.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Noticia buscar(Integer id) {
		Connection conexao = abrir();
               
		Noticia noticia = new Noticia();
		try {
			PreparedStatement ps = conexao.prepareStatement(
					"SELECT * FROM Noticias WHERE id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
                        if(rs != null && rs.next()){  
                            noticia.setId(rs.getInt("id"));
                            noticia.setTitulo(rs.getString("titulo"));
                            noticia.setTexto(rs.getString("texto"));
                            //noticia.(rs.getString("estrutura"));
                            noticia.setTimestamp(rs.getString("timestamp"));
                        }
			rs.close();
			ps.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return noticia;
	}

	public Collection<Noticia> buscarTodos() {
		Connection conexao = abrir();
		Collection<Noticia> noticias = new ArrayList<Noticia>();
		try {
			Statement s = conexao.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM Noticias ORDER BY timestamp DESC");
			while (rs.next()) {
				Noticia temp = new Noticia();
				temp.setId(rs.getInt("id"));
                                temp.setTitulo(rs.getString("titulo"));
                                temp.setTexto(rs.getString("texto"));
                               // temp.setImagem(rs.getString("estrutura"));
                                temp.setTimestamp(rs.getString("timestamp"));
				noticias.add(temp);
			}
			rs.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return noticias;
	}
        
        public Collection<Noticia> buscarUltimas() {
		Connection conexao = abrir();
		Collection<Noticia> noticias = new ArrayList<Noticia>();
		try {
			Statement s = conexao.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM Noticias ORDER BY timestamp DESC LIMIT 5");
			while (rs.next()) {
				Noticia temp = new Noticia();
				temp.setId(rs.getInt("id"));
                                temp.setTitulo(rs.getString("titulo"));
                                temp.setTexto(rs.getString("texto"));
                               // temp.setImagem(rs.getString("estrutura"));
                                temp.setTimestamp(rs.getString("timestamp"));
				noticias.add(temp);
			}
			rs.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return noticias;
	}
        
        
}
