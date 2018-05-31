package cubic.world;

import org.objkt.memory.*;

import cubic.*;
import cubic.block.Block;

import java.util.Objects;

public class Chunk {
	public final Position pos;
	
	final Block[] blocks = new Block[16*16*16];

	public Chunk(Chunk.Position pos) {
		this.pos = pos;
	}

	public Chunk(int x, int y, int z) {
		this(new Chunk.Position(x, y, z));
	}
	
	public final Block getBlock(int x, int y, int z) {
		return getBlock(index(x, y, z));
	}
	
	public final Block getBlock(int index) {
		return blocks[index];
	}
	
	private int index(int x, int y, int z) {
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
	
	public void writeBlockData(DataOutput out) {
		for(Block b : blocks) {
			out.writeInt(Registries.BLOCKS.idOf(b.getProvider()));
			b.write(out);
		}
	}

	@Override
	public String toString() {
		return "Chunk{" +
				"pos=" + pos +
				'}';
	}

	public void readBlockData(DataInput in) {
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
		
		/*public Position(long pos) {
			x = (int) (pos >> 43);
			y = (int) ((pos >> 21) & 0b1111111111111111111111);
			z = (int) (pos & 0b111111111111111111111);
		}*/

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Position position = (Position) o;
			return x == position.x &&
					y == position.y &&
					z == position.z;
		}

		@Override
		public String toString() {
			return "Position{" +
					"x=" + x +
					", y=" + y +
					", z=" + z +
					'}';
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y, z);
		}
	}
}
