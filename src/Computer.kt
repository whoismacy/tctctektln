import kotlin.random.Random

class Computer(
    override var kind: String,
    val game: Game,
) : Player {
    override var movesCount: Int = 0
    override var movesMade: MutableList<String> = mutableListOf()
    override var startIndex: Int = 0

    override fun makeMove(kind: String) {
        movesCount += 1
        movesMade.add(kind)
        println("Computer's Move:")
        game.executeMove(position = kind, player = this)
    }

    fun randomMove() {
        val move: String = game.possibleOpts[Random.nextInt(game.possibleOpts.size)]
        makeMove(move)
    }
}
