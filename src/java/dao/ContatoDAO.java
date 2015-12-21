/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apresentacao.Contato;
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
 * @author bernardo
 */
public class ContatoDAO {
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

	public void inserir(Contato c) {
		Connection conexao = abrir();
                FacesContext facesContext = FacesContext.getCurrentInstance();
		try {
			PreparedStatement ps = conexao.prepareStatement(
					"INSERT INTO Contato (endereco, enderecoII,  fone1, fone2, fone3) VALUES (?, ? , ? , ? , ?)");
			ps.setString(1, c.getEndereco());
                        ps.setString(1, c.getEnderecoII());
			ps.setString(2, c.getFone1());
			ps.setString(3, c.getFone2());
			ps.setString(4, c.getFone3());
			ps.execute();
			ps.close();
			conexao.close();
                        
		} catch (SQLException e) {
			e.printStackTrace();
                        //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao salvar informações.", e.getMessage()));
		}
	}

	public void alterar(Contato c) {
		Connection conexao = abrir();
		try {
			PreparedStatement ps = conexao.prepareStatement(
					"UPDATE Contato SET endereco = ?, enderecoII = ?, fone1 = ?, fone2 = ?, fone3 = ? WHERE id = ?");
			ps.setString(1, c.getEndereco());
                        ps.setString(1, c.getEnderecoII());
			ps.setString(2, c.getFone1());
			ps.setString(3, c.getFone2());
			ps.setString(4, c.getFone3());
                        ps.setInt(5, c.getId());
			ps.execute();
			ps.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Contato buscar(Integer id) {
		Connection conexao = abrir();
               
		Contato contato = new Contato();
		try {
			PreparedStatement ps = conexao.prepareStatement(
					"SELECT * FROM Contato WHERE id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
                        
                        if(rs != null && rs.next()){  
                            contato.setId(rs.getInt("id"));
                            contato.setEndereco(rs.getString("endereco"));
                            contato.setEnderecoII(rs.getString("enderecoII"));
                            contato.setFone1(rs.getString("fone1"));
                            contato.setFone2(rs.getString("fone2"));
                            contato.setFone3(rs.getString("fone3"));
                        }
			rs.close();
			ps.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contato;
	}

	public Collection<Contato> buscarTodos() {
		Connection conexao = abrir();
		Collection<Contato> contato = new ArrayList<Contato>();
		try {
			Statement s = conexao.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM Contato");
			while (rs.next()) {
				Contato temp = new Contato();
				temp.setId(rs.getInt("id"));
                                temp.setEndereco(rs.getString("endereco"));
                                temp.setEnderecoII(rs.getString("enderecoII"));
                                temp.setFone1(rs.getString("fone1"));
                                temp.setFone2(rs.getString("fone2"));
                                temp.setFone3(rs.getString("fone3"));
				contato.add(temp);
			}
			rs.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contato;
	}
}
