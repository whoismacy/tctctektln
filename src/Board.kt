class Board {
    var board =
        """
               |       |
           a   |   b   |   c
               |       |
        -------|-------|------- 
               |       |
           d   |   e   |   f
               |       |
        -------|-------|------- 
               |       |
           g   |   h   |   i
               |       | 
        """.trimIndent()

    fun makeMove(
        character: String,
        position: String,
    ) {
        board = board.replace(position, character)
        println(board)
        println()
    }

    fun printBoard() {
        println(board)
    }
}
