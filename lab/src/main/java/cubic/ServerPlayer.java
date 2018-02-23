package cubic;

import cubic.network.NetworkManager;

public class ServerPlayer extends Player {
	final NetworkManager network;

	public ServerPlayer(NetworkManager network, String name) {
		super(name);
		this.network = network;
	}
}
