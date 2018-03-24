package cubic.block;

import java.util.function.*;

import org.objkt.memory.*;

public class SimpleBlockProvider implements BlockProvider {
	String name;
	Supplier<Block> blockSup;

	public SimpleBlockProvider(String name, Supplier<Block> bs) {
		this.blockSup = bs;
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Block getBlock(DataInput in) {
		return blockSup.get();
	}


}
