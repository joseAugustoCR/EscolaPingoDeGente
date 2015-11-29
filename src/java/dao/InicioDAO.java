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

/**
 *
 * @author guto
 */
public class InicioDAO {
    
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

	public void inserir(Inicio c) {
		Connection conexao = abrir();
		try {
			PreparedStatement ps = conexao.prepareStatement(
					"INSERT INTO Inicio (quemSomos, qualdidade, estrutura, missao) VALUES (?, ?, ?, ?)");
			ps.setString(1, c.getQuemSomos());
			ps.setString(2, c.getQualidade());
			ps.setString(3, c.getEstrutura());
			ps.setString(4, c.getMissao());
			ps.execute();
			ps.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void alterar(Inicio c) {
		Connection conexao = abrir();
		try {
			PreparedStatement ps = conexao.prepareStatement(
					"UPDATE Inicio SET quemSomos = ?, qualidade = ?, estrutura = ?, missao = ? WHERE id = ?");
			ps.setString(1, c.getQuemSomos());
			ps.setString(2, c.getQualidade());
			ps.setString(3, c.getEstrutura());
			ps.setString(4, c.getMissao());
                        ps.setInt(5, c.getId());
			ps.execute();
			ps.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*public void excluir(Inicio c) {
		Connection conexao = abrir();
		try {
			PreparedStatement ps = conexao.prepareStatement(
					"DELETE FROM clientes WHERE codigo = ?");
			ps.setInt(1, c.getCodigo());
			ps.execute();
			ps.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}*/

	public Inicio buscar(Integer id) {
		Connection conexao = abrir();
               
		Inicio inicio = new Inicio();
		try {
			PreparedStatement ps = conexao.prepareStatement(
					"SELECT * FROM Inicio WHERE id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
                        if(rs != null && rs.next()){  
                            inicio.setId(rs.getInt("id"));
                            inicio.setQuemSomos(rs.getString("quemSomos"));
                            inicio.setQualidade(rs.getString("qualidade"));
                            inicio.setEstrutura(rs.getString("estrutura"));
                            inicio.setMissao(rs.getString("missao"));
                        }
			rs.close();
			ps.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return inicio;
	}

	public Collection<Inicio> buscarTodos() {
		Connection conexao = abrir();
		Collection<Inicio> inicio = new ArrayList<Inicio>();
		try {
			Statement s = conexao.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM Inicio");
			while (rs.next()) {
				Inicio temp = new Inicio();
				temp.setId(rs.getInt("id"));
                                temp.setQuemSomos(rs.getString("quemSomos"));
                                temp.setQualidade(rs.getString("qualidade"));
                                temp.setEstrutura(rs.getString("estrutura"));
                                temp.setMissao(rs.getString("missao"));
				inicio.add(temp);
			}
			rs.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return inicio;
	}
}
