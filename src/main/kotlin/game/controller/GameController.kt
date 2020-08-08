package game.controller

import game.model.GameRound
import game.model.GameEvent
import game.view.GameView
import kotlin.browser.document

class GameController {
    private val viewDelegate = GameViewDelegateImpl()
    private val coreDelegate = GameCoreDelegateImpl()
    private val view = GameView(viewDelegate)
    private val round = GameRound(coreDelegate)

    inner class GameViewDelegateImpl: GameView.Delegate {
        override fun cellClicked(row: Int, col: Int) {
            round.move(row, col)
        }
    }

    inner class GameCoreDelegateImpl: GameRound.Delegate {
        override fun handleEvent(event: GameEvent) {
            when (event) {
                is GameEvent.CellChanged -> {
                    view.updateCell(event)
                }
            }
        }
    }

    fun mount() {
        document.querySelector(".root")!!.appendChild(view.element)
    }
}
