package com.example.snakegame

class Snake {
    companion object {
        // default: just one body part
        var headX = 0f
        var headY = 0f
        var nextheadX = 0f
        var nextheadY = 0f
        var bodyParts =
            mutableListOf(arrayOf(0f, 0f))
        var direction = "none";
        var alive = false;
        var restart = false;
        var numbodyParts = 1

        fun possibleMove(): Boolean {
            if (nextheadX < 0f || nextheadX > 650f || nextheadY < 0f || nextheadY > 650)
                return false
            return true
        }

        fun died() {
            alive = false
            restart = true
            //direction = "none"
        }

        fun reset() {
            headX = 0f;
            headY = 0f;
            nextheadX = 0f
            nextheadY = 0f
            bodyParts = mutableListOf(arrayOf(0f, 0f))
            direction = "none";
            numbodyParts = 1
            restart = false
        }
    }
}