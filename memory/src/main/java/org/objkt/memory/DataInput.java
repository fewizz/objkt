package org.objkt.memory;

public interface DataInput extends java.io.DataInput {
	@Override
	long readLong();
	
	@Override
	int readInt();
	
	@Override
	String readUTF();
}
