interface Player {
    var kind: String
    var movesCount: Int
    var movesMade: MutableList<String>
    var startIndex: Int

    fun makeMove(kind: String)
}
