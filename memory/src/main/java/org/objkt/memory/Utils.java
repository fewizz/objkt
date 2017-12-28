package org.objkt.memory;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import sun.misc.Unsafe;

public class Utils {
	static Unsafe unsafe;
	static Field bufferAddressField;
	
	static {
		try {
			Field f = Unsafe.class.getDeclaredField("theUnsafe");
			f.setAccessible(true);
			unsafe = (Unsafe) f.get(null);
			
			bufferAddressField = Buffer.class.getDeclaredField("address");
			bufferAddressField.setAccessible(true);
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
		ByteBuffer direct = direct(b.capacity()).put(b);
		direct.flip();
		/*MemBlock mb = new MemBlock().allocate(b.capacity());
		for(int i = 0; i < b.limit(); i++) {
			mb.put(i, b.get(i));
		}*/
		return address(direct);
	}
	
	public static ByteBuffer direct(int cap) {
		return ByteBuffer.allocateDirect(cap).order(ByteOrder.nativeOrder());
	}
}
