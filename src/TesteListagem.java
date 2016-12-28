import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteListagem {

	public static void main(String[] args) throws SQLException {

		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/loja_virtual?useSSL=false", "root",
				"root");

		System.out.println("Conexão aberta");

		Statement statement = connection.createStatement();
		boolean resultado = statement.execute("select * from Produto");
		System.out.println("O resultado foi " + resultado);

		ResultSet resultSet = statement.getResultSet();

		while (resultSet.next()) {

			int id = resultSet.getInt("id");
			String nome = resultSet.getString("nome");
			String descricao = resultSet.getString("descricao");

			System.out.println(id + " - " + nome + ": " + descricao);
		}

		resultSet.close();
		statement.close();
		connection.close();
	}
}
