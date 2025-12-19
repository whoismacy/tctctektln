class User(
    val name: String,
    override var kind: String,
    val game: Game,
) : Player {
    override var movesCount: Int = 0
    override var movesMade: MutableList<String> = mutableListOf()
    override var startIndex: Int = 0

    override fun makeMove(kind: String) {
        if (!game.checkValidMove((kind))) {
            throw Exception("Invalid Move")
        } else {
            movesCount += 1
            movesMade.add(kind)
            println("$name's Move:")
            game.executeMove(position = kind, player = this)
        }
    }
}
