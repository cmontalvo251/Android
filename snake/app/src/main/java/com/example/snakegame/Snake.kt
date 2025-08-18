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

        //This checks to see if there is a possible move available
        fun possibleMove(): Boolean {
            //First check and see if the head is at the boundary
            if ((nextheadX < 0f || nextheadX > 650f || nextheadY < 0f || nextheadY > 650)) {
                return false
            }
            //Next we need to check and see if the head has collided with the rest of the body
            var head = true
            for (i in bodyParts) {
                if (!head) {
                    if ((i[0] == nextheadX) && (i[1] == nextheadY)) {
                        return false
                    }
                }
                //Need to skip the head
                head = false
            }
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