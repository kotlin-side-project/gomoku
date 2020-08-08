package game.model

sealed class GameEvent {
    class CellChanged(
        val row: Int,
        val col: Int,
        val prevState: CellState,
        val newState: CellState
    ): GameEvent()
}
