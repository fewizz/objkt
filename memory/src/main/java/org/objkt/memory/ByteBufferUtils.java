package org.objkt.memory;

import java.nio.ByteBuffer;

public class ByteBufferUtils {

	public static void put(ByteBuffer to, ByteBuffer src, int bytes) {
		int prevLimit = src.limit();
		src.limit(src.position() + bytes);
		to.put(src);
		src.limit(prevLimit);
	}

}
