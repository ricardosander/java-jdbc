package br.com.alura.jdbc.database;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class ConnectionPool {

    private DataSource cpds;

    public ConnectionPool() {

        MysqlDataSource cpds = new MysqlDataSource();

		cpds.setServerName("127.0.0.1");
		cpds.setPort(3306);
		cpds.setDatabaseName("loja_virtual");
		cpds.setUser("root");
		cpds.setPassword("root");

		this.cpds = cpds;
    }

	public Connection getConnection() {
        
		try {
        
			Connection connection = this.cpds.getConnection();
            connection.setAutoCommit(false);
            return connection;
            
        } catch (SQLException e) {
            System.out.println("Houve um erro ao conectar-se ao banco de dados:" + e.getMessage());
            System.exit(0);
        }
		
        return null;
    }
}
