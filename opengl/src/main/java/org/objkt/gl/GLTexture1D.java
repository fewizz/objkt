package org.objkt.gl;

import org.lwjgl.opengl.GL11;
import org.objct.gl.enums.InternalFormat;
import org.objct.gl.enums.PixelFormat;
import org.objct.gl.enums.PixelType;

public class GLTexture1D extends GLTexture {
	
	public GLTexture1D() {
		super(null);
	}
	
	public void data1D(int level, InternalFormat inernalFormat, int width, PixelFormat pf, PixelType bufferDataType, long address) {
		bind();
		GL11.nglTexImage1D(target.token, level, inernalFormat.token, width, 0, pf.token, bufferDataType.token, address);
	}

	public void subData1D(int level, int xOffset, int width, PixelFormat pf, PixelType bufferDataType, long address) {
		bind();
		GL11.nglTexSubImage1D(target.token, level, xOffset, width, pf.token, bufferDataType.token, address);
	}
}
