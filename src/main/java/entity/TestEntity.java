package entity;

/**
 *
 * Created by Lakhno Anton
 * at 21:45 11.09.17.
 *
 * @author Lakhno Anton
 * @version 1.0
 * @since 1.0
 */
public class TestEntity {

	private Long id;
	private String name;

	//region Properties' accessors
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	//endregion

}
