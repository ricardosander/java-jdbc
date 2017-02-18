import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.alura.jdbc.database.ConnectionPool;

public class TesteListagem {

    public static void main(String[] args) throws SQLException {

        ConnectionPool database = new ConnectionPool();

        Connection connection = database.getConnection();

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
