package cubic;

import org.joml.Vector3d;
import org.objkt.engine.MathUtils;

import cubic.world.*;

public class Entity {
	private World world;
	public final Vector3d position = new Vector3d();
	
	public boolean causeChunkUpdate() {
		return false;
	}
	
	public long getChunkLong() {
		return Chunk.Position.toLong(MathUtils.floor(position.x) >> 16, MathUtils.floor(position.y) >> 16, MathUtils.floor(position.z) >> 16);
	}
	
	public String getName() {
		return null;
	}
	
	public World getWorld() {
		return world;
	}
}
