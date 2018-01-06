package org.objkt.gl.wrapper;

import org.lwjgl.opengl.GL11;

public class LWJGLWrp implements Wrpv2 {

	@Override
	public TexWrap getTexWarp() {
		return new TexWrap() {
			
			@Override
			public int gen() {
				return GL11.glGenTextures();
			}
			
			@Override
			public void delete(int name) {
				GL11.glDeleteTextures(name);
			}
			
			@Override
			public void bind(int target, int name) {
				GL11.glBindTexture(target, name);
			}
			
			@Override
			public void parameteri() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void parameterf() {
				// TODO Auto-generated method stub
				
			}
		};
	}

}
