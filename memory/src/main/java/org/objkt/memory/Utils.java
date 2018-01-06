package org.objkt.memory;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import sun.misc.Unsafe;

public class Utils {
	static Unsafe unsafe;
	static Field bufferAddressField;
	static Field bufferCapField;
	
	static {
		try {
			Field f = Unsafe.class.getDeclaredField("theUnsafe");
			f.setAccessible(true);
			unsafe = (Unsafe) f.get(null);
			
			bufferAddressField = Buffer.class.getDeclaredField("address");
			bufferAddressField.setAccessible(true);
			
			bufferCapField = Buffer.class.getDeclaredField("capacity");
			bufferCapField.setAccessible(true);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	public static long address(Buffer buff) {
		try {
			return bufferAddressField.getLong(buff);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static long addressOfStringUTF8(String s, boolean nullT) {
		ByteBuffer b = java.nio.charset.Charset.forName("UTF-8").encode(s + (nullT ? '\0' : ""));
		ByteBuffer direct = directByteBuffer(b.capacity()).put(b);
		direct.flip();
		return address(direct);
	}
	
	public static ByteBuffer directByteBuffer(int cap) {
		return ByteBuffer.allocateDirect(cap).order(ByteOrder.nativeOrder());
	}
	
	public static FloatBuffer directFloatBuffer(int cap) {
		return directByteBuffer(cap * Float.BYTES).asFloatBuffer();
	}
	
	public static IntBuffer directIntBuffer(int cap) {
		return directByteBuffer(cap * Integer.BYTES).asIntBuffer();
	}
	
	public static void invalidateBuffer(Buffer b) {
		setBuffer(b, 0, 0);
	}
	
	public static void setBuffer(Buffer b, long addr, int cap) {
		try {
			bufferAddressField.setLong(b, addr);
			bufferCapField.setInt(b, cap);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
