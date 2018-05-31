package cubic.render

import fewizz.wrap.gl.GLVertexArray
import fewizz.wrap.gl.GLVertexBuffer
import fewizz.wrap.gl.enums.BufferUsage
import org.objkt.memory.OffheapDataChannel
import java.nio.ByteBuffer
import java.nio.ByteOrder

open class VertexArrayBuilder(internal val usage: BufferUsage, vararg attribsArray: GLVertexArray.VertexAttribFormat) {
    private val indicies = attribsArray.map { it.index }
    private val data = attribsArray.map { it.index to OffheapDataChannel(ByteOrder.nativeOrder()) }.toMap()
    private val step = attribsArray.map { it.index to ByteBuffer.allocateDirect(it.bytes()).order(ByteOrder.nativeOrder()) }.toMap()
    private val attribFormats = attribsArray.map { it.index to it }.toMap()

    fun endVertex() {
        indicies.forEach {
            step[it]!!.position(0)
            data[it]!!.write(step[it])
        }
    }

    fun build(): GLVertexArray {
        val va = GLVertexArray()

        indicies.forEach {
            val vbo = GLVertexBuffer()
            vbo.allocate(data[it]!!.size(), BufferUsage.STATIC_DRAW)
            data[it]!!.position(0)
            data[it]!!.forEachSegment { vbo.subData(it.globalPosition.toLong(), it.buffer().limit().toLong(), it.buffer()) }
            va.vertexAttribPointer(attribFormats[it], vbo).enable()
        }

        return va
    }

    fun float3(index: Int, f1: Float, f2: Float, f3: Float): VertexArrayBuilder {
        val mb = step[index]
        mb!!.putFloat(0, f1)
        mb.putFloat(java.lang.Float.BYTES, f2)
        mb.putFloat(2 * java.lang.Float.BYTES, f3)
        return this
    }

    fun float2(index: Int, f1: Float, f2: Float): VertexArrayBuilder {
        val mb = step[index]
        mb!!.putFloat(0, f1)
        mb.putFloat(java.lang.Float.BYTES, f2)
        return this
    }

    fun float1(index: Int, f: Float): VertexArrayBuilder {
        step[index]!!.putFloat(0, f)
        return this
    }

    fun int1(index: Int, i: Int): VertexArrayBuilder {
        step[index]!!.putInt(0, i)
        return this
    }

    fun short1(index: Int, s: Short): VertexArrayBuilder {
        step[index]!!.putShort(0, s)
        return this
    }
}
