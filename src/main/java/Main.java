import dao.TestDao;
import entity.TestEntity;
import factory.DBServiceFactory;
import service.DBService;

/**
 * Created by Lakhno Anton
 * at 21:44 11.09.17.
 *
 * @author Lakhno Anton
 * @version 1.0
 * @since 1.0
 */
public class Main {


	public static void main(String[] args) {
		TestEntity testEntity = new TestEntity();
		testEntity.setName("Hello, city!");
		DBService dbService = DBServiceFactory.byuildDBService("Derby");
		try {
			dbService.initDb();
			dbService.initTables();
			TestDao testDao = new TestDao(dbService);
			testDao.insert(testEntity);
			System.out.println(testDao.selectAll());
		} catch (Exception e) {
			if (e instanceof NullPointerException) {
				System.out.println("Incorrect name of DB");
			}
			e.printStackTrace();
		}
	}

}
