package cubic.block;

import org.objkt.memory.*;

public class BlockDirt extends Block implements BlockProvider {

	public BlockDirt(BlockProvider provider) {
		super(provider);
	}

	@Override
	public String getName() {
		return "cubic:dirt";
	}

	@Override
	public Block getBlock(DataInput in) {
		return Blocks.DIRT;
	}

}
