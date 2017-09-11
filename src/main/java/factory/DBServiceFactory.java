package factory;

import service.DBService;
import service.DerbyDBService;

/**
 * Created by Lakhno Anton
 * at 21:54 11.09.17.
 *
 * @author Lakhno Anton
 * @version 1.0
 * @since 1.0
 */
public class DBServiceFactory {

	public static DBService byuildDBService(String dbName) {
		switch (dbName) {
			case "Derby":
				return new DerbyDBService();
			default: return null;
		}
	}

}
