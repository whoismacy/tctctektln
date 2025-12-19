class Game {
    val possibleOpts: MutableList<String> = mutableListOf("a", "b", "c", "d", "e", "f", "g", "h", "i")
    var winningMoves: Set<Set<String>> =
        setOf(
            setOf("a", "b", "c"),
            setOf("d", "e", "f"),
            setOf("g", "h", "i"),
            setOf("a", "d", "g"),
            setOf("b", "e", "h"),
            setOf("c", "f", "i"),
            setOf("a", "e", "i"),
            setOf("c", "e", "g"),
        )
    private var user: Int = 0
    private var computer: Int = 0
    var board = Board()

    fun checkValidMove(move: String): Boolean = move in possibleOpts

    fun executeMove(
        position: String,
        player: Player,
    ) {
        possibleOpts.remove(position)
        board.makeMove(player.kind, position)
    }

    fun checkWinningMove(player: Player): Int {
        if (player.movesCount >= 3) {
            for (combination in winningMoves) {
                if (player.movesMade.containsAll(combination)) {
                    if (player is User) {
                        user += 1
                        return 1
                    } else {
                        computer += 1
                        return 2
                    }
                }
            }
        }
        return 0
    }

    fun printStat() {
        print("Game Outcome: ")
        if (user > computer) {
            print("User Wins")
        } else if (user < computer) {
            print("Computer Wins")
        } else {
            print("Game ended In Draw")
        }
    }
}
