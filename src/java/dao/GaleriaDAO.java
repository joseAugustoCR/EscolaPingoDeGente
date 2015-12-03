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
       
       
    public void inserir() {
        Connection conexao = abrir();
        // Create connection
        try {
            
            PreparedStatement statement = conexao.prepareStatement("INSERT INTO Galeria (imagem) VALUES (?)");
            // Set file data
            statement.setBinaryStream(1, file.getInputstream());
             
            // Insert data to the database
            statement.executeUpdate();
             
            // Commit & close
            conexao.commit();    // when autocommit=false
            conexao.close();
             
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Upload success", file.getFileName() + " is uploaded."); 
            FacesContext.getCurrentInstance().addMessage(null, msg);
             
        } catch (Exception e) {
            e.printStackTrace();
             
            // Add error message
            FacesMessage errorMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Upload error", e.getMessage()); 
            FacesContext.getCurrentInstance().addMessage(null, errorMsg);
        }
         
    }
 
    // Getter method
    public UploadedFile getFile() {
        return file;
    }
 
    // Setter method
    public void setFile(UploadedFile file) {
        this.file = file;
    }  
    
    public Collection<byte[]> buscarTodos() {
		Connection conexao = abrir();
		Collection<byte[]> imagens = new ArrayList<byte[]>();
		try {
			Statement s = conexao.createStatement();
			ResultSet rs = s.executeQuery("SELECT id, imagem FROM Galeria");
                        byte[] imageBytes = null;
                        
			while (rs.next()) {
				imageBytes = rs.getBytes("imagem");
				imagens.add(imageBytes);
			}
                        
                        
			rs.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return imagens;
	}
    
      public byte[] buscar(Integer id) {
		Connection conexao = abrir();
                byte[] imageBytes = null;
		try {
			PreparedStatement ps = conexao.prepareStatement("SELECT * FROM Galeria WHERE id = ?");
                       ps.setInt(1, id);
                       ResultSet rs = ps.executeQuery();
                       
                        
                        
			while (rs.next()) {
				imageBytes = rs.getBytes("imagem");
				
			}
                                             
                        
			rs.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return imageBytes;
	}
      
          public Collection<Integer> buscarIds() {
		Connection conexao = abrir();
		Collection<Integer> ids = new ArrayList<Integer>();
		try {
			Statement s = conexao.createStatement();
			ResultSet rs = s.executeQuery("SELECT id FROM Galeria");
                     
                       	while (rs.next()) {
				
				Integer temp = rs.getInt("id");
				ids.add(temp);
			}
                        
                        
			rs.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ids;
	}
      
     
}