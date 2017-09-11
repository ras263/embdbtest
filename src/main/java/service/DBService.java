package service;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Lakhno Anton
 * at 21:49 11.09.17.
 *
 * @author Lakhno Anton
 * @version 1.0
 * @since 1.0
 */
public interface DBService {

	void initDb() throws SQLException;
	Connection getConnection() throws SQLException;
	void close() throws SQLException;
	void initTables() throws SQLException;

}
