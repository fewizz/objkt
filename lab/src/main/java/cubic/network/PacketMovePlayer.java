package cubic.network;

import org.objkt.memory.DataInput;
import org.objkt.memory.DataOutput;

public class PacketMovePlayer extends PacketInfo<Void> {
	@Override
	public void read(DataInput in, Connection connection) {
		/*Server.TASKS.add(() -> {
			Server.PLAYERS.get(connection.player.getName())
		});*/
	}

	@Override
	public void write(DataOutput out, Void aVoid, Connection connection) {

	}

	@Override
	public String getName() {
		return "cubic:move_player";
	}
}
