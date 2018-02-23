package cubic;

public class Player extends Entity {
	String name;

	public Player(String name) {
		this.name = name;
	}
	
	@Override
	public String getName() {
		return name;
	}
}
