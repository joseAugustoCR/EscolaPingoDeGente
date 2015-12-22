/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apresentacao.Inicio;
import apresentacao.Noticia;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import org.primefaces.model.UploadedFile;

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



	public void alterar(Inicio c) throws IOException {
		Connection conexao = abrir();
		try {
                  
                    
                    PreparedStatement ps = conexao.prepareStatement(
                    "UPDATE Inicio SET quemSomos=?, qualidade=?, estrutura=?, missao=? WHERE id=?");
			
                        
                        ps.setString(1, c.getQuemSomos());
			ps.setString(2, c.getQualidade());
			ps.setString(3, c.getEstrutura());
			ps.setString(4, c.getMissao());
                        ps.setInt(5, 1);
                      
			ps.execute();
			ps.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
        
   
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
        
        public void alterarLogo(UploadedFile imagem) throws IOException {
        Connection conexao = abrir();
        try {

            PreparedStatement ps = conexao.prepareStatement(
                    "UPDATE Logo SET imagem=? WHERE id=1");

            ps.setBinaryStream(1, imagem.getInputstream());

            ps.execute();
            ps.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
       
    
}
