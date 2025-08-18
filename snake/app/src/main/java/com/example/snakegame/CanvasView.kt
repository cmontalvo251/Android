package com.example.snakegame

import android.view.View
import android.util.AttributeSet
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class CanvasView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val snakeBody = Paint()
        snakeBody.setColor(Color.GREEN)
        val food = Paint()
        food.setColor(Color.RED)
        val level = Paint()
        level.setColor(Color.DKGRAY)


        // draw level
        canvas?.drawRect(0f,0f,700f,700f,level) //Was 1050f

        // draw snake from array
        // left x, top y, right x+50, bottom y +50
        for (i in Snake.bodyParts){
            canvas?.drawRect(i[0], i[1], i[0]+45, i[1]+45, snakeBody)
        }

        // draw food from array
        // left x, top y, right x+50, bottom y +50
        canvas?.drawRect(Food.posX, Food.posY, Food.posX +45, Food.posY +45,food)

        //Give credit to the person who made this game
        val textPaint = Paint().apply {
            color = Color.WHITE // Or any color you want
            textSize = 30f     // Set the text size
            textAlign = Paint.Align.CENTER // Centers the text on the x-coordinate
        }
        if (Snake.direction == "none") {
            canvas?.drawText(
                "Credits to d-lehel @ Github:snake-android-game",
                350f,
                200f,
                textPaint
            )
        } else {
            //Otherwise include the score in the game
            canvas?.drawText(Snake.numbodyParts.toString(), 20f, 30f, textPaint)
        }
        if (Snake.restart) {
            canvas?.drawText("You have died. Press Reset to begin again", 350f, 200f, textPaint)
        }
    }
}