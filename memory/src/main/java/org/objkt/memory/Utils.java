package org.objkt.memory;

import java.lang.reflect.*;
import java.nio.*;

import sun.misc.Unsafe;

public class Utils {
	public static final Unsafe UNSAFE;
	static final Field FIELD_BUFFER_ADDRESS;
	static final Field FIELD_BUFFER_CAPACITY;
	static final Constructor<?> CONSTRUCTOR_DIRECT_BUFFER;
	
	static {
		Unsafe u = null;
		Field ba = null;
		Field bc = null;
		Constructor<?> dbc = null;
		try {
			Field uf = Unsafe.class.getDeclaredField("theUnsafe");
			uf.setAccessible(true);
			u = (Unsafe) uf.get(null);
			
			ba = Buffer.class.getDeclaredField("address");
			ba.setAccessible(true);
			
			bc = Buffer.class.getDeclaredField("capacity");
			bc.setAccessible(true);
			
			dbc = Class.forName("java.nio.DirectByteBuffer").getDeclaredConstructor(long.class, int.class);
			dbc.setAccessible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		CONSTRUCTOR_DIRECT_BUFFER = dbc;
		FIELD_BUFFER_ADDRESS = ba;
		FIELD_BUFFER_CAPACITY = bc;
		UNSAFE = u;
	}
	
	public static long address(ByteBuffer buff) {
		try {
			return FIELD_BUFFER_ADDRESS.getLong(buff);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static int utf8Length(CharSequence sequence) {
		int count = 0;
	    for (int i = 0, len = sequence.length(); i < len; i++) {
	      char ch = sequence.charAt(i);
	      if (ch <= 0x7F) {
	        count++;
	      } else if (ch <= 0x7FF) {
	        count += 2;
	      } else if (Character.isHighSurrogate(ch)) {
	        count += 4;
	        ++i;
	      } else {
	        count += 3;
	      }
	    }
	    return count;
	}
	
	public static ByteBuffer newNullDirectBufferWithoutCleaner() {
		try {
			return ((ByteBuffer) CONSTRUCTOR_DIRECT_BUFFER.newInstance(0L, 0)).order(ByteOrder.nativeOrder());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ByteBuffer newDirectBufferWithoutCleaner(int capacity) {
		try {
			return ((ByteBuffer) CONSTRUCTOR_DIRECT_BUFFER.newInstance(UNSAFE.allocateMemory(capacity), capacity)).order(ByteOrder.nativeOrder());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void invalidateBuffer(ByteBuffer b) {
		setBufferAddressAndCapacity(b, 0, 0);
	}
	
	public static void setBufferAddressAndCapacity(ByteBuffer b, long addr, int cap) {
		try {
			FIELD_BUFFER_ADDRESS.setLong(b, addr);
			FIELD_BUFFER_CAPACITY.setInt(b, cap);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	public static void setBufferAddress(ByteBuffer b, long addr) {
		try {
			FIELD_BUFFER_ADDRESS.setLong(b, addr);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
