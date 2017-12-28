package org.objkt.gl;

import org.lwjgl.opengl.GL11;
import org.objkt.gl.enums.InternalFormat;
import org.objkt.gl.enums.PixelFormat;
import org.objkt.gl.enums.PixelType;
import org.objkt.gl.enums.TextureTarget;

public class GLTexture2D extends GLTexture {
	
	public GLTexture2D() {
		super(TextureTarget.TEXTURE_2D);
	}
	
	public void data2D(int level, InternalFormat inernalFormat, int width, int height, PixelFormat bufferPixelFormat, PixelType bufferDataType, long address) {
		bind();
		GL11.nglTexImage2D(target.token, level, inernalFormat.token, width, height, 0, bufferPixelFormat.token, bufferDataType.token, address);
	}

	public void subData2D(int xOff, int yOff, int zOff, int width, int height, PixelFormat bufferPixelFormat, PixelType bufferDataType, long address) {
		bind();
		GL11.nglTexSubImage2D(target.token, xOff, yOff, zOff, width, height, bufferPixelFormat.token, bufferDataType.token, address);
	}

}
