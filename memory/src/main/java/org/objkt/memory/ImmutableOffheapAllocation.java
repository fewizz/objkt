package org.objkt.memory;

import java.nio.ByteBuffer;

public class ImmutableOffheapAllocation extends OffheapAllocation {
	ByteBuffer buffer =

	@Override
	protected long address() {
		return 0;
	}

	@Override
	protected long bytes() {
		return 0;
	}
}
