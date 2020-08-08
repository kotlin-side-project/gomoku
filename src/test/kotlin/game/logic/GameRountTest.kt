package game.logic
import game.model.CellState
import kotlin.test.*

internal class GameRountTest {
    @Test
    fun move() {
        val round = GameRound()
        assertEquals(round.getCellState(0, 0), CellState.EMPTY)
        round.move(0, 0)
        assertEquals(round.getCellState(0, 0), CellState.BLACK)
        round.move(0, 0)
        assertEquals(round.getCellState(0, 0), CellState.WHITE)
        round.move(0, 0)
        assertEquals(round.getCellState(0, 0), CellState.EMPTY)
    }
}
