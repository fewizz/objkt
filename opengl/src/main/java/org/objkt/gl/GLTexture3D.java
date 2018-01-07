package org.objkt.gl;

import org.lwjgl.opengl.GL12;
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
		GL12.glTexImage3D(target.token, level, inernalFormat.token, width, height, depth, 0, bufferPixelFormat.token, bufferDataType.token, address);
	}

	public void subData3D(int level, int xOff, int yOff, int zOff, int width, int height, int depth, PixelFormat bufferPixelFormat, PixelType bufferDataType, long address) {
		bind();
		GL12.glTexSubImage3D(target.token, level, xOff, yOff, zOff, width, height, depth, bufferPixelFormat.token, bufferDataType.token, address);
	}

}
