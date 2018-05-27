package cubic.network;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

import cubic.Registries;

@SuppressWarnings({"rawtypes", "unchecked"})
public class PacketHandler {
	ChannelExtension extension;
	private Map second;
	
	private final AtomicReference<Map> ref = new AtomicReference<>();
	
	public PacketHandler(ChannelExtension extension) {
		this.extension = extension;
		second = Collections.unmodifiableMap(new HashMap<>(Registries.PACKETS.size()));
		Map current = Collections.unmodifiableMap(new HashMap<>(Registries.PACKETS.size()));
		
		Registries.PACKETS.forEachElement((id, pi) -> {
			second.put(pi, new ArrayList<>());
			current.put(pi, new ArrayList<>());
		});
		
		ref.set(current);
	}
	
	public <T> Map<PacketInfo<T>, List<T>> swap() {
		second = ref.getAndSet(second);
		return second;
	}
	
	public <T> Map<PacketInfo<T>, T> current() {
		return ref.get();
	}
}