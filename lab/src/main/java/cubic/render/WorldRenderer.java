package cubic.render;

import cubic.Client;
import cubic.world.Chunk;
import fewizz.wrap.gl.enums.ClearBuffer;
import org.joml.Matrix4f;
import org.lwjgl.BufferUtils;

import java.nio.FloatBuffer;

import static cubic.Client.gl;
import static cubic.Client.window;

public class WorldRenderer {
	public static Matrix4f proj = new Matrix4f();
	public static Matrix4f view = new Matrix4f();
	public static Matrix4f combined = new Matrix4f();
	public static FloatBuffer combinedBuffer = BufferUtils.createFloatBuffer(4*4*Float.BYTES);
	public static final ChunksRenderer cr = new ChunksRenderer();
	
	public static void render() {
		gl.clearColor(0, 0, 1, 1);
		gl.clear(ClearBuffer.COLOR_BUFFER_BIT, ClearBuffer.DEPTH_BUFFER_BIT);
		view.identity();
		view.rotate((float)Math.toRadians(Client.CAM.dY), 1, 0, 0);
		view.rotate((float)Math.toRadians(Client.CAM.dX), 0, 1, 0);
		view.translate((float)Client.CAM.x, (float)Client.CAM.y, (float)Client.CAM.z);

		proj.identity();
		proj.setPerspective(95, (float)window.width() / (float)window.height(), 0.5F, 100F);
		combined.identity();
		combined.identity().mul(proj).mul(view);
		combined.get(combinedBuffer);
		cr.render();
	}
}
