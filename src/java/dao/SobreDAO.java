/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apresentacao.Sobre;
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
public class SobreDAO {
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

	public void inserir(Sobre c) {
		Connection conexao = abrir();
		try {
			PreparedStatement ps = conexao.prepareStatement(
					"INSERT INTO Sobre (quemSomos, historia, estrutura, missao, visao, valores) VALUES (?, ?, ?, ?, ?, ?)");
			ps.setString(1, c.getQuemSomos());
			ps.setString(2, c.getHistoria());
			ps.setString(3, c.getEstrutura());
			ps.setString(4, c.getMissao());
                        ps.setString(5, c.getVisao());
                        ps.setString(6, c.getValores());
			ps.execute();
			ps.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void alterar(Sobre c) {
		Connection conexao = abrir();
		try {
			PreparedStatement ps = conexao.prepareStatement(
					"UPDATE Sobre SET quemSomos = ?, historia = ?, estrutura = ?, missao = ?, visao = ?, valores = ? WHERE id = ?");
			ps.setString(1, c.getQuemSomos());
			ps.setString(2, c.getHistoria());
			ps.setString(3, c.getEstrutura());
			ps.setString(4, c.getMissao());
                        ps.setString(5, c.getVisao());
                        ps.setString(6, c.getValores());
                        ps.setInt(7, c.getId());
			ps.execute();
			ps.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Sobre buscar(Integer id) {
		Connection conexao = abrir();
               
		Sobre sobre = new Sobre();
		try {
			PreparedStatement ps = conexao.prepareStatement(
					"SELECT * FROM Sobre WHERE id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
                        
                        if(rs != null && rs.next()){  
                            sobre.setId(rs.getInt("id"));
                            sobre.setQuemSomos(rs.getString("quemSomos"));
                            sobre.setHistoria(rs.getString("historia"));
                            sobre.setEstrutura(rs.getString("estrutura"));
                            sobre.setMissao(rs.getString("missao"));
                            sobre.setVisao(rs.getString("visao"));
                            sobre.setValores(rs.getString("valores"));
                        }
			rs.close();
			ps.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sobre;
	}

	public Collection<Sobre> buscarTodos() {
		Connection conexao = abrir();
		Collection<Sobre> sobre = new ArrayList<Sobre>();
		try {
			Statement s = conexao.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM Sobre");
			while (rs.next()) {
				Sobre temp = new Sobre();
				temp.setId(rs.getInt("id"));
                                temp.setQuemSomos(rs.getString("quemSomos"));
                                temp.setHistoria(rs.getString("historia"));
                                temp.setEstrutura(rs.getString("estrutura"));
                                temp.setMissao(rs.getString("missao"));
                                temp.setVisao(rs.getString("visao"));
                                temp.setValores(rs.getString("valores"));
				sobre.add(temp);
			}
			rs.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sobre;
	}
    
}
