package cubic;

import cubic.network.*;

public class Player extends Entity {
	public final Connection connection;
	String name;

	public Player(Connection connection, String name) {
		this.name = name;
		this.connection = connection;
	}
	
	@Override
	public String getName() {
		return name;
	}
}
