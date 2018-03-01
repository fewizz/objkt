package cubic.block;

import org.objkt.memory.*;

import cubic.Registry.RegistryElement;

public interface BlockProvider extends RegistryElement {
	
	public abstract Block getBlock(DataInput in);
}
