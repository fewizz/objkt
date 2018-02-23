package cubic.world;

import org.objkt.memory.*;

import cubic.*;
import cubic.block.Block;

public class Chunk {
	public final Position pos;
	
	final Block[] blocks = new Block[16*16*16];
	
	public Chunk(int x, int y, int z) {
		this.pos = new Position(x, y, z);
	}
	
	public final Block getBlock(int x, int y, int z) {
		return getBlock(index(x, y, z));
	}
	
	public final Block getBlock(int index) {
		return blocks[index];
	}
	
	private final int index(int x, int y, int z) {
		return (x & 0xF) | ((y & 0xF) << 4) | ((z & 0xF) << 8);
	}
	
	public final void setBlock(Block b, int index) {
		blocks[index] = b;
	}
	
	public final void setBlock(Block b, int x, int y, int z) {
		blocks[index(x, y, z)] = b;
	}
	
	@Override
	public boolean equals(Object arg0) {
		return this == arg0;
	}
	
	public void writeBlockData(MemBlockDataOutput out) {
		for(Block b : blocks) {
			out.writeInt(Registries.BLOCKS.idOf(b.getProvider()));
			b.write(out);
		}
	}
	
	public void readBlockData(MemBlockDataInput in) {
		for(int i = 0; i < 16*16*16; i++) {
			int id = in.readInt();
			
			Block b = Registries.BLOCKS.get(id).getBlock(in);
			setBlock(b, i);
		}
	}
	
	public static final class Position {
		public final int x, y, z;
		
		public Position(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
		
		public Position(long pos) {
			x = (int) (pos >> 43);
			y = (int) ((pos >> 21) & 0b1111111111111111111111);
			z = (int) (pos & 0b111111111111111111111);
		}
		
		public long toLong() {
			return toLong(x, y, z);
		}
		
		public static long toLong(int x, int y, int z) {
			return ((long)x << 43) | (long)(y & 0b1111111111111111111111) << 21 | z & 0b111111111111111111111;
		}
		
		@Override
		public boolean equals(Object obj) {
			if(obj == this)
				return true;
			if(!(obj instanceof Position))
				return false;
			Position p = (Position) obj;
			return p.x == x && p.y == y && p.z == z;
		}
	}
}
