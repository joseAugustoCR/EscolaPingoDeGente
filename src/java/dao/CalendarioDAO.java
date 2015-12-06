/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apresentacao.Calendario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author bernardo
 */
public class CalendarioDAO {
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

	public void inserir(Calendario c) {
		Connection conexao = abrir();
		try {
			PreparedStatement ps = conexao.prepareStatement(
					"INSERT INTO Calendario (evento, descricao, data) VALUES (?, ?, ?)");
			ps.setString(1, c.getEvento());
			ps.setString(2, c.getDescricao());
                        ps.setDate(3, c.getData());
			ps.execute();
			ps.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void editar(Calendario c) {
		Connection conexao = abrir();
		try {
			PreparedStatement ps = conexao.prepareStatement(
					"UPDATE Calendario SET evento = ?, descricao = ?, data = ? WHERE id = ?");
			ps.setString(1, c.getEvento());
			ps.setString(2, c.getDescricao());
                        ps.setDate(3, c.getData());
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
					"DELETE FROM Calendario WHERE id = ?");
			ps.setInt(1, id);
			ps.execute();
			ps.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Calendario buscar(Integer id) {
		Connection conexao = abrir();
               
		Calendario mes = new Calendario();
		try {
			PreparedStatement ps = conexao.prepareStatement(
					"SELECT * FROM Calendario WHERE id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
                        if(rs != null && rs.next()){  
                            mes.setId(rs.getInt("id"));
                            mes.setEvento(rs.getString("evento"));
                            mes.setDescricao(rs.getString("descricao"));
                            mes.setData(rs.getDate("data"));
                        }
			rs.close();
			ps.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mes;
	}

	public Collection<Calendario> buscarTodos() {
		Connection conexao = abrir();
		Collection<Calendario> eventos = new ArrayList<Calendario>();
		try {
			Statement s = conexao.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM Calendario");
			while (rs.next()) {
				Calendario temp = new Calendario();
				temp.setId(rs.getInt("id"));
                                temp.setEvento(rs.getString("evento"));
                                temp.setDescricao(rs.getString("descricao"));
                                temp.setData(rs.getDate("data"));
				eventos.add(temp);
			}
			rs.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eventos;
	}
}
