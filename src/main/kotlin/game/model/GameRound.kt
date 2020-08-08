package game.model

class GameRound(private val delegate: Delegate? = null) {
    private val board = GomokuBoard(Array(15) { Array(15) { CellState.EMPTY } })
    private var currentPlayer = GamePlayer.BLACK

    fun move(row: Int, col: Int) {
        val prevState = board.table[row][col]
        if (prevState == CellState.EMPTY) {
            val newState = when (currentPlayer) {
                GamePlayer.BLACK -> CellState.BLACK
                GamePlayer.WHITE -> CellState.WHITE
            }
            val prevPlayer = currentPlayer
            val newPlayer = currentPlayer.nextPlayer

            board.table[row][col] = newState
            currentPlayer = newPlayer

            delegate?.handleEvent(GameEvent.CellChanged(row, col, prevState, newState, prevPlayer, newPlayer))
        }
    }

    fun getCellState(row: Int, col: Int): CellState {
        return board.table[row][col]
    }

    interface Delegate {
        fun handleEvent(event: GameEvent)
    }
}