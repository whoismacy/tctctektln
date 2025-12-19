@Suppress("ktlint:standard:max-line-length")
class UserInterface {
    lateinit var user: User
    lateinit var computer: Computer
    var game: Game = Game()

    fun printHead() {
        println(
            """
'########:'####::'######:::::::::::'########::::'###:::::'######:::::::::::'########::'#######::'########:
... ##..::. ##::'##... ##::::::::::... ##..::::'## ##:::'##... ##::::::::::... ##..::'##.... ##: ##.....::
::: ##::::: ##:: ##:::..:::::::::::::: ##:::::'##:. ##:: ##:::..:::::::::::::: ##:::: ##:::: ##: ##:::::::
::: ##::::: ##:: ##:::::::'#######:::: ##::::'##:::. ##: ##:::::::'#######:::: ##:::: ##:::: ##: ######:::
::: ##::::: ##:: ##:::::::........:::: ##:::: #########: ##:::::::........:::: ##:::: ##:::: ##: ##...::::
::: ##::::: ##:: ##::: ##::::::::::::: ##:::: ##.... ##: ##::: ##::::::::::::: ##:::: ##:::: ##: ##:::::::
::: ##::::'####:. ######:::::::::::::: ##:::: ##:::: ##:. ######:::::::::::::: ##::::. #######:: ########:
:::..:::::....:::......:::::::::::::::..:::::..:::::..:::......:::::::::::::::..::::::.......:::........::
            """.trimIndent(),
        )
        println("Welcome to a Game of Tic-Tac-Toe against a Computer")
    }

    fun start() {
        try {
            printHead()
            print("What is your preferred name/nickname?: ")
            val name: String = readln().trim()
            print("Okay $name and what character would you like to use (X / O)?: ")
            val character: String = readln().trim().uppercase()
            if (character !in setOf("X", "O")) {
                throw Exception("Invalid character")
            }
            val compChar: String = if (character == "X") "O" else "X"
            user = User(kind = character, name = name, game = game)
            computer = Computer(kind = compChar, game = game)
            println(
                "Game rules are easy ${user.name}:\n\t>> You make a move by inputting the value(alphabet) of the position you would like to occupy.\n\t>> Making a move on an already occupied position is Invalid and play is given to the opposing player.\n",
            )
            playLoop()
            game.printStat()
        } catch (e: Exception) {
            if (e.message == "Invalid Move") {
                println("\nINVALID MOVE: YOU CANNOT OCCUPY AN ALREADY OCCUPIED POSITION\n")
            } else {
                println("\nINVALID CHARACTER: PLEASE INPUT A VALID CHARACTER (X / O)\n")
                clearScreen()
                start()
            }
        }
    }

    private fun playLoop() {
        var rounds = 9
        game.board.printBoard()
        while (rounds > 0) {
            print("Make move ${user.name}: ")
            val move = readln().trim().lowercase()
            user.makeMove(move)
            if (game.checkWinningMove(user) == 1) {
                println("Congratulations: ${user.name} You Won")
                break
            }
            rounds -= 1
            if ((rounds >= 1)) {
                computer.randomMove()
                if (game.checkWinningMove(computer) == 2) {
                    println("You Lose: Computer Wins")
                }
                rounds -= 1
            }
        }
    }

    private fun clearScreen() {
        println("\\033[H\\033[2J")
        System.out.flush()
    }
}
