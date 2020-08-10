import game.controller.GameController
import org.w3c.dom.HTMLDivElement
import kotlin.browser.document

val gameController = GameController()

fun main() {
    document.addEventListener("DOMContentLoaded", { _ ->
        gameController.mount()
    })
    drawDots()
}

fun drawDots() {
    document.addEventListener("DOMContentLoaded", { _ ->
        val body = document.body!!

        val rect = document.createElement("div") as HTMLDivElement

        rect.classList.add("rect")

        val background = document.createElement("div") as HTMLDivElement

        background.classList.add("background")

        rect.appendChild(background)

        val playground = document.createElement("div") as HTMLDivElement

        playground.classList.add("playground")

        rect.appendChild(playground)

        for (x in 1..15) {
            for (y in 1..15) {
                val dot = document.createElement("div") as HTMLDivElement

                dot.classList.add("dot")

                dot.style.apply {
                    top = "${28 + (x - 1) * 68}px"
                    left = "${28 + (y - 1) * 68}px"
                }

                if (y != 15) {
                    dot.classList.add("right")
                }

                if (x != 15) {
                    dot.classList.add("bottom")
                }

                background.appendChild(dot)

                val point = document.createElement("div") as HTMLDivElement

                point.classList.add("point")

                point.style.apply {
                    top = "${14 + (x - 1) * 68}px"
                    left = "${14 + (y - 1) * 68}px"
                }

                playground.appendChild(point)
            }
        }

        body.appendChild(rect)
    })
}