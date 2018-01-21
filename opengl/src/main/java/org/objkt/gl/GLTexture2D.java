package org.objkt.gl;

import org.objkt.gl.enums.*;

public class GLTexture2D extends GLTexture {
	
	public GLTexture2D() {
		super(TextureTarget.TEXTURE_2D);
	}
	
	public void data2D(int level, InternalFormat inernalFormat, int width, int height, PixelFormat bufferPixelFormat, PixelType bufferDataType, long address) {
		bind();
		ctx.wrap.tex.image2D(target.token, level, inernalFormat.token, width, height, 0, bufferPixelFormat.token, bufferDataType.token, address);
	}

	public void subData2D(int level, int xOff, int yOff, int width, int height, PixelFormat bufferPixelFormat, PixelType bufferDataType, long address) {
		bind();
		ctx.wrap.tex.subImage2D(target.token, level, xOff, yOff, width, height, bufferPixelFormat.token, bufferDataType.token, address);
	}

}
