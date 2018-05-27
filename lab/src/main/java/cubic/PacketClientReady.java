package cubic;

import org.objkt.memory.*;

import cubic.network.*;

public class PacketClientReady extends PacketInfo<String> {
	@Override
	public String getName() {
		return "cubic:client_ready";
	}
	
	@Override
	public void write(DataOutput out, String name, Connection c) {
		//out.writeInt(name.length());
		out.writeUTF(name);
	}
	
	@Override
	public void read(DataInput in, Connection c) {
		String name = in.readUTF();
		
		Server.TASKS.add(() -> {
			c.setPlayer(new ServerPlayer(c, name));
			Server.onPlayerReadyToPlay((ServerPlayer) c.getPlayer());
		});
	}
}
