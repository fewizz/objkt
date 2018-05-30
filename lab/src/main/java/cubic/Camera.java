package cubic;

public class Camera {
	/*public Matrix4f projectionMatrix;
	public Matrix4f modelviewMatrix;
	Matrix4f temp;
	Vector3d pos;
	FloatBuffer buff = BufferUtils.createFloatBuffer(4*4);*/
	public double dX, dY = 0;
	public double x, y, z = 0;
	
	public void move() {
		
	}
	
	public void rotate(double degX, double degY) {
		//modelviewMatrix.rotate((float)degX, 1, 0, 0);
		//modelviewMatrix.rotate((float)degY, 0, 1, 0);
		//rotX += degX;
		//rotY += degY;
		dX = degX;
		dY = degY;
	}

	/*public FloatBuffer updateAndGetBuffer() {
		temp = modelviewMatrix.mul(projectionMatrix);
		temp.get(buff);
		return buff;
	}*/
	
}
