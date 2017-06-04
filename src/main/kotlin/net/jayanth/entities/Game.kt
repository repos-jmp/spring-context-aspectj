package net.jayanth.entities

/**
 * Created by jmp on 6/2/2017.
 */
interface Game {
    var homeTeam : Team
    var awayTeam : Team
    fun playGame() : String
}