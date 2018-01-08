package org.objkt.gl.wrapper;

import org.objkt.gl.enums.*;

public interface DebugMessageCallback {
	void callback(DebugSource source, DebugType type, int id, DebugSeverity severity, String message);
}
