package org.objkt.engine;

public class MathUtils {
	public static long clampToLong(int x, int z) {
		return (((long)z & 0xFFFFFFFFL) | (long)x << 32);
	}
	
	public static int clampToInt(int x, int z) {
		return (z & 0xFFFF | x << 16);
	}

	public static int floor(float f) {
		if (f < 0) {
			return (int) (f) - 1;
		}

		return (int) f;
	}

	public static int floor(double f) {
		if (f < 0) {
			return (int) (f) - 1;
		}

		return (int) f;
	}

	public static int ceil(float f) {
		if (f > 0) {
			return (int) (f) + 1;
		}
		return (int) f;
	}

	public static int ceil(double f) {
		if (f > 0) {
			return (int) (f) + 1;
		}
		return (int) f;
	}

	public static float fract(float x) {
		return x - (float) floor(x);
	}

	public static double fract(double x) {
		return x - (double) floor(x);
	}

	public static float dot(float x1, float y1, float z1, float x2, float y2, float z2) {
		return x1 * x2 + y1 * y2 + z1 * z2;
	}

	public static double dot(double x1, double y1, double z1, double x2, double y2, double z2) {
		return x1 * x2 + y1 * y2 + z1 * z2;
	}

	public static float dot(float x1, float y1, float x2, float y2) {
		return x1 * x2 + y1 * y2;
	}

	public static float smoothstep(float edge0, float edge1, float x) {
		float t;
		t = clamp(1, 0, (x - edge0) / (edge1 - edge0));
		return t * t * (3 - 2 * t);
	}

	public static float clamp(float max, float min, float x) {
		return Math.max(min, Math.min(x, max));
	}
	
	public static int sign(double num) {
		return num >= 0 ? 1 : -1;
	}
	
	public static double sinDeg(double angle) {
		return Math.sin(Math.toRadians(angle));
	}
	
	public static long prLong(long seed) {
		seed += 1337139856426462215L;
		seed *= 113712915615665641L;
		seed += 1637139235435855735L;
		seed *= 113739312355845341L * seed;
		return seed;
	}
	
	public static int prInt(long seed) {
		return (int) prLong(seed);
	}
	
	/** max - exclusive */
	public static int prInt(long seed, int min, int max) {
		int v = (int) prLong(seed);
		v = v % (max - min);
		return min + v;
	}
	
	public static boolean prBool(long seed) {
		return (prLong(seed) & 0x1) == 0;
	}
	
	public static boolean isOutOfRadius(int radius, float dx, float dy, float dz) {
		return MathUtils.dot(dx, dx, dy, dy, dz, dz) > radius*radius*radius;
	}
	
	public static void main(String[] args) {
		for(int i = 0; i < 10000; i++)System.out.println(prLong(i));
	}
}
