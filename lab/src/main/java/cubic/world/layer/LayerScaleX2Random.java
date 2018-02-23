package cubic.world.layer;

import org.objkt.engine.MathUtils;

public class LayerScaleX2Random extends LayerAbstract {

	public LayerScaleX2Random(LayerAbstract parent) {
		super(parent);
	}

	@Override
	public byte[] getValues(int x, int z, int width, int length) {
		boolean evenX = x % 2 == 0;
		boolean evenZ = z % 2 == 0;
		int widthParent = (width / 2) + 3;
		int lengthParent = (length / 2) + 3;
		int xParent = MathUtils.floor((float) x / 2F) + (x < 0 ? (evenX ? 0 : -1) : -1);
		int zParent = MathUtils.floor((float) z / 2F) + (z < 0 ? (evenZ ? 0 : -1) : -1);
		byte[] valuesParent = parent.getValues(xParent, zParent, widthParent, lengthParent);
		byte[] values = getByteArray(width, length);

		int index = -1;

		int weven = evenX ? 0 : 1;
		int wnven = evenX ? 1 : 0;

		for (int z2 = 0; z2 < length; z2++) {
			int ldt = (evenZ ? z2 / 2 : (z2 + 1) / 2);

			int upIDP = (ldt + 2) * lengthParent + weven + 1;
			int downIDP = (ldt + 0) * lengthParent + weven + 1;
			int rightIDP = (ldt + 1) * lengthParent + weven + 2;
			int centIDP = (ldt + 1) * lengthParent + weven + 1;
			upIDP--;
			downIDP--;
			rightIDP--;
			centIDP--;
			
			boolean even = false;
			int toAdd;
			
			int valueUpP = 0;
			int valueDownP = 0;
			int valueLeftP = 0;
			int valueRightP = valuesParent[rightIDP + 1];
			int valueCentP = valuesParent[centIDP + 1];
			
			for (int x2 = 0; x2 < width; x2++) {
				index++;

				toAdd = even ? weven : wnven;

				upIDP += toAdd;
				downIDP += toAdd;
				rightIDP += toAdd;

				valueCentP = valueRightP;
				valueLeftP = valueCentP;
				valueUpP = valuesParent[upIDP];
				valueDownP = valuesParent[downIDP];
				valueRightP = valuesParent[rightIDP];

				if (valueUpP == valueCentP && valueDownP == valueCentP && valueRightP == valueCentP) {
					values[index] = (byte) valueCentP;
				}
				else {
					int val = MathUtils.prInt(MathUtils.clampToLong(x + x2, z + z2), 0, 6);
					if (val == 0) {
						values[index] = (byte) valueUpP;
					}
					if (val == 1) {
						values[index] = (byte) valueDownP;
					}
					if (val == 2) {
						values[index] = (byte) valueLeftP;
					}
					if (val == 3) {
						values[index] = (byte) valueRightP;
					}
					if (val == 4 || val == 5) {
						values[index] = (byte) valueCentP;
					}
				}
				even = !even;
			}
		}

		return values;
	}

	public static LayerScaleX2Random getLayer(int count, LayerAbstract parent) {
		LayerScaleX2Random layer = new LayerScaleX2Random(parent);

		for (int i = 0; i < count - 1; i++) {
			layer = new LayerScaleX2Random(layer);
		}

		return layer;
	}
}
