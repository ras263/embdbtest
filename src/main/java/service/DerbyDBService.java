package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * Created by Lakhno Anton
 * at 21:47 11.09.17.
 *
 * @author Lakhno Anton
 * @version 1.0
 * @since 1.0
 */
public class DerbyDBService implements DBService {

	public static final String INIT_TABLE =
			"CREATE TABLE TEST (ID INT NOT NULL GENERATED ALWAYS AS IDENTITY, NAME VARCHAR(100), PRIMARY KEY (ID))";

	public static final String DROP_TABLE = "DROP TABLE TEST";

	private Connection connection;

	@Override
	public void initDb() throws SQLException {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (ClassNotFoundException e) {
			throw new SQLException("Can't find DB connector library in the classpath", e);
		}
	}

	@Override
	public Connection getConnection() throws SQLException {
		if (connection != null && !connection.isClosed()) {
			return connection;
		}
		this.connection = DriverManager.getConnection(
				"jdbc:derby:/Users/antonlakhno/LocalDocuments/Development/embdbtest/derby;create=true"
		);
		return this.connection;
	}

	@Override
	public void close() throws SQLException {
		if (connection != null) {
			this.connection.close();
		}
	}

	@Override
	public void initTables() throws SQLException {
		try(Connection connection = getConnection();
			PreparedStatement dropStmt = connection.prepareStatement(DROP_TABLE);
			PreparedStatement stmt = connection.prepareStatement(INIT_TABLE)) {
			connection.setAutoCommit(false);
			dropStmt.execute();
			connection.commit();
			stmt.execute();
			connection.commit();
		}
	}

}
