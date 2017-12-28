package org.objkt.gl;

import org.objkt.gl.enums.InternalFormat;
import org.objkt.gl.enums.PixelFormat;
import org.objkt.gl.enums.PixelType;
import org.objkt.gl.enums.TextureTarget;

public class GLTexture3D extends GLTexture {
	
	public GLTexture3D() {
		super(TextureTarget.TEXTURE_3D);
	}
	
	protected GLTexture3D(TextureTarget tar) {
		super(tar);
	}
	
	public void data3D(int level, InternalFormat inernalFormat, int width, int height, int depth, PixelFormat bufferPixelFormat, PixelType bufferDataType, long address) {
		bind();
		context.wrapper.texImage3D(target, level, inernalFormat, width, height, depth, 0, bufferPixelFormat, bufferDataType, address);
	}

	public void subData3D(int level, int xOff, int yOff, int zOff, int width, int height, int depth, PixelFormat bufferPixelFormat, PixelType bufferDataType, long address) {
		bind();
		context.wrapper.texSubImage3D(target, level, xOff, yOff, zOff, width, height, depth, bufferPixelFormat, bufferDataType, address);
	}

}
