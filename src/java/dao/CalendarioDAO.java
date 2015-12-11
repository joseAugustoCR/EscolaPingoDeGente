/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apresentacao.Calendario;
import java.sql.Connection;
import java.util.Date;
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
					"INSERT INTO Calendario (titulo, descricao, date) VALUES (?, ?, ?)");
			ps.setString(1, c.getEvento());
			ps.setString(2, c.getDescricao());
                        ps.setDate(3, new java.sql.Date(c.getDate1().getTime()));
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
					"UPDATE Calendario SET titulo = ?, descricao = ?, date = ? WHERE id = ?");
			ps.setString(1, c.getEvento());
			ps.setString(2, c.getDescricao());
                        ps.setDate(3,  new java.sql.Date(c.getDate1().getTime()));
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

	public Collection<Calendario> buscar() {
		Connection conexao = abrir();
		Collection<Calendario> eventos = new ArrayList<Calendario>();
		try {
			Statement s = conexao.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM Calendario");
                        int month = 0;
			while (rs.next()) {
				Calendario temp = new Calendario();
				temp.setId(rs.getInt("id"));
                                temp.setEvento(rs.getString("titulo"));
                                temp.setDescricao(rs.getString("descricao"));
                                temp.setDate1(rs.getDate("date"));
                                eventos.add(temp);
			}
			rs.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eventos;
	}
        
        public Calendario buscarEvento(Integer id) {
        Connection conexao = abrir();

        Calendario calendario = new Calendario();
        try {
            PreparedStatement ps = conexao.prepareStatement(
                    "SELECT * FROM Calendario WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs != null && rs.next()) {
                calendario.setId(rs.getInt("id"));
                calendario.setEvento(rs.getString("titulo"));
                calendario.setDescricao(rs.getString("descricao"));
                calendario.setDate1(rs.getDate("date"));
            }
            rs.close();
            ps.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return calendario;
    }

        public Collection<Calendario> buscarJaneiro() {
		Connection conexao = abrir();
		Collection<Calendario> eventos = new ArrayList<Calendario>();
		try {
			Statement s = conexao.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM Calendario");
                        int month = 0;
			while (rs.next()) {
				Calendario temp = new Calendario();
				temp.setId(rs.getInt("id"));
                                temp.setEvento(rs.getString("titulo"));
                                temp.setDescricao(rs.getString("descricao"));
                                temp.setDate1(rs.getDate("date"));
                                month = rs.getDate("date").getMonth();
				if (month == 0){
                                    eventos.add(temp);
                                }
			}
			rs.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eventos;
	}
        
        public Collection<Calendario> buscarFevereiro() {
		Connection conexao = abrir();
		Collection<Calendario> eventos = new ArrayList<Calendario>();
		try {
			Statement s = conexao.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM Calendario");
                        int month = 0;
			while (rs.next()) {
				Calendario temp = new Calendario();
				temp.setId(rs.getInt("id"));
                                temp.setEvento(rs.getString("titulo"));
                                temp.setDescricao(rs.getString("descricao"));
                                temp.setDate1(rs.getDate("date"));
                                month = rs.getDate("date").getMonth();
				if (month == 1){
                                    eventos.add(temp);
                                }
			}
			rs.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eventos;
	}
        
        public Collection<Calendario> buscarMarco() {
		Connection conexao = abrir();
		Collection<Calendario> eventos = new ArrayList<Calendario>();
		try {
			Statement s = conexao.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM Calendario");
                        int month = 0;
			while (rs.next()) {
				Calendario temp = new Calendario();
				temp.setId(rs.getInt("id"));
                                temp.setEvento(rs.getString("titulo"));
                                temp.setDescricao(rs.getString("descricao"));
                                temp.setDate1(rs.getDate("date"));
                                month = rs.getDate("date").getMonth();
				if (month == 2){
                                    eventos.add(temp);
                                }
			}
			rs.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eventos;
	}
        
        public Collection<Calendario> buscarAbril() {
		Connection conexao = abrir();
		Collection<Calendario> eventos = new ArrayList<Calendario>();
		try {
			Statement s = conexao.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM Calendario");
                        int month = 0;
			while (rs.next()) {
				Calendario temp = new Calendario();
				temp.setId(rs.getInt("id"));
                                temp.setEvento(rs.getString("titulo"));
                                temp.setDescricao(rs.getString("descricao"));
                                temp.setDate1(rs.getDate("date"));
                                month = rs.getDate("date").getMonth();
				if (month == 3){
                                    eventos.add(temp);
                                }
			}
			rs.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eventos;
	}
        
        public Collection<Calendario> buscarMaio() {
		Connection conexao = abrir();
		Collection<Calendario> eventos = new ArrayList<Calendario>();
		try {
			Statement s = conexao.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM Calendario");
                        int month = 0;
			while (rs.next()) {
				Calendario temp = new Calendario();
				temp.setId(rs.getInt("id"));
                                temp.setEvento(rs.getString("titulo"));
                                temp.setDescricao(rs.getString("descricao"));
                                temp.setDate1(rs.getDate("date"));
                                month = rs.getDate("date").getMonth();
				if (month == 4){
                                    eventos.add(temp);
                                }
			}
			rs.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eventos;
	}
        
        public Collection<Calendario> buscarJunho() {
		Connection conexao = abrir();
		Collection<Calendario> eventos = new ArrayList<Calendario>();
		try {
			Statement s = conexao.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM Calendario");
                        int month = 0;
			while (rs.next()) {
				Calendario temp = new Calendario();
				temp.setId(rs.getInt("id"));
                                temp.setEvento(rs.getString("titulo"));
                                temp.setDescricao(rs.getString("descricao"));
                                temp.setDate1(rs.getDate("date"));
                                month = rs.getDate("date").getMonth();
				if (month == 5){
                                    eventos.add(temp);
                                }
			}
			rs.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eventos;
	}
        
        public Collection<Calendario> buscarJulho() {
		Connection conexao = abrir();
		Collection<Calendario> eventos = new ArrayList<Calendario>();
		try {
			Statement s = conexao.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM Calendario");
                        int month = 0;
			while (rs.next()) {
				Calendario temp = new Calendario();
				temp.setId(rs.getInt("id"));
                                temp.setEvento(rs.getString("titulo"));
                                temp.setDescricao(rs.getString("descricao"));
                                temp.setDate1(rs.getDate("date"));
                                month = rs.getDate("date").getMonth();
				if (month == 6){
                                    eventos.add(temp);
                                }
			}
			rs.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eventos;
	}
        
        public Collection<Calendario> buscarAgosto() {
		Connection conexao = abrir();
		Collection<Calendario> eventos = new ArrayList<Calendario>();
		try {
			Statement s = conexao.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM Calendario");
                        int month = 0;
			while (rs.next()) {
				Calendario temp = new Calendario();
				temp.setId(rs.getInt("id"));
                                temp.setEvento(rs.getString("titulo"));
                                temp.setDescricao(rs.getString("descricao"));
                                temp.setDate1(rs.getDate("date"));
                                month = rs.getDate("date").getMonth();
				if (month == 7){
                                    eventos.add(temp);
                                }
			}
			rs.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eventos;
	}
        
        public Collection<Calendario> buscarSetembro() {
		Connection conexao = abrir();
		Collection<Calendario> eventos = new ArrayList<Calendario>();
		try {
			Statement s = conexao.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM Calendario");
                        int month = 0;
			while (rs.next()) {
				Calendario temp = new Calendario();
				temp.setId(rs.getInt("id"));
                                temp.setEvento(rs.getString("titulo"));
                                temp.setDescricao(rs.getString("descricao"));
                                temp.setDate1(rs.getDate("date"));
                                month = rs.getDate("date").getMonth();
				if (month == 8){
                                    eventos.add(temp);
                                }
			}
			rs.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eventos;
	}
        
        public Collection<Calendario> buscarOutubro() {
		Connection conexao = abrir();
		Collection<Calendario> eventos = new ArrayList<Calendario>();
		try {
			Statement s = conexao.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM Calendario");
                        int month = 0;
			while (rs.next()) {
				Calendario temp = new Calendario();
				temp.setId(rs.getInt("id"));
                                temp.setEvento(rs.getString("titulo"));
                                temp.setDescricao(rs.getString("descricao"));
                                temp.setDate1(rs.getDate("date"));
                                month = rs.getDate("date").getMonth();
				if (month == 9){
                                    eventos.add(temp);
                                }
			}
			rs.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eventos;
	}
        
        public Collection<Calendario> buscarNovembro() {
		Connection conexao = abrir();
		Collection<Calendario> eventos = new ArrayList<Calendario>();
		try {
			Statement s = conexao.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM Calendario");
                        int month = 0;
			while (rs.next()) {
				Calendario temp = new Calendario();
				temp.setId(rs.getInt("id"));
                                temp.setEvento(rs.getString("titulo"));
                                temp.setDescricao(rs.getString("descricao"));
                                temp.setDate1(rs.getDate("date"));
                                month = rs.getDate("date").getMonth();
				if (month == 10){
                                    eventos.add(temp);
                                }
			}
			rs.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eventos;
	}
        
	public Collection<Calendario> buscarDezembro() {
		Connection conexao = abrir();
		Collection<Calendario> eventos = new ArrayList<Calendario>();
		try {
			Statement s = conexao.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM Calendario");
                        int month = 0;
			while (rs.next()) {
				Calendario temp = new Calendario();
				temp.setId(rs.getInt("id"));
                                temp.setEvento(rs.getString("titulo"));
                                temp.setDescricao(rs.getString("descricao"));
                                temp.setDate1(rs.getDate("date"));
                                month = rs.getDate("date").getMonth();
				if (month == 11){
                                    eventos.add(temp);
                                }
			}
			rs.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eventos;
	}
}
