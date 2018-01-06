package org.objkt.gl.wrapper;

public interface Wrpv2 {
	TexWrap getTexWarp();
	
	static interface ObjWrap {
		int gen();
		void delete(int name);
	}
	
	static interface BindableObjWrap extends ObjWrap {
		void bind(int taget, int name);
	}
	
	static interface TexWrap extends BindableObjWrap {
		void parameteri();
		void parameterf();
	}
}
