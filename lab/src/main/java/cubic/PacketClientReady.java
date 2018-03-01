package cubic;

import org.objkt.memory.*;

import cubic.network.*;

public class PacketClientReady extends PacketInfo<String> {
	@Override
	public String getName() {
		return "cubic:client_ready";
	}
	
	@Override
	public void write(DataOutput out, String name) {
		out.writeInt(name.length());
		out.writeUTF(name);
	}
	
	@Override
	public void read(DataInput in) {
		String name = in.readUTF();
		
		Server.TASKS.add(() -> {
			ch.setPlayer(new ServerPlayer(ch, name));
			Server.onPlayerReadyToPlay((ServerPlayer) ch.getPlayer());
		});
	}
}
