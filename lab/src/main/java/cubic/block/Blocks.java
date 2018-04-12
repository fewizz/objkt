package cubic.block;

public class Blocks {
	public static final BlockAir AIR = new BlockAir(new SimpleBlockProvider("cubic:air", () -> { return Blocks.AIR; }));
	public static final BlockDirt DIRT = new BlockDirt(new SimpleBlockProvider("cubic:dirt", () -> { return Blocks.DIRT; }));
}
