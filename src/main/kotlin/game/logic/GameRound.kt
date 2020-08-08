package game.logic

import game.model.CellChangedEvent
import game.model.CellState
import game.model.GameEvent
import game.model.GomokuBoard

class GameRound(private val delegate: Delegate? = null) {
    private val board = GomokuBoard(arrayOf(arrayOf(CellState.EMPTY)))

    fun move(row: Int, col: Int) {
        val prevState = board.table[row][col]
        val newState = when (prevState) {
            CellState.EMPTY -> CellState.BLACK
            CellState.BLACK -> CellState.WHITE
            CellState.WHITE -> CellState.EMPTY
        }
        board.table[row][col] = newState
        delegate?.handleEvent(CellChangedEvent(row, col, prevState, newState))
    }

    fun getCellState(row: Int, col: Int): CellState {
        return board.table[row][col]
    }

    interface Delegate {
        fun handleEvent(event: GameEvent)
    }
}