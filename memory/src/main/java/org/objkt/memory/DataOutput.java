package org.objkt.memory;

public interface DataOutput extends java.io.DataOutput {
	@Override
	void writeLong(long arg0);
	
	@Override
	void writeInt(int v);
	
	@Override
	void writeUTF(String s);
}
