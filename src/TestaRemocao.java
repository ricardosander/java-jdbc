import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.alura.jdbc.database.ConnectionPool;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {

        ConnectionPool database = new ConnectionPool();
        Connection connection = database.getConnection();
		
		Statement statement = connection.createStatement();
		boolean resultado = statement.execute("delete from Produto where id > 3");
		int count = statement.getUpdateCount();
		
		System.out.println("Resultado foi: " + resultado);
		System.out.println("Linhas afetadas: " + count);
		
		connection.commit();
		statement.close();
		connection.close();
	}
}
