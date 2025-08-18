package com.example.snakegame

class Food {
    companion object {
        var posX = 500f
        var posY = 500f

        fun generate() {
            var found = false
            //Need to make sure that the food isn't in the same position as it is right now and
            //that it isn't inside the snake
            var newposX = 0f
            var newposY = 0f
            while (!found) {
                //Set found to true
                found = true
                //And then generate a new position
                newposX = (1..12).random().toFloat() * 50
                newposY = (1..12).random().toFloat() * 50
                //this means the food is in the same spot and we need to generate a new spot
                if ((newposX == posX) && (newposY == posY)) {
                    found = false
                }
                //now check and make sure food isn't in the snake
                for (i in Snake.bodyParts){
                    if ((i[0] == newposX) && (i[1] == newposY)) {
                        found = false
                    }
                }
            }
            //Once we break out of the loop we just keep going
            posX = newposX
            posY = newposY
        }
    }
}