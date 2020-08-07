package game.model

sealed class GameEvent

class CellChangedEvent(
    val row: Int,
    val col: Int,
    val prevState: CellState,
    val newState: CellState
): GameEvent()