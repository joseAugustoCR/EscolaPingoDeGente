/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apresentacao.Album;
import apresentacao.Imagem;
import apresentacao.Inicio;
import apresentacao.Noticia;
import static java.awt.font.GlyphMetrics.WHITESPACE;

import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import java.util.regex.Pattern;

/**
 *
 * @author guto
 */
public class DBExemploConexao {

    public static void main(String[] args) {
        GaleriaDAO cs = new GaleriaDAO();
        Collection<Imagem> imagens = new ArrayList<Imagem>();
        Collection<Integer> ids = new ArrayList<Integer>();
        ImagemDAO imgDAO = new ImagemDAO();
        AlbumDAO albumDao = new AlbumDAO();

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
        /*System.out.println("buscando...");
        imagens = cs.buscarTodos();
        for (Imagem temp : imagens) {
            ids.add(temp.getId());
 
           */
        /*
        System.out.println("listando");
        for (Imagem temp : cs.buscarTodos()){
            System.out.println(temp.getId());
        }
        System.out.println("apagando");
        imgDAO.excluirFoto(1);
        System.out.println("listando");
        for (Imagem temp : cs.buscarTodos()){
            System.out.println(temp.getId());
        }*/
        
        
        
        Album a = new Album(10, "teste", "teste");
        albumDao.inserir(a);
        
        
        
        /*
 
 

        }
        System.out.println("listando...");
        for( Integer temp : ids){
            System.out.println(temp);
        }*/

        //System.out.println("buscando 2");
        //Imagem img = cs.buscarTodos();
        //System.out.println("Exibindo");
        // System.out.println("id="+img.getId()+" legenda="+img.getLegenda()+" data="+img.getData());
        /*System.out.println("Alterando o cliente 1...");
		c1.setNome("Fulano de Tal");
		cs.alterar(c1);
                
                /*
         *//*
		System.out.println("Listando todos os clientes novamente...");
		for (Imagem temp : cs.buscarTodos())
			System.out.println(temp.getId() + " - " + temp.getData());
                
         */

    }

    private static final Pattern NONLATIN = Pattern.compile("[^\\w_-]");
    private static final Pattern SEPARATORS = Pattern.compile("[\\s\\p{Punct}&&[^-]]");

    public static String makeSlug(String input) {
        String noseparators = SEPARATORS.matcher(input).replaceAll("-");
        String normalized = Normalizer.normalize(noseparators, Form.NFD);
        String slug = NONLATIN.matcher(normalized).replaceAll("");
        return slug.toLowerCase(Locale.ENGLISH).replaceAll("-{2,}", "-").replaceAll("^-|-$", "");
    }
}
