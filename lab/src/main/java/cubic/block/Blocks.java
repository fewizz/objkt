package cubic.block;

public class Blocks {
	public static final BlockDirt AIR = new BlockDirt(new SimpleBlockProvider("cubic:air", () -> { return Blocks.AIR; }));
	public static final BlockDirt DIRT = new BlockDirt(new SimpleBlockProvider("cubic:dirt", () -> { return Blocks.DIRT; }));
}
