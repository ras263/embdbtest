package dao;

import entity.TestEntity;
import service.DBService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lakhno Anton
 * at 21:46 11.09.17.
 *
 * @author Lakhno Anton
 * @version 1.0
 * @since 1.0
 */
public class TestDao {

	public static final String INSERT = "INSERT INTO TEST (NAME) VALUES (?)";
	public static final String SELECT_ALL = "SELECT * FROM TEST";

	private DBService dbService;

	public TestDao(DBService dbService) {
		this.dbService = dbService;
	}

	public void insert(TestEntity testEntity) throws SQLException {
		try (Connection connection = getConnection();
			 PreparedStatement pstmt = connection.prepareStatement(INSERT)) {
			connection.setAutoCommit(false);
			pstmt.setString(1, "Hello");
			pstmt.execute();
			connection.commit();
		}
	}

	public List<String> selectAll() throws SQLException {
		ArrayList<String> result = new ArrayList<>();
		ResultSet rs = null;
		try (Connection connection = getConnection();
			 PreparedStatement pstmt = connection.prepareStatement(SELECT_ALL)) {
			rs = pstmt.executeQuery();
			while (rs.next()) {
				result.add(rs.getString(2));
			}
		} finally {
			if (rs != null) rs.close();
		}
		return result;
	}


	private Connection getConnection() throws SQLException {
		return dbService.getConnection();
	}

}
