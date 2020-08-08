package game.model

import kotlin.test.*

internal class GameRoundTest {
    @Test
    fun doesNotAllowMoveOnCellAlreadyFilled() {
        val round = GameRound()

        assertEquals(round.getCellState(0, 0), CellState.EMPTY)
        round.move(0, 0)
        assertEquals(round.getCellState(0, 0), CellState.BLACK)
        round.move(0, 0)
        assertEquals(round.getCellState(0, 0), CellState.BLACK)
    }

    @Test
    fun takeTurns() {
        val round = GameRound()

        round.move(0, 0)
        assertEquals(round.getCellState(0, 0), CellState.BLACK)
        round.move(0, 1)
        assertEquals(round.getCellState(0, 1), CellState.WHITE)
    }
}
