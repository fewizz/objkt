package cubic.world.biome;

import java.awt.Color;

public enum Climate {
	DRY(Color.YELLOW, 50),
	TROPICAL(Color.GREEN, 50),
	MODERATE(Color.BLUE, 80),
	CONTINENTAL(Color.CYAN, 95),
	POLAR(Color.WHITE, 0);
	
	Climate(Color color, int chanceOfWater) {
		this.color = color;
		this.chanceOfWater = chanceOfWater;
	}
	
	public Color color;
	public int chanceOfWater;
	
	static Climate[] climats;
	
	static {
		climats = values();
	}
	
	public static Climate[] all() {
		return climats;
	}
}
