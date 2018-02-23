package cubic;
import org.joml.*;

public class Camera {
	Vector3d pos;
	double rotX;
	double rotY;
	
	public void moveFwd() {
		
	}
	
	public void rotate(double degX, double degY) {
		rotX += degX;
		rotY += degY;
	}
	
}
