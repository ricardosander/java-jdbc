package br.com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.alura.jdbc.model.Produto;

public class ProdutosDAO {

	private Connection connection;

	public ProdutosDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void salvar(Produto produto) throws SQLException {
		
		String sql = "insert into Produto (nome, descricao) values (?, ?)";
		
		try(PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			
			stm.setString(1, produto.getNome());
			stm.setString(2, produto.getDescricao());
			
			stm.execute();
			ResultSet resultSet = stm.getGeneratedKeys();
			if (resultSet.next()) {
				
				int id = resultSet.getInt(1);
				produto.setId(id);
			}
		}
	}
}
