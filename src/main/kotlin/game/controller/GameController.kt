package game.controller

import game.logic.GameLogic
import game.model.CellChangedEvent
import game.model.GameEvent
import game.view.GameView
import kotlin.browser.document

class GameController {
    private val viewDelegate = GameViewDelegateImpl()
    private val coreDelegate = GameCoreDelegateImpl()
    private val view = GameView(viewDelegate)
    private val core = GameLogic(coreDelegate)

    inner class GameViewDelegateImpl: GameView.Delegate {
        override fun cellClicked(row: Int, col: Int) {
            core.move(row, col)
        }
    }

    inner class GameCoreDelegateImpl: GameLogic.Delegate {
        override fun handleEvent(event: GameEvent) {
            when (event) {
                is CellChangedEvent -> {
                    view.updateCell(event)
                }
            }
        }
    }

    fun mount() {
        document.querySelector(".root")!!.appendChild(view.element)
    }
}