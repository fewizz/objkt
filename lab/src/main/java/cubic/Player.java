package cubic;

import cubic.network.*;

public class Player extends Entity {
	public final ExtendedChannel channel;
	String name;

	public Player(ExtendedChannel channel, String name) {
		this.name = name;
		this.channel = channel;
	}
	
	@Override
	public String getName() {
		return name;
	}
}
