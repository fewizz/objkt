package cubic.world.layer;

import java.util.ArrayList;

import org.objkt.engine.MathUtils;

import cubic.*;
import cubic.world.biome.*;

public class LayerBiomes extends LayerAbstract {

	public LayerBiomes() {
		super(new LayerClimate());
	}

	@Override
	public byte[] getValues(int x, int z, int width, int length) {
		byte[] valuesParent = parent.getValues(x, z, width, length);
		byte[] values = getByteArray(width, length);//new byte[width * length];
		
		for(int z2 = 0; z2 < length; z2++) {
			int id = z2 * length;
			
			for(int x2 = 0; x2 < width; x2++) {
				Climate climate = Climate.all()[valuesParent[id]];
				
				boolean earth = MathUtils.prInt(MathUtils.clampToLong(x + x2, z + z2), 0, 100) >= climate.chanceOfWater;
				ArrayList<BiomeAbstract> biomesByClimate;
				
				if(earth) {
					biomesByClimate = Biomes.getEarthBiomesByClimate(climate);
				}
				else {
					biomesByClimate = Biomes.getOceanBiomesByClimate(climate);
				}
				
				int biomeID = biomesByClimate.get(MathUtils.prInt(MathUtils.clampToLong(x + x2, z + z2), 0, biomesByClimate.size())).getBiomeID();
				
				values[id] = (byte) biomeID;
				
				id++;
			}
		}
		
		return values;
	}

}
