package br.com.alura.jdbc.teste;

import java.sql.SQLException;

import br.com.alura.jdbc.dao.ProdutosDAO;
import br.com.alura.jdbc.database.ConnectionPool;
import br.com.alura.jdbc.model.Produto;

public class TestaProdutosDao {

	public static void main(String[] args) throws SQLException {
		
		ConnectionPool pool = new ConnectionPool();
		
		ProdutosDAO produtosDAO = new ProdutosDAO(pool.getConnection());
		
		Produto produto = new Produto("Mesa Vermelha", "Mesa Vermelha com 4 pés");
		produtosDAO.salvar(produto);
		System.out.println("Produto inserido: " + produto.toString());
	}
}
