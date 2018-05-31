package cubic.render

import org.objkt.engine.Color
import fewizz.wrap.gl.GLVertexArray.VertexAttribFormat
import fewizz.wrap.gl.enums.BufferUsage

class ChunkVertexArrayBuilder : VertexArrayBuilder(BufferUsage.STATIC_DRAW, VertexAttribFormat.pos3f(0), VertexAttribFormat.color4ub(1)) {

    fun position(x: Float, y: Float, z: Float): ChunkVertexArrayBuilder {
        float3(0, x, y, z)
        return this
    }

    fun color(c: Color): ChunkVertexArrayBuilder {
        int1(1, c.asInt())
        return this
    }


}
