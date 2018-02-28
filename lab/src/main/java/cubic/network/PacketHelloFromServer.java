package cubic.network;

import java.util.Random;

import cubic.*;
import cubic.Registry.RegistryElement;
import io.netty.buffer.*;
import io.netty.util.CharsetUtil;

public class PacketHelloFromServer extends PacketInfo<String> {

	@Override
	public String getName() {
		return "cubic:hello_from_server";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void read(ExtendedChannel ch, ByteBuf buff) {
		int regs = buff.readInt();
		
		Client.LOGGER.info("Reading " + regs + " regs from packet");
		
		for(; regs > 0; regs--) {
			String name = buff.readCharSequence(buff.readInt(), CharsetUtil.UTF_8).toString();
			int elements = buff.readInt();
			
			Client.LOGGER.info("Reading registry " + name + " with " + elements + " elements");
			
			for(; elements > 0; elements--) {
				int id = buff.readInt();
				String elName = buff.readCharSequence(buff.readInt(), CharsetUtil.UTF_8).toString();
				
				Registry reg = Registries.MAP.get(name);
				if(reg.get(id).getName().equals(elName))
					continue;
					
				RegistryElement elPrev = reg.remove(id);
				RegistryElement toPlace = reg.getByName(elName);
						
				reg.put(reg.idOf(toPlace), elPrev);
				reg.put(id, toPlace);
			}
		}
		
		Client.channel.sendPacket(Packets.IM_READY, "Player" + Integer.toString(new Random().nextInt(1000)));
	}

	@Override
	public void write(ByteBuf buf, String s) {
		buf.writeInt(Registries.LIST.size());
		
		Registries.LIST.forEach(r -> {
			buf.writeInt(r.name.length());
			ByteBufUtil.writeUtf8(buf, r.name);
			buf.writeInt(r.size());
			
			r.forEachElement((id, element) -> {
				buf.writeInt(id);
				buf.writeInt(element.getName().length());
				ByteBufUtil.writeUtf8(buf, element.getName());
			});
		});
	}

}
