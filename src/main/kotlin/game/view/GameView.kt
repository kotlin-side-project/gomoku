package game.view

import game.model.CellChangedEvent
import game.model.CellState
import kotlin.browser.*
import kotlinx.html.*
import kotlinx.html.dom.*
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLElement

private object C {
    object Cell {
        const val default = "cell"
        const val empty = "${default}__empty"
        const val black = "${default}__black"
        const val white = "${default}__white"
    }
}

// https://kotlinlang.org/docs/tutorials/javascript/typesafe-html-dsl.html
class GameView(private val delegate: Delegate?) {
    val element: HTMLElement = document.create.div {
        classes = mutableSetOf(C.Cell.default)
        onClickFunction = { _ ->
            delegate?.cellClicked(0, 0)
        }
    }

    fun updateCell(cellChangedEvent: CellChangedEvent) {
        element.classList.remove(C.Cell.empty, C.Cell.black, C.Cell.white)
        when (cellChangedEvent.newState) {
            CellState.EMPTY -> element.classList.add(C.Cell.empty)
            CellState.BLACK -> element.classList.add(C.Cell.black)
            CellState.WHITE -> element.classList.add(C.Cell.white)
        }
    }

    interface Delegate {
        fun cellClicked(row: Int, col: Int)
    }
}
