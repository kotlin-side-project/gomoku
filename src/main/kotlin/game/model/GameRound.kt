package game.model

class GameRound(private val delegate: Delegate? = null) {
    private var board = Array(15) { Array(15) { CellState.EMPTY } }
    private var currentPlayer = GamePlayer.BLACK

    fun move(row: Int, col: Int) {
        val prevState = board[row][col]
        if (prevState == CellState.EMPTY) {
            val newState = when (currentPlayer) {
                GamePlayer.BLACK -> CellState.BLACK
                GamePlayer.WHITE -> CellState.WHITE
            }
            val prevPlayer = currentPlayer
            val newPlayer = currentPlayer.nextPlayer

            board[row][col] = newState
            currentPlayer = newPlayer

            delegate?.handleEvent(GameEvent.CellChanged(row, col, prevState, newState, prevPlayer, newPlayer))
        }
    }

    fun getCellState(row: Int, col: Int): CellState {
        return board[row][col]
    }

    interface Delegate {
        fun handleEvent(event: GameEvent)
    }
}