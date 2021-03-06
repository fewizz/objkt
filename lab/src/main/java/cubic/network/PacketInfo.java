package cubic.network;

import org.objkt.memory.*;

import cubic.Registry.SimpleRegistryElement;

public abstract class PacketInfo<T> extends SimpleRegistryElement {
	public abstract void read(DataInput in, Connection connection);
	
	public abstract void write(DataOutput out, T t, Connection connection);
}
