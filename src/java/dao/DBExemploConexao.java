/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apresentacao.Inicio;
import static java.awt.font.GlyphMetrics.WHITESPACE;

import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.Locale;
import java.util.regex.Pattern;

/**
 *
 * @author guto
 */
public class DBExemploConexao {
    	public static void main(String[] args){
		InicioDAO cs = new InicioDAO();
		
		System.out.println("Listando todos os clientes...");
                
		/*Inicio temp = cs.buscar(1);
			System.out.println(temp.getId() + " - " + temp.getQuemSomos()+ " - " + temp.getQualidade()+ " - " + temp.getEstrutura()+ " - " + temp.getMissao());*/

		/*System.out.println("Apagando todos os clientes...");
		for (Cliente temp : cs.buscarTodos())
			cs.excluir(temp);
		
		System.out.println("Listando todos os clientes novamente...");
		for (Cliente temp : cs.buscarTodos())
			System.out.println(temp.getCodigo() + " - " + temp.getNome());

		System.out.println("Inserindo clientes ...");
		Cliente c1 = new Cliente(1, "Fulano");
		Cliente c2 = new Cliente(2, "Beltrano");
		Cliente c3 = new Cliente(3, "Ciclano");
		cs.inserir(c1);
		cs.inserir(c2);
		cs.inserir(c3);*/
				
		System.out.println("Listando todos os clientes novamente...");
		for (Inicio temp : cs.buscarTodos())
			System.out.println(temp.getId() + " - " + temp.getQuemSomos());
                
                System.out.println(makeSlug("Minha Primeira Notícia"));

		/*System.out.println("Alterando o cliente 1...");
		c1.setNome("Fulano de Tal");
		cs.alterar(c1);
                
                

		System.out.println("Listando todos os clientes novamente...");
		for (Cliente temp : cs.buscarTodos())
			System.out.println(temp.getCodigo() + " - " + temp.getNome());*/
                
 

	}
        
  private static final Pattern NONLATIN = Pattern.compile("[^\\w_-]");  
  private static final Pattern SEPARATORS = Pattern.compile("[\\s\\p{Punct}&&[^-]]");  

  public static String makeSlug(String input) {  
    String noseparators = SEPARATORS.matcher(input).replaceAll("-");
    String normalized = Normalizer.normalize(noseparators, Form.NFD);
    String slug = NONLATIN.matcher(normalized).replaceAll("");
    return slug.toLowerCase(Locale.ENGLISH).replaceAll("-{2,}","-").replaceAll("^-|-$","");
  }
}
