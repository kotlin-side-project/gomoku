package game.logic

import game.model.CellChangedEvent
import game.model.CellState
import game.model.GameEvent
import game.model.GomokuBoard

class GameLogic(private val delegate: Delegate) {
    private val board = GomokuBoard(arrayOf(arrayOf(CellState.EMPTY)))

    fun move(row: Int, col: Int) {
        val prevState = board.table[row][col]
        val newState = when (prevState) {
            CellState.EMPTY -> CellState.BLACK
            CellState.BLACK -> CellState.WHITE
            CellState.WHITE -> CellState.EMPTY
        }
        board.table[row][col] = newState
        delegate.handleEvent(CellChangedEvent(row, col, prevState, newState))
    }

    interface Delegate {
        fun handleEvent(event: GameEvent)
    }
}