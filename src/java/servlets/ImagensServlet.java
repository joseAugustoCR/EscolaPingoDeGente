/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dao.BD;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author guto
 */
@WebServlet(name = "ImagensServlet", urlPatterns = {"/ImagensServlet"})
public class ImagensServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Get last uploaded image
        try {
            // Image bytes
            byte[] imageBytes = null;
           

             
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
             
            // Create the statement
            // This query is specific to MySQL, it returns only one row (using 'LIMIT 1') - the last uploaded file
            PreparedStatement statement = c.prepareStatement("SELECT id, imagem FROM Galeria");
             
            ResultSet rs = statement.executeQuery();
             
            while (rs.next()) { // This will run only once
                imageBytes = rs.getBytes("imagem");
            }
 
            // Close the connection
            c.close();
             
            resp.getOutputStream().write(imageBytes);
            resp.getOutputStream().close();
             
        } catch (Exception e) {
            // Display error message
            resp.getWriter().write(e.getMessage());
            resp.getWriter().close();
        }
         
    }  

}
