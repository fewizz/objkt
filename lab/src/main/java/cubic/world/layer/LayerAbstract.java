package cubic.world.layer;

import cubic.OpenSimplexNoise;

public abstract class LayerAbstract {
	private byte[] values;
	public static long seed;
	public static final OpenSimplexNoise SIMPLEX_NOISE = new OpenSimplexNoise(1337);
	LayerAbstract parent;
	
	public LayerAbstract(LayerAbstract parent) {
		this.parent = parent;
	}
	
	public abstract byte[] getValues(int x, int z, int width, int length);
	
	public byte[] getByteArray(int width, int length) {
		if(values == null || values.length != width * length) {
			values = new byte[width * length];
			return values;
		}
		
		return values;
	}
	
}
