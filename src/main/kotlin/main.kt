import game.controller.GameController
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLImageElement
import org.w3c.dom.HTMLPictureElement
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

        rect.style.apply {
            border = "1px solid black"
            width = "1020px"
            height = "1020px"
            boxSizing = "border-box"
            display = "flex"
            flexDirection = "column"
            alignItems = "center"
            margin = "25vh auto"
        }

        val picture = document.createElement("picture") as HTMLPictureElement

        picture.style.apply {
            position = "relative"
        }

        val wood = document.createElement("img") as HTMLImageElement

        wood.setAttribute("src", "https://pixabay.com/get/57e8d3454c57a814f6d1867dda35367b1c39d9e65251784b_1920.jpg")
        wood.setAttribute("alt", "wood")
        wood.style.apply {
            objectFit = "cover"
            width = "1020px"
            height = "1020px"
        }

        picture.appendChild(wood)
        rect.appendChild(picture)

        for (x in 1..15) {
            for (y in 1..15) {
                val point = document.createElement("div") as HTMLDivElement

                point.style.apply {
                    position = "absolute"
                    top = "${x * 64}px"
                    left = "${y * 64}px"
                    height = "4px"
                    width = "4px"
                    backgroundColor = "white"
                }

                picture.appendChild(point)
            }
        }

        body.appendChild(rect)
    })
}