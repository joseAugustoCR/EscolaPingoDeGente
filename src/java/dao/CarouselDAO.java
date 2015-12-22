/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apresentacao.Carousel;
import apresentacao.Inicio;
import apresentacao.Noticia;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author guto
 */
public class CarouselDAO {
    
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
    
    public void inserir(Carousel c, UploadedFile imagem1, UploadedFile imagem2, UploadedFile imagem3) throws IOException {
        Connection conexao = abrir();
        try {
            PreparedStatement statement = conexao.prepareStatement("INSERT INTO Carousel (titulo1, legenda1, imagem1,titulo2, legenda2, imagem2,titulo3, legenda3, imagem3) "
                    + "VALUES (?, ?, ?, ?, ?,?,?,?,?)");
            // Set file data
            statement.setString(1, c.getTitulo1());
            statement.setString(2, c.getLegenda1());
            statement.setBinaryStream(3, imagem1.getInputstream());
            statement.setString(4, c.getTitulo2());
            statement.setString(5, c.getLegenda2());
            statement.setBinaryStream(6, imagem2.getInputstream());
            statement.setString(7, c.getTitulo3());
            statement.setString(8, c.getLegenda3());
            statement.setBinaryStream(9, imagem3.getInputstream());
            

            // Insert data to the database
            statement.executeUpdate();

            // Commit & close
            //conexao.commit();    // when autocommit=false
            conexao.close();

          
        } catch (SQLException e) {
            e.printStackTrace();
           
        }
    }
    
     
     public void editar(Carousel c, UploadedFile imagem1,UploadedFile imagem2, UploadedFile imagem3) throws IOException {
        Connection conexao = abrir();
        try {
            PreparedStatement ps = conexao.prepareStatement(
                    "UPDATE Carousel SET titulo1 = ?, legenda1 = ?, imagem1 = ?,titulo2 = ?, legenda2 = ?, imagem2 = ?,"
                            + "titulo3 = ?, legenda3 = ?, imagem3 = ? WHERE id = 1");
            ps.setString(1, c.getTitulo1());
            ps.setString(2, c.getLegenda1());
            ps.setBinaryStream(3, imagem1.getInputstream());
            ps.setString(4, c.getTitulo2());
            ps.setString(5, c.getLegenda2());
            ps.setBinaryStream(6, imagem2.getInputstream());
            ps.setString(7, c.getTitulo3());
            ps.setString(8, c.getLegenda3());
            ps.setBinaryStream(9, imagem3.getInputstream());

            ps.execute();
            ps.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     
     public Carousel buscar() {
		Connection conexao = abrir();
               
		Carousel carousel = new Carousel();
		try {
			PreparedStatement ps = conexao.prepareStatement(
					"SELECT * FROM Carousel WHERE id = ?");
			ps.setInt(1, 1);
			ResultSet rs = ps.executeQuery();
                        
                        if(rs != null && rs.next()){  
                            
                            carousel.setTitulo1(rs.getString("titulo1"));
                            carousel.setTitulo2(rs.getString("titulo2"));
                            carousel.setTitulo3(rs.getString("titulo3"));
                            carousel.setLegenda1(rs.getString("legenda1"));
                            carousel.setLegenda2(rs.getString("legenda2"));
                            carousel.setLegenda3(rs.getString("legenda3"));
                            carousel.setImagem1(rs.getBytes("imagem1"));
                            carousel.setImagem2(rs.getBytes("imagem2"));
                            carousel.setImagem3(rs.getBytes("imagem3"));
                            
                        }
			rs.close();
			ps.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return carousel;
	}
    
}
