package game.model

enum class GamePlayer {
    BLACK, WHITE;

    val nextPlayer: GamePlayer
        get() = when (this) {
            BLACK -> WHITE
            WHITE -> BLACK
        }
}