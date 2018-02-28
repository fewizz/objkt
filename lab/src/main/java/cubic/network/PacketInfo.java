package cubic.network;

import cubic.Registry.SimpleRegistryElement;
import io.netty.buffer.ByteBuf;

public abstract class PacketInfo<T> extends SimpleRegistryElement {
	protected abstract void read(ExtendedChannel channel, ByteBuf buf);
	
	protected abstract void write(ByteBuf buf, T t);
}
