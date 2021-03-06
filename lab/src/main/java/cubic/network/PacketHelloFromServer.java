package cubic.network;

import cubic.Client;
import cubic.Registries;
import cubic.Registry;
import cubic.Registry.RegistryElement;
import org.objkt.memory.DataInput;
import org.objkt.memory.DataOutput;

public class PacketHelloFromServer extends PacketInfo<Void> {

	@Override
	public String getName() {
		return "cubic:hello_from_server";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void read(DataInput in, Connection c) {
		int regs = in.readInt();
		
		Client.LOGGER.info("Reading " + regs + " regs from packet");
		
		for(; regs > 0; regs--) {
			String name = in.readUTF();
			int elements = in.readInt();
			Registry reg = Registries.MAP.get(name);

			Client.LOGGER.info("Reading registry " + name + " with " + elements + " elements");
			
			for(; elements > 0; elements--) {
				int id = in.readInt();
				String elName = in.readUTF();

				if(reg.get(id).getName().equals(elName))
					continue;
					
				RegistryElement elPrev = reg.remove(id);
				RegistryElement toPlace = reg.getByName(elName);
						
				reg.put(reg.idOf(toPlace), elPrev);
				reg.put(id, toPlace);
			}
		}
		
		//Client.connection.sendPacketAsynchronously(Packets.IM_READY, "Player" + Integer.toString(new Random().nextInt(1000)));
	}

	@Override
	public void write(DataOutput out, Void s, Connection c) {
		out.writeInt(Registries.LIST.size());
		
		Registries.LIST.forEach(r -> {
			//out.writeInt(r.name.length());
			//ByteBufUtil.writeUtf8(buf, r.name);
			//buf.writeInt(r.size());
			out.writeUTF(r.name);
			out.writeInt(r.size());
			
			r.forEachElement((id, element) -> {
				out.writeInt(id);
				//out.writeInt(element.getName().length());
				out.writeUTF(element.getName());
				//ByteBufUtil.writeUtf8(buf, element.getName());
			});
		});
	}

}
