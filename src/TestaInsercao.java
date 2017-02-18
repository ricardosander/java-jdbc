import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.alura.jdbc.database.ConnectionPool;

public class TestaInsercao {

    public static void main(String[] args) throws SQLException {

        String sql = "insert into Produto (nome, descricao) values (?, ?)";

        ConnectionPool database = new ConnectionPool();
        try(Connection connection = database.getConnection()) {

            try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                adiciona("TV LCD", "32 polegadas", statement);
                adiciona("Blueray", "Full HDMI", statement);

                System.out.print("Tudo ok, commitando.");
                connection.commit();

            } catch (Exception e) {
                System.out.print("Houve um erro. Dando rollbnack.");
                connection.rollback();
            }
        }
    }

    private static void adiciona(String nome, String descricao, PreparedStatement statement) throws SQLException {

        if (nome.equals("Blue-ray")) {
            throw new IllegalArgumentException("Problema ocorrido");
        }

        statement.setString(1, nome);
        statement.setString(2, descricao);

        boolean resultado = statement.execute();

        System.out.println("O resultado foi " + resultado);

        ResultSet resultSet = statement.getGeneratedKeys();
        while (resultSet.next()) {

            String id = resultSet.getString(1);
            System.out.println("Chave gerada: " + id);
        }
        resultSet.close();
    }
}
