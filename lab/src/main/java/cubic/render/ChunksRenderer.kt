package cubic.render

import cubic.world.Chunk
import fewizz.wrap.gl.GLContext
import fewizz.wrap.gl.GLShaderProgram
import fewizz.wrap.gl.GLVertexArray
import fewizz.wrap.gl.enums.PrimitiveType
import fewizz.wrap.gl.enums.ShaderType
import java.util.*

class ChunksRenderer {
    val program: GLShaderProgram = GLShaderProgram(
            ShaderType.VERTEX_SHADER,
            """
                #version 330
                layout(location = 0) in vec3 pos;
                layout(location = 1) in vec4 color;

                out vec4 vs_color;

                uniform mat4 mat;
                uniform vec3 chunkPos;

                void main() {
                    vs_color = color;
                    gl_Position = mat * vec4(pos + chunkPos, 1.);
                }
                """,
            ShaderType.FRAGMENT_SHADER,
            """
                #version 330
                in vec4 vs_color;
                out vec4 c;

                void main() {
                    c = vs_color;
                }
                """)
    private val matLocation: Int = program.getUniformLocation("mat")
    private val chunkPosLoc: Int = program.getUniformLocation("chunkPos")
    private val RENDERERS: MutableList<ChunkRenderer> = ArrayList()

    fun render() {
        program.setUniformMatrix4f(matLocation, 1, false, WorldRenderer.combinedBuffer)
        RENDERERS.forEach {
            program.setUniform3f(chunkPosLoc, (it.chunk.pos.x * 16).toFloat(), (it.chunk.pos.y * 16).toFloat(), (it.chunk.pos.z * 16).toFloat())
            it.render(program)
        }
    }

    fun addChunkToRender(ch: Chunk) {
        RENDERERS.add(ChunkRenderer(ch))
    }
}

class ChunkRenderer(ch: Chunk) {
    val chunk = ch
    private var vao: GLVertexArray

    init {
        val vaob = ChunkVertexArrayBuilder()
        for (x in 0..15)
            for (y in 0..15)
                for (z in 0..15)
                    ch.getBlock(x, y, z).renderStaticly(ch, vaob, x, y, z)
        vao = vaob.build()
        System.out.println("Built: $ch vao pos size: ${vao.getVertexAttribArrayAt(0).vbo.size()}, color: ${vao.getVertexAttribArrayAt(1).vbo.size()}")
    }

    fun render(program: GLShaderProgram) {
        GLContext.current().drawArrays(program, vao, PrimitiveType.TRIANGLES, vao.getVertexAttribArrayAt(0).vertexCount)
    }
}
